package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 剧本拼团信息：(ScriptCollaborationInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ScriptCollaborationInformation")
public class ScriptCollaborationInformation implements Serializable {

    // ScriptCollaborationInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "script_collaboration_information_id")
    private Integer script_collaboration_information_id;

    // 剧本名称
    @Basic
    private String script_name;
    // 剧本类型
    @Basic
    private String script_type;
    // 剧本价格
    @Basic
    private Integer script_price;
    // 拼团用户
    @Basic
    private Integer group_user;
    // 用户姓名
    @Basic
    private String user_name;
    // 拼团数量
    @Basic
    private String number_of_groups;
    // 拼团时间
    @Basic
    private Timestamp group_time;




    // 支付状态
    @Basic
    private String pay_state;

    // 支付类型: 微信、支付宝、网银
    @Basic
    private String pay_type;










    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
