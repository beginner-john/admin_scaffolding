package com.generic.admin_scaffolding.utils;

import java.security.SecureRandom;

/**
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/19 10:04
 */
public class RandomString {

    /**
     * 每位允许的字符
     */
	private static final String POSSIBLE_CHARS="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /**
     * 生产一个指定长度的随机字符串
     * @param length 字符串长度
     * @return
     */
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(POSSIBLE_CHARS.charAt(random.nextInt(POSSIBLE_CHARS.length())));
        }
        return sb.toString();
    }

    /**
     * 生产一个指定长度的随机字符串
     * 数字
     * @param length 字符串长度
     * @return
     */
    public static String generateRandomNumber(int length) {
        StringBuilder sb = new StringBuilder(length);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
