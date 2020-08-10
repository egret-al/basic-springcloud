package com.springcloud.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/7 10:52
 */
public class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * json字符串转JsonNode对象
     * @param str
     * @return
     */
    public static JsonNode stringToJsonNode(String str) {
        try {
            return OBJECT_MAPPER.readTree(str);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}
