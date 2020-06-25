package com.students.springbootstu.util;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * json工具类
 */
public class JSONUtil {
    /**
     * 对象转JSON字符串
     *
     * @param object
     */
    public static String toJsonString(Object object){
        return toJsonString(object, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 对象转JSON字符串
     *
     * @param object 对象
     * @param dateFormat 时间格式
     */
    public static String toJsonString(Object object, String dateFormat){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new SimpleDateFormat(dateFormat));
        // 为了使JSON视觉上的可读性，增加一行如下代码，注意，在生产中不需要这样，因为这样会增大Json的内容
        // mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        // 配置mapper忽略空属性 默认不忽略
        // mapper.setSerializationInclusion(Include.NON_EMPTY);

        String jsonString = null;
        try{
            jsonString = mapper.writeValueAsString(object);

        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return jsonString;
    }

    /**
     * JSON字符串转对象
     * @param json 字符串
     * @param clazz 对象
     * @return 返回clazz
     */
    public static <T> T toObject(String json, Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        try{
           return mapper.readValue(json, clazz);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * json字符串转指定对象
     *
     * @param json
     * @return
     */
   public static Map<String, Object> toMap(String json){
       ObjectMapper mapper = buildObjectMapper();
       try{
           JavaType javaType = mapper
                   .getTypeFactory()
                   .constructParametrizedType(LinkedHashMap.class, Map.class, new Class[]{String.class, Object.class});
           return (Map<String, Object>) mapper.readValue(json, javaType);
       }catch (Exception e){
           throw new RuntimeException(e);
       }
    }

    /**
     * json字符串转list
     *
     */
    public static<T> List<T> toList(String json, Class<T> clazz){
        ObjectMapper mapper = new ObjectMapper();
        try{
            JavaType javaType = mapper
                    .getTypeFactory()
                    .constructCollectionType(List.class, clazz);
            return (List<T>) mapper.readValue(json, javaType);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public static ObjectMapper buildObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        // 当反序列化json时，未知属性会引起的反序列化被打断，这里我们禁用未知属性打断反序列化功能，
        // 因为，例如json里有10个属性，而我们的bean中只定义了2个属性，其它8个属性将被忽略
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }
}
