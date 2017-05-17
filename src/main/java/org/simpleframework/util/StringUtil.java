package org.simpleframework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * String 工具类
 * Created by Why on 2017/3/9.
 */
public final class StringUtil {
    private static final char UNDERLINE = '_';

    /**
     * 字符串分隔符
     */
    public static final String SEPARATOR = ",";

    /**
     * 判断字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    /**
     * 以分隔符合并字符数组
     */
    public static String join(String[] strArr, String regex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i < strArr.length - 1) {
                sb.append(regex);
            }
        }
        return sb.toString();
    }

    /**
     * 判断字符串是否非空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 根据字符串分隔符将字符串切分数组
     */
    public static String[] splitString(String str, String regex) {
        return str.split(regex);
    }

    /**
     * 将驼峰式字符串转为下划线风格
     */
    public static String camelToUnderline(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (c.isUpperCase(c)) {
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 将下划线风格字符串转为驼峰式
     */
    public static String underlineToCamel(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        boolean flag = false;
        for (Character c : chars) {
            if (c == UNDERLINE) {
                flag = true;
                continue;
            }
            if (flag) {
                sb.append(Character.toUpperCase(c));
                flag = false;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
