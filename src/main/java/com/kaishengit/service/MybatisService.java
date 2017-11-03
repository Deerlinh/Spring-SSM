package com.kaishengit.service;

import com.kaishengit.entity.Mybatis;

import java.util.List;

/**
 * Created by 蔡林红 on 2017/10/31.
 */
public interface MybatisService {

        Mybatis findById(int id);
        List<Mybatis> finfByPageNO(Integer pageNo);
        void save(Mybatis mybatis);

}
