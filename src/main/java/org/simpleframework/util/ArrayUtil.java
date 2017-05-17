package org.simpleframework.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 数组工具类
 * Created by Why on 2017/3/9.
 */
public final class ArrayUtil {
    /**
     * 判断数组是否为空
     */
    public static boolean isNotEmpty(Object[] array) {
        return !ArrayUtils.isEmpty(array);
    }

    /**
     * 判断数组是否为空
     */
    public static boolean isEmpty(Object[] array) {
        return ArrayUtils.isEmpty(array);
    }
}
