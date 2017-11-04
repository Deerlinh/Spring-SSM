package com.kaishengit.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.*;
import com.kaishengit.mapper.KaolaMapper;
import com.kaishengit.mapper.KaolaTypeMapper;
import com.kaishengit.mapper.MybatisMapper;
import com.kaishengit.service.MybatisService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by 蔡林红 on 2017/10/31.
 */
@Service
public class MybatisServiceImpl implements MybatisService {

    /**
     *
     */

    @Autowired
    private KaolaMapper kaolaMapper;

    @Autowired
    private KaolaTypeMapper kaolaTypeMapper;
    @Override
    public PageInfo<Kaola> findByPageNo(Integer pageNo) {
        PageHelper.startPage(pageNo,10);

        List<Kaola> list=  kaolaMapper.findWithType();
        return new PageInfo<Kaola>(list);
    }

    @Override
    public PageInfo<Kaola> findByPageNo(Integer pageNo, Map<String, Object> queryParm) {
        PageHelper.startPage(pageNo,10);

        List<Kaola> list=kaolaMapper.findByQueryParamWithType(queryParm);
         return  new PageInfo<>(list);
    }

    @Override
    public List<String> findProductPlaceList() {
        return kaolaMapper.findAllPlace();
    }


    @Override
    public void save(Kaola kaola) {
        //设置添加时，阅读数量为0
        kaola.setCommentNum(0);

        kaolaMapper.insert(kaola);
    }

    @Override
    public Kaola findById(Integer id) {
        return kaolaMapper.selectByPrimaryKey(id);
    }

    @Override
    public void editKaola(Kaola kaola) {
       kaolaMapper.updateByPrimaryKeySelective(kaola);
}

    @Override
    public void deleteKaola(Integer id) {
        kaolaMapper.deleteByPrimaryKey(id);

    }

    @Override
    public List<KaolaType> findByTypeAll() {
        return kaolaTypeMapper.selectByExample(new KaolaTypeExample());
    }
}
