package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 优质店铺：(QualityStore)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "QualityStore")
public class QualityStore implements Serializable {

    // QualityStore编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quality_store_id")
    private Integer quality_store_id;

    // 店铺名称
    @Basic
    private String store_name;
    // 店铺地址
    @Basic
    private String store_address;
    // 人均价格
    @Basic
    private Integer per_capita_price;
    // 店铺描述
    @Basic
    private String store_description;
    // 店铺封面
    @Basic
    private String shop_cover;
    // 店铺简介
    @Basic
    private String shop_introduction;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
