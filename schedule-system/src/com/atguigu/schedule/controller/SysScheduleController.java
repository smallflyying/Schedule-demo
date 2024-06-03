package com.atguigu.schedule.controller;

import com.atguigu.schedule.common.Result;
import com.atguigu.schedule.pojo.SysSchedule;
import com.atguigu.schedule.service.SysScheduleService;
import com.atguigu.schedule.service.impl.SysScheduleServiceImpl;
import com.atguigu.schedule.util.WebUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 增加日程的请求   /schedule/add
 * 查询日程的请求  /schedule/find
 * 修改日程的请求  /schedule/update
 * 删除日程的请求  /schedule/remove
 * 。。。。
 *  , name = "scheduleServlet"
 *
 *
 * @author LiHongFei
 * @since 2024/5/12
 */
@WebServlet(value = "/schedule/*")
public class SysScheduleController extends BaseController {
    private SysScheduleService scheduleService = new SysScheduleServiceImpl();

    protected void removeSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int sid = Integer.parseInt(req.getParameter("sid"));
        // 调用服务层方法 删除数据
        scheduleService.removeSchedule(sid);
        // 响应 成功信息

        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void updateSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求体中的JSON串 转换成一个SysSchedule
        SysSchedule sysSchedule = WebUtil.readJson(req, SysSchedule.class);
        // 调用服务层方法，将信息更新进入数据
        scheduleService.updateSchedule(sysSchedule);

        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void addDefaultSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));
        // 调用服务层方法，向数据库中 增加一条空记录
        scheduleService.addDefault(uid);

        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void findAllSchedule(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收请求中的uid参数
        int uid = Integer.parseInt(req.getParameter("uid"));

        // 查询用户的所有日程
        List<SysSchedule> itemList = scheduleService.findItemListByUid(uid);

        // 将用户的所有日程放入一个Result对象
        Map data = new HashMap<>();
        data.put("itemList",itemList);

        Result result = Result.ok(data);
        // 将Result对象转换为json响应给客户端
        WebUtil.writeJson(resp,result);
    }
}
