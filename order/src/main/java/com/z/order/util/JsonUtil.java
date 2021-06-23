package com.z.order.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {
    private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
        return null;
    }

    public static <T> T toObj(String jsonStr, Class<T> valueType) {
        try {
            return mapper.readValue(jsonStr, valueType);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }

        return null;
    }
}
