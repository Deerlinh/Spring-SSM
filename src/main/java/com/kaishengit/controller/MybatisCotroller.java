package com.kaishengit.controller;

import com.kaishengit.entity.Mybatis;
import com.kaishengit.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 蔡林红 on 2017/11/3.
 */

@Controller
public class MybatisCotroller {

    @Autowired
    private MybatisService mybatisService;

    @GetMapping("/list/{id:\\d+}")
    @ResponseBody
    public Mybatis find(@PathVariable  Integer id){
        Mybatis mybatis=mybatisService.findById(id);
        return mybatis;
    }
    @GetMapping("list")
    @ResponseBody
    public List<Mybatis> page(@RequestParam(required = false,defaultValue = "1",name="p") Integer pageNo){
        return mybatisService.finfByPageNO(pageNo);
    }
}



