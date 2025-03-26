package com.project.demo.controller;

import com.project.demo.entity.ScriptCollage;
import com.project.demo.service.ScriptCollageService;
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
 * 剧本拼团：(ScriptCollage)表控制层
 *
 */
@RestController
@RequestMapping("/script_collage")
public class ScriptCollageController extends BaseController<ScriptCollage, ScriptCollageService> {

    /**
     * 剧本拼团对象
     */
    @Autowired
    public ScriptCollageController(ScriptCollageService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
