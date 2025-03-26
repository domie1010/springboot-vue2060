package com.project.demo.controller;

import com.project.demo.entity.ScriptCollaborationInformation;
import com.project.demo.service.ScriptCollaborationInformationService;
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
 * 剧本拼团信息：(ScriptCollaborationInformation)表控制层
 *
 */
@RestController
@RequestMapping("/script_collaboration_information")
public class ScriptCollaborationInformationController extends BaseController<ScriptCollaborationInformation, ScriptCollaborationInformationService> {

    /**
     * 剧本拼团信息对象
     */
    @Autowired
    public ScriptCollaborationInformationController(ScriptCollaborationInformationService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(script_collaboration_information_id) AS max FROM "+"`script_collaboration_information`";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = ("SELECT count(*) count FROM `script_collage` INNER JOIN `script_collaboration_information` ON script_collage.script_name=script_collaboration_information.script_name WHERE script_collage.number_of_people_remaining < script_collaboration_information.number_of_groups AND script_collaboration_information.script_collaboration_information_id="+max).replaceAll("&#60;","<");
        select = service.runCountSql(sql);
        Integer count = Integer.valueOf(String.valueOf(select.getSingleResult()));
        if(count>0){
            sql = "delete from "+"script_collaboration_information"+" WHERE "+"script_collaboration_information_id"+" ="+max;
            select = service.runCountSql(sql);
            select.executeUpdate();
            return error(30000,"拼团已满");
        }
        sql = "UPDATE `script_collage` INNER JOIN `script_collaboration_information` ON script_collage.script_name=script_collaboration_information.script_name SET script_collage.number_of_people_remaining= script_collage.number_of_people_remaining - script_collaboration_information.number_of_groups WHERE script_collaboration_information.script_collaboration_information_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
