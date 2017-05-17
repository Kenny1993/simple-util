package org.simpleframework.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 编解码工具类
 * Created by Why on 2017/3/9.
 */
public final class CodecUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    /**
     * 将 URL 编码
     */
    public static String encodeURL(String source, String encoding) {
        try {
            return URLEncoder.encode(source, encoding);
        } catch (Exception e) {
            LOGGER.debug("encode url failure", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 将 URL 解码
     */
    public static String decodeURL(String source, String encoding) {
        try {
            return URLDecoder.decode(source, encoding);
        } catch (Exception e) {
            LOGGER.debug("decode url failure", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * MD5 加密
     */
    public static String md5(String source) {
        return DigestUtils.md5Hex(source);
    }
}
