package com.atguigu.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author LiHongFei
 * @since 2024/5/12
 */
public class BaseController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        String[] split = requestURI.split("/");
        String methodName = split[split.length-1];
        // 使用 反射 通过方法名称获取下面的方法（通过反射获取要执行的方法）
        Class aClass = this.getClass();
        // 获取方法
        try {
            Method declaredMethod = aClass.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            //暴力 破解方法的访问修饰符的限制（设置方法可以访问）
            declaredMethod.setAccessible(true);

            // 执行方法(通过反射执行代码)
            declaredMethod.invoke(this,req,resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
