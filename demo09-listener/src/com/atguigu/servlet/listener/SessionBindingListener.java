package com.atguigu.servlet.listener;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/**
 * @author LiHongFei
 * @since 2024/5/16
 */
public class SessionBindingListener implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 当前监听器实例放入某个session中作为数据   绑定
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        // 当前监听器实例从某个session中移除     解绑定
    }
}
