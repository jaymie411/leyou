package com.leyou.common.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: HuYi.Zhang
 * @create: 2018-04-24 17:20
 **/
public class JsonUtils {

    public static final ObjectMapper mapper = new ObjectMapper();

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static String toString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj.getClass() == String.class) {
            return (String) obj;
        }
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            logger.error("json序列化出错：" + obj, e);
            return null;
        }
    }

    public static <T> T toBean(String json, Class<T> tClass) {
        try {
            return mapper.readValue(json, tClass);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <E> List<E> toList(String json, Class<E> eClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, eClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <K, V> Map<K, V> toMap(String json, Class<K> kClass, Class<V> vClass) {
        try {
            return mapper.readValue(json, mapper.getTypeFactory().constructMapType(Map.class, kClass, vClass));
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    public static <T> T nativeRead(String json, TypeReference<T> type) {
        try {
            return mapper.readValue(json, type);
        } catch (IOException e) {
            logger.error("json解析出错：" + json, e);
            return null;
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User{
        String name;
        Integer age;
    }
    
    public static void main(String[] args) {
    	User user = new User("jaymie",25);
    	String json = toString(user);
        System.out.println("json = " + json);

        User user1 = toBean(json, User.class);
        System.out.println("user1 = " + user1);

        String json1 = "[10,20,-5,1]";
        List<Integer> list = toList(json1, Integer.class);
        System.out.println("list = " + list);

        String json2 = "{\n" +
                "  \"name\": \"jack\",\n" +
                "  \"age\": \"21\"\n" +
                "}";
        Map<String, String> map = toMap(json2, String.class, String.class);
        System.out.println("map = " + map);

        String json3 = "[{\n" +
                "  \"name\": \"jack\",\n" +
                "  \"age\": \"21\"\n" +
                "}," +
                "{\n" +
                "  \"name\": \"jaymie\",\n" +
                "  \"age\": \"25\"\n" +
                "}]";
        List<Map<String, String>> mapList = nativeRead(json3, new TypeReference<List<Map<String, String>>>() {
        });
        for (Map<String, String> map1 : mapList) {
            System.out.println("map1 = " + map1);
        }
    }
}
