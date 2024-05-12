package com.atguigu.schedule.dao;

import com.atguigu.schedule.pojo.SysUser;

/**
 * Data access Object 数据访问对象
 * 该类中用于定义针对表格的CRUD的方法
 * DAO层一般需要定义接口和实现类
 * @author LiHongFei
 * @since 2024/5/12
 */
public interface SysUserDao {


    /**
     * 向数据库中增加一条用户记录的方法
     * @param sysUser 要增加的记录的username和user_pwd字段以SysUser实体类对象的形式接收
     * @return 增加成功返回1 增加失败返回0
     */
    int addSysUser(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     * @param username 要查询的用户名
     * @return 如果找到了返回SysUser对象，找不到返回null
     */
    SysUser findByUsername(String username);
}
