package com.atguigu.schedule.pojo;

import lombok.*;

/**
 * 1.实体类的类名和表格名称应该对应（对应不是一致）
 * 2.实体类的属性名和表格的列名应该对应
 * 3.每个属性都必须是私有的
 * 4.每个属性都应该具有 getter setter
 * 5.必须具备无参构造器
 * 6.应该实现序列化接口（缓存 分布式项目数据传输 可能会将对象序列化）
 * 7.应该重写类的hashCode和equals方法
 * 8.toString是否重写都可以
 *
 *
 * 使用lombok帮助我们生成这些内容 getter setter 全残构造器 无参构造 equals hashcode
 *  Lombok 使用步骤
 *      1.检查idea是否已经安装了Lombok插件
 *      2.检查是否勾选了enable annotation processing
 *      3.导入lombok的依赖
 *      3.在实体类上添加注解
 *
 * @author LiHongFei
 * @since 2024/5/10
 */

@AllArgsConstructor  // 添加了全参构造
@NoArgsConstructor // 添加了无参构造
@Data  // getter setter equals hashcode toString
public class SysUser {

    private Integer uid;
    private String username;
    private String userPwd;


}
