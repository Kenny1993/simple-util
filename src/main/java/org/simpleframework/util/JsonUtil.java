package org.simpleframework.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Json 工具类
 * Created by Why on 2017/3/9.
 */
public final class JsonUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        OBJECT_MAPPER.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
    }

    public static <T extends Serializable> String toJson(T obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.debug("convert POJO to JSON failure", e);
            throw new RuntimeException(e);
        }
    }

    public static <T extends Serializable> String toJson(List<T> obj) {
        try {
            return OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            LOGGER.debug("convert POJO list to JSON failure", e);
            throw new RuntimeException(e);
        }
    }

    public static <T> T fromJson(Class<T> cls, String json) {
        try {
            return OBJECT_MAPPER.readValue(json, cls);
        } catch (IOException e) {
            LOGGER.debug("convert JSON to POJO failure", e);
            throw new RuntimeException(e);
        }
    }
}
