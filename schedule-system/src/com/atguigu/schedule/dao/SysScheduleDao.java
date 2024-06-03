package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * 介绍一下当前类。。。。。。。
 * 作者：
 * 时间：。。。。。
 * @author LiHongFei
 * @since 2024/5/12
 */
public interface SysScheduleDao {

    /**
     * 用于向数据库中增加一条日程记录
      * @param sysSchedule 日程数据以SysSchedule实体类对象形式入参
     * @return 返回影响数据库记录的行数，行数为0说明添加失败，行数大于0说明添加成功
     */
    int addSchedule(SysSchedule sysSchedule);

    /**
     * 查询所有用户的所有日出
     * @return 将所有日程放入一个：List<SysSchedule>集合中返回
     */
    List<SysSchedule> findAll();

    List<SysSchedule> findItemListByUid(int uid);

    Integer addDefault(int uid);

    Integer updateSchedule(SysSchedule sysSchedule);

    Integer removeSchedule(int sid);
}
