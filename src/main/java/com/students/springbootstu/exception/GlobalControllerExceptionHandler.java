package com.students.springbootstu.exception;

import com.students.springbootstu.common.ResponseResult;
import com.students.springbootstu.entity.TbException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import com.students.springbootstu.service.TbExceptionService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.StringJoiner;

/**
 *处理全局异常
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @Resource
    private TbExceptionService  tbExceptionService;

    /**
     * 业务异常
     */
    @ExceptionHandler(value = {BusinessException.class})
    public ResponseResult<?> handleBusinessException(BusinessException ex){
        String msg = ex.getMessage();
        if(StringUtils.isBlank(msg)){
            msg = "操作失败";
        }
        return ResponseResult.error(msg);
    }

    /**
     * 未登录异常
     */
    @ExceptionHandler(value = {NoneLoginException.class})
    public ResponseResult<?> handleNoneLoginException(NoneLoginException ex) {
        return ResponseResult.unLogin();
    }

    /**
     * 处理校验异常
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public ResponseResult<?> handleValidationException(Exception ex){
        BindingResult bindingResult = null;
        //MethodArgumentNotValidException为@RequestBody（POST方式/ajax进行提交的json数据，对应实体类）+@valid方式验证
        if(ex instanceof MethodArgumentNotValidException){
            bindingResult = ((MethodArgumentNotValidException) ex).getBindingResult();
        }else if(ex instanceof BindException){
            //BindException @Valid 来封装参数并校验
            bindingResult = ((BindException) ex).getBindingResult();
        }
        if(bindingResult.hasErrors()){
            StringJoiner erroMsg = new StringJoiner(",");
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(error -> {
                FieldError fieldError = (FieldError) error;
                erroMsg.add(fieldError.getField() + "-" + fieldError.getDefaultMessage());
                log.error(fieldError.getField() + "-" + fieldError.getDefaultMessage());
            });
            return ResponseResult.error(erroMsg.toString());
        }else{
            return  ResponseResult.error("操作失败，检查输入的字符");
        }
    }

    /**
     * 处理未知错误
     */
    @ExceptionHandler(value = {Exception.class})
    public ResponseResult<Integer> handleUnKnownException(Exception ex){
        TbException log = new TbException(new Date(), ExceptionUtils.getStackTrace(ex));
        System.out.print(ExceptionUtils.getStackTrace(ex));
        int id = tbExceptionService.insert(log); //返回1表示成功
        ResponseResult<Integer> result = ResponseResult.unknownError("服务器异常" + log.getId());
        result.setData(log.getId());
        return result;
    }
}
