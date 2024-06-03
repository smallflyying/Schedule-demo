package com.atguigu.schedule.service;

import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * 该接口定义了sys_schedule表格为核心的业务处理功能
 * @author LiHongFei
 * @since 2024/5/12
 */
public interface SysScheduleService {
    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule sysSchedule);

    Integer removeSchedule(int sid);
}
