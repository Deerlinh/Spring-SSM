package com.kaishengit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.kaishengit.entity.Mybatis;
import com.kaishengit.entity.MybatisExample;
import com.kaishengit.mapper.MybatisMapper;
import com.kaishengit.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 蔡林红 on 2017/10/31.
 */
@Service
public class MybatisServiceImpl implements MybatisService {

    /**
     *
     */
    @Autowired
    private MybatisMapper mybatisMapper;

    @Override
    public Mybatis findById(int id) {
        return mybatisMapper.selectByPrimaryKey(id);

    }

    @Override
    public List<Mybatis> finfByPageNO(Integer pageNo) {
        PageHelper.startPage(pageNo,5);
        MybatisExample mybatisExample=new MybatisExample();
        return  mybatisMapper.selectByExample(mybatisExample);
    }

    @Override
    public void save(Mybatis mybatis) {
    mybatisMapper.insert(mybatis);

    }
}
