package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 购买信息：(PurchaseInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PurchaseInformation")
public class PurchaseInformation implements Serializable {

    // PurchaseInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_information_id")
    private Integer purchase_information_id;

    // 剧本名称
    @Basic
    private String script_name;
    // 剧本类型
    @Basic
    private String script_type;
    // 剧本价格
    @Basic
    private Integer script_price;
    // 购买用户
    @Basic
    private Integer purchase_user;
    // 用户姓名
    @Basic
    private String user_name;
    // 用户电话
    @Basic
    private String user_phone;
    // 购买时间
    @Basic
    private Timestamp purchase_time;




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
