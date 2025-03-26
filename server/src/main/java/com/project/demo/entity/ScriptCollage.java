package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 剧本拼团：(ScriptCollage)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ScriptCollage")
public class ScriptCollage implements Serializable {

    // ScriptCollage编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "script_collage_id")
    private Integer script_collage_id;

    // 剧本名称
    @Basic
    private String script_name;
    // 剧本类型
    @Basic
    private String script_type;
    // 剧本价格
    @Basic
    private Integer script_price;
    // 拼团人数
    @Basic
    private Integer number_of_participants;
    // 剩余人数
    @Basic
    private Integer number_of_people_remaining;
    // 拼团须知
    @Basic
    private String instructions_for_teamwork;
    // 封面图片
    @Basic
    private String cover_photo;
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
