package com.project.demo.controller;

import com.project.demo.entity.QualityStore;
import com.project.demo.service.QualityStoreService;
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
 * 优质店铺：(QualityStore)表控制层
 *
 */
@RestController
@RequestMapping("/quality_store")
public class QualityStoreController extends BaseController<QualityStore, QualityStoreService> {

    /**
     * 优质店铺对象
     */
    @Autowired
    public QualityStoreController(QualityStoreService service) {
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
