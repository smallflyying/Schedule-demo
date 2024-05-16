package com.atguigu.servlet.listener;

import jakarta.servlet.http.HttpSessionActivationListener;
import jakarta.servlet.http.HttpSessionEvent;

/**
 * @author LiHongFei
 * @since 2024/5/16
 */
public class MyActivationListener implements HttpSessionActivationListener {

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        // session 对象即将进行钝化之前执行
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        // session  活化完毕之后执行
    }
}
