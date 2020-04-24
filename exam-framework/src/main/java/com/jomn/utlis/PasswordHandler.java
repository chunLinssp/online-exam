package com.jomn.utlis;

import com.jomn.domain.SysUser;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 加密工具
 * 生成随机salt
 * 注册生成的密码
 */

public class PasswordHandler {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    /**
     * 满足shiro 用户凭证器
     */
    private static String algorithmName = "md5";
    private static final int hashIterations = 2;

    public static void encryptPassword(SysUser user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                hashIterations).toHex();
        user.setPassword(newPassword);
    }

//    public static void main(String[] args) {
//        String salt = randomNumberGenerator.nextBytes().toHex();
//        String newPassword = new SimpleHash(
//                algorithmName,
//                "123",
//                ByteSource.Util.bytes(salt),
//                hashIterations).toHex();
//        System.out.println(newPassword);
//        System.out.println(salt);
//    }

}
