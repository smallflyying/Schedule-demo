package com.atguigu.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日志过滤器 记录请求的历史 将日志打印到控制台
 *
 *  1.实现filter接口
 *  2.重写过滤方法
 *  3.配置过滤器
 *      web.xml
 *      注解
 * @author LiHongFei
 * @since 2024/5/14
 */
public class LoggingFilter implements Filter {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /*
        过滤请求的和响应的方法
            1.请求到达目标资源之前，先经过该方法
            2.该方法有能力控制请求是否继续向后到达目标资源 可以在该方法内直接向客户端作响应处理
            3.请求到达目标资源后，响应之前，还会经过该方法
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


        /**
         * 1.请求到达目标资源之前的功能代码
         *      判断是否登录
         *      校验权限是否满足
         *      。。。
         * 2.放行代码
         *
         * 3.响应之前 HttpServletResponse 转换为响应报文之前 的功能代码
         */

        // 参数父转子
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 请求到达目标资源之前  打印日志   yyyy-MM-dd HH:mm:ss  **被访问了
        //System.out.println("loggingFilter before filterChain.doFilter invoked");
        String requestURI = request.getRequestURI();
        String dateTime = dateFormat.format(new Date());
        String  beforeLogging = requestURI + "在" + dateTime + "被访问了";
        System.out.println(beforeLogging);

        long t1 = System.currentTimeMillis();
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        long t2 = System.currentTimeMillis();

        // 响应之前的功能代码   **资源 在yyyy-MM-dd HH:mm:ss 的请求 耗时  毫秒
        //System.out.println("loggingFilter after filterChain.doFilter invoked");
        String afterLogging = requestURI + "资源在" + dateTime + "的请求耗时:" + (t2-t1) + "毫秒";
        System.out.println(afterLogging);

    }
}
