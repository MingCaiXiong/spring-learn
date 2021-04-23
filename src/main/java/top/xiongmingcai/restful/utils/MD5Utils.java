package top.xiongmingcai.restful.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
    public static String md5Digest(String source, Integer salt) {
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + salt);

        }
        String target = new String(chars);
        return DigestUtils.md5Hex(target);
    }
}
