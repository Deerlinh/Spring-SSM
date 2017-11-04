package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Kaola;
import com.kaishengit.entity.KaolaType;
import com.kaishengit.entity.Mybatis;

import java.util.List;
import java.util.Map;

/**
 * Created by 蔡林红 on 2017/10/31.
 */
public interface MybatisService {



        PageInfo<Kaola> findByPageNo(Integer pageNo);
        PageInfo<Kaola> findByPageNo(Integer pageNo, Map<String,Object> queryParm);

        List<String> findProductPlaceList();

       void save(Kaola kaola);

        Kaola findById(Integer id);

        void editKaola(Kaola kaola);

        void deleteKaola(Integer id);

        List<KaolaType> findByTypeAll();

}
