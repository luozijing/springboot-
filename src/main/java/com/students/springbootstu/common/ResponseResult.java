package com.students.springbootstu.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *前端用ajax请求的的响应工具类
 * **/
@Data
@ApiModel(value = "返回类")
public class ResponseResult<T> {
    //用户未登录
    public static final String UN_LOGIN_CODE = "401";
    //客户端操作失败
    public static final String ERROR_CODE = "400";
    //服务器内部错误
    public static final String UNKNOWN_ERROR_CODE = "500";
    //操作成功
    public static final String SUCCESS_CODE = "200";
    //资源未找到
    public static final String RESOURCE_NOT_EXIST_CODE = "200";
    //响应信息
    @ApiModelProperty(value = "返回信息")
    private String message;
    //响应码
    @ApiModelProperty(value = "响应码")
    private String code;
    //响应数据
    @ApiModelProperty(value = "学生数据")
    private T data;

    public ResponseResult(String code, String message, T data){
        this.message = message;
        this.code = code;
        this.data = data;
    }

    /**
     *创建一个成功的响应对象
     * @param data responseDate
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> success(T data){
       return new ResponseResult<T>(SUCCESS_CODE,"请求成功", data);
    }

    /**
     *创建一个成功的响应对象
     * @return ResponseResult
     */
    public static  ResponseResult<String> success(){
        return success(null);
    }

    /**
     *创建一个失败的响应对象
     * @param errorMsg errorMessage
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> error(String errorMsg){
        return new ResponseResult<T>(ERROR_CODE, errorMsg, null);
    }

    /**
     *创建一个服务器内部错误的响应对象
     * @param errorMsg errorMessage
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> unknownError(String errorMsg){
        return new ResponseResult<T>(UNKNOWN_ERROR_CODE, errorMsg, null);
    }

    /**
     *创建一个未登录的响应对象
     * @return ResponseResult
     */
    public static <T> ResponseResult<T> unLogin(){
        return new ResponseResult<T>(UN_LOGIN_CODE, "未登录", null);
    }
}
