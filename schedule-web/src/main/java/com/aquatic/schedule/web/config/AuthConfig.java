package com.aquatic.schedule.web.config;

import sun.security.provider.MD5;

/**
 * @className: com.aquatic.schedule.web.config.AuthConfig
 * @description: 授权配置
 * @author: wanghao/haozixiaowang@163.com
 * @date: 2017/11/30 13:21
**/
public abstract class AuthConfig {
    public static final String KEY = "schedule-demo";

    public static String generateToken()
    {
        return KEY;
    }
}
