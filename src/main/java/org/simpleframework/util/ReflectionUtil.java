package org.simpleframework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具类
 * Created by Why on 2017/3/9.
 */
public final class ReflectionUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     */
    public static Object newInstance(Class<?> cls) {
        try {
            return cls.newInstance();
        } catch (Exception e) {
            LOGGER.error("new instance failure: " + cls.getName());
            throw new RuntimeException(e);
        }
    }

    /**
     * 创建实例
     */
    public static Object newInstance(String className) {
        try {
            return newInstance(Class.forName(className));
        } catch (ClassNotFoundException e) {
            LOGGER.error("no such class: " + className);
            throw new RuntimeException(e);
        }
    }

    /**
     * 调用方法
     */
    public static Object invokeMethod(Object obj, Method method, Object... args) {
        try {
            return method.invoke(obj, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置成员变量的值
     */
    public static void setField(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
