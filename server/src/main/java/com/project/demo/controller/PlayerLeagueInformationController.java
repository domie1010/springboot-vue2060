package com.project.demo.controller;

import com.project.demo.entity.PlayerLeagueInformation;
import com.project.demo.service.PlayerLeagueInformationService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 玩家拼团信息：(PlayerLeagueInformation)表控制层
 *
 */
@RestController
@RequestMapping("/player_league_information")
public class PlayerLeagueInformationController extends BaseController<PlayerLeagueInformation, PlayerLeagueInformationService> {

    /**
     * 玩家拼团信息对象
     */
    @Autowired
    public PlayerLeagueInformationController(PlayerLeagueInformationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(player_league_information_id) AS max FROM "+"`player_league_information`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `player_team` INNER JOIN `player_league_information` ON player_team.script_name=player_league_information.script_name WHERE player_team.number_of_people_remaining < player_league_information.number_of_groups AND player_league_information.player_league_information_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"player_league_information"+" WHERE "+"player_league_information_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"拼团已满");
        }
        sql = "UPDATE `player_team` INNER JOIN `player_league_information` ON player_team.script_name=player_league_information.script_name SET player_team.number_of_people_remaining= player_team.number_of_people_remaining - player_league_information.number_of_groups WHERE player_league_information.player_league_information_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
