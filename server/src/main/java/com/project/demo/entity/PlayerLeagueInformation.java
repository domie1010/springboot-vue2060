package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 * 玩家拼团信息：(PlayerLeagueInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "PlayerLeagueInformation")
public class PlayerLeagueInformation implements Serializable {

    // PlayerLeagueInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_league_information_id")
    private Integer player_league_information_id;

    // 剧本名称
    @Basic
    private String script_name;
    // 剧本类型
    @Basic
    private String script_type;
    // 店铺地址
    @Basic
    private String store_address;
    // 发布用户
    @Basic
    private Integer publishing_users;
    // 拼团用户
    @Basic
    private Integer group_user;
    // 拼团数量
    @Basic
    private String number_of_groups;
    // 拼团时间
    @Basic
    private Timestamp group_time;














    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
