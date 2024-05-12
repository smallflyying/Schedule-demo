package com.atguigu.schedule.test;

import com.atguigu.schedule.util.MD5Util;
import org.testng.annotations.Test;

/**
 * MD5加密测试
 * @author LiHongFei
 * @since 2024/5/12
 */
public class TestMD5Util {

    @Test
    public void testEncrypt() {
        String encrypt = MD5Util.encrypt("123456");
        System.out.println(encrypt);
    }
}
