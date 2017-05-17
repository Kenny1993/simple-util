package org.simpleframework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * Field 工具类
 * Created by Why on 2017/3/22.
 */
public final class FieldUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(FieldUtil.class);

    /**
     * 获取所有声明成员
     */
    public static Field[] getFields(Class<?> cls) {
        return cls.getDeclaredFields();
    }

    /**
     * 获取单个成员
     */
    public static Field getField(Class<?> cls, String fieldName) {
        try {
            return cls.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            LOGGER.error(cls.getName() + " no such field: " + fieldName);
            throw new RuntimeException(e);
        }
    }
}
