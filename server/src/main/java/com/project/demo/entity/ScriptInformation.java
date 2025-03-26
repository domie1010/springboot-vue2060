package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 剧本信息：(ScriptInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ScriptInformation")
public class ScriptInformation implements Serializable {

    // ScriptInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "script_information_id")
    private Integer script_information_id;

    // 剧本名称
    @Basic
    private String script_name;
    // 剧本类型
    @Basic
    private String script_type;
    // 剧本价格
    @Basic
    private Integer script_price;
    // 剧本评分
    @Basic
    private String script_rating;
    // 剧本排行
    @Basic
    private Integer script_ranking;
    // 剧本描述
    @Basic
    private String script_description;
    // 剧本封面
    @Basic
    private String script_cover;
    // 剧本简介
    @Basic
    private String script_introduction;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
