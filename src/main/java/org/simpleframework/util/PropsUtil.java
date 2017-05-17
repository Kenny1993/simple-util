package org.simpleframework.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Properties属性文件工具类
 * Created by Why on 2017/3/9.
 */
public final class PropsUtil {
    private static Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    /**
     * 加载 properties 属性文件
     *
     * @param filename properties 属性文件名
     * @return
     */
    public static Properties load(String filename) {
        try {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(filename);
            Properties props = new Properties();
            props.load(in);
            return props;
        } catch (IOException e) {
            LOGGER.debug("load properties failure: " + filename);
            throw new RuntimeException("load properties failure: " + e);
        }
    }

    /**
     * 获取 properties 属性文件的 String 类型值，默认 “”
     *
     * @param props properties 属性文件对象
     * @param key   key值
     * @return
     */
    public static String getString(Properties props, String key) {
        return CastUtil.castString(props.get(key));
    }

    /**
     * 获取 properties 属性文件的 String 类型值，可指定默认值
     *
     * @param props properties 属性文件对象
     * @param key   key值
     * @return
     */
    public static String getString(Properties props, String key, String defaultValue) {
        return CastUtil.castString(props.get(key), defaultValue);
    }

    /**
     * 获取 properties 属性文件的 double 类型值，默认 0
     *
     * @param props properties 属性文件对象
     * @param key   key值
     * @return
     */
    public static int getInt(Properties props, String key) {
        return CastUtil.castInt(props.get(key));
    }

    /**
     * 获取 properties 属性文件的 double 类型值，可指定默认值
     *
     * @param props properties 属性文件对象
     * @param key   key值
     * @return
     */
    public static int getInt(Properties props, String key, int defaultValue) {
        return CastUtil.castInt(props.get(key), defaultValue);
    }

    /**
     * 获取 properties 属性文件的 double 类型值，默认 0
     *
     * @param props properties 属性文件对象
     * @param key   key值
     * @return
     */
    public static double getDouble(Properties props, String key) {
        return CastUtil.castDouble(props.get(key));
    }

    /**
     * 获取 properties 属性文件的 double 类型值，可指定默认值
     *
     * @param props properties 属性文件对象
     * @param key   key值
     * @return
     */
    public static double getDouble(Properties props, String key, double defaultValue) {
        return CastUtil.castDouble(props.get(key), defaultValue);
    }

    /**
     * 获取 properties 属性文件的 long 类型值，默认 0
     *
     * @param props properties 属性文件对象
     * @param key   key值
     * @return
     */
    public static long getLong(Properties props, String key) {
        return CastUtil.castLong(props.get(key));
    }

    /**
     * 获取 properties 属性文件的 long 类型值，可指定默认值
     *
     * @param props properties 属性文件对象
     * @param key   key值
     * @return
     */
    public static long getLong(Properties props, String key, long defaultValue) {
        return CastUtil.castLong(props.get(key), defaultValue);
    }

    /**
     * 获取 properties 属性文件的 boolean 类型值，默认 false
     *
     * @param props properties 属性文件对象
     * @param key   key值
     * @return
     */
    public static boolean getBoolean(Properties props, String key) {
        return CastUtil.castBoolean(props.get(key));
    }

    /**
     * 获取 properties 属性文件的 boolean 类型值，可指定默认值
     *
     * @param props properties 属性文件对象
     * @param key   key值
     * @return
     */
    public static boolean getBoolean(Properties props, String key, boolean defaultValue) {
        return CastUtil.castBoolean(props.get(key), defaultValue);
    }
}
