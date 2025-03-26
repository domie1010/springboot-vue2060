package com.project.demo.controller;

import com.project.demo.entity.PlayerTeam;
import com.project.demo.service.PlayerTeamService;
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
 * 玩家拼团：(PlayerTeam)表控制层
 *
 */
@RestController
@RequestMapping("/player_team")
public class PlayerTeamController extends BaseController<PlayerTeam, PlayerTeamService> {

    /**
     * 玩家拼团对象
     */
    @Autowired
    public PlayerTeamController(PlayerTeamService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        Map<String, String> mapscript_name = new HashMap<>();
        mapscript_name.put("script_name",String.valueOf(paramMap.get("script_name")));
        List listscript_name = service.select(mapscript_name, new HashMap<>()).getResultList();
        if (listscript_name.size()>0){
            return error(30000, "字段剧本名称内容不能重复");
        }
        this.addMap(paramMap);
        return success(1);
    }

}
