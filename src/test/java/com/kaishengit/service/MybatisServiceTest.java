package com.kaishengit.service;

import com.kaishengit.entity.Mybatis;
import com.kaishengit.service.Impl.MybatisServiceImpl;
import com.kaishengit.service.Test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by 蔡林红 on 2017/10/31.
 */

public class MybatisServiceTest extends BaseTest {

    @Autowired
     private MybatisServiceImpl mybatisService;

    @Test
     public  void findById(){
        Mybatis mybatis= mybatisService.findById(3512);
      System.out.println(mybatis);
    }
    @Test
    public void save(){
         Mybatis mybatis= new Mybatis();
         mybatis.setName("xii");
         mybatis.setAge(23);
         mybatis.setClsId(2);
         mybatisService.save(mybatis);
    }

}