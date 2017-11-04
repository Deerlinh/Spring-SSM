package com.kaishengit.controller;

import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.Mybatis;
import com.kaishengit.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * Created by 蔡林红 on 2017/11/3.
 */

@Controller
@RequestMapping("/product")
public class MybatisCotroller {

    @Autowired
    private MybatisService mybatisService;

    @GetMapping
    public String list(@RequestParam(name = "p",required = false,defaultValue = "1") Integer pageNo,
                       @RequestParam(required = false,defaultValue = "")String productName,
                       @RequestParam(required = false,defaultValue = "")String place,
                       @RequestParam(required = false,defaultValue = "") Integer typeId,
                       Model model){
        Map<String,Object> queryParam= Maps.newHashMap();
        queryParam.put("productName",productName);
        queryParam.put("place",place);
        queryParam.put("typeId",typeId);
        PageInfo<Kaola> pageInfo=mybatisService.findByPageNo(pageNo,queryParam);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("placeList",mybatisService.findProductPlaceList());

        model.addAttribute("typeList",mybatisService.findByTypeAll());
       return "product/list";
    }

    @GetMapping("/new")
    public String newProcude(Model model){
        model.addAttribute("typeList",mybatisService.findByTypeAll());
        return "product/new";
    }
    @PostMapping("/new")
    public String newProcude(Kaola kaola, RedirectAttributes redirectAttributes){
        mybatisService.save(kaola);
        redirectAttributes.addFlashAttribute("message","添加商品成功");
        return "redirect:/product";
    }

    @GetMapping("/{id:\\d+}")
    public String showProcude(@PathVariable Integer id, Model model){
        Kaola kaola= mybatisService.findById(id);
        model.addAttribute("kaola",kaola);
        return "product/show";
    }

    @GetMapping("/{id:\\d+}/edit")
    public  String editProcude(@PathVariable Integer id, Model model){
        model.addAttribute("typeList",mybatisService.findByTypeAll());
        model.addAttribute("product",mybatisService.findById(id));
        return "product/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String editProcude(Kaola kaola,RedirectAttributes redirectAttributes){
    mybatisService.editKaola(kaola);
    redirectAttributes.addFlashAttribute("message","修改成功");
    return "redirect:/product/"+kaola.getId();
    }

    @GetMapping("/{id:\\d+}/delete")
    public String deleteProcude(@PathVariable Integer id,RedirectAttributes redirectAttributes){
        mybatisService.deleteKaola(id);
        redirectAttributes.addFlashAttribute("message","删除成功");
        return "redirect:/product";
    }
}



