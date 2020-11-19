package com.generic.admin_scaffolding.utils;

import org.springframework.util.DigestUtils;

/**
 * 自定义的MD5加密工具类
 *
 * @author xiong.bo
 * @version 1.0
 * @date 2020/11/19 10:38
 */
public class MD5Utils {


    /**
     * <p>加密规则：</p>
     * <p>key=原文+密钥, 将key用MD5加密的字符串,往StringBuilder添加指定的次数。
     * 最后将StringBuilder进行MD5加密一次,并返回,生成最终的加密后的值。
     * </p>
     * <p>注意，加密规则任何一值修改，则以前加密生成的密文，就失效了。<p>
     *
     * @param str 明文
     * @return
     */
    public static String encrypt(String str) {

        // 密钥,不随意更改，否则与之前的密码生成规则不一致了
        String salt = "scaffolding";
        String key = str + salt;
        StringBuilder buf = new StringBuilder();
        String digest = DigestUtils.md5DigestAsHex(key.getBytes());
        for (int i = 0; i < 5; i++) {
            buf.append(digest);
        }
        return DigestUtils.md5DigestAsHex(buf.toString().getBytes());
    }


}
