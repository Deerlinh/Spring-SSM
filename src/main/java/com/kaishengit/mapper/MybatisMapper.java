package com.kaishengit.mapper;

import com.kaishengit.entity.Mybatis;
import com.kaishengit.entity.MybatisExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

@Service
public interface MybatisMapper {
    long countByExample(MybatisExample example);

    int deleteByExample(MybatisExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Mybatis record);

    int insertSelective(Mybatis record);

    List<Mybatis> selectByExample(MybatisExample example);

    Mybatis selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Mybatis record, @Param("example") MybatisExample example);

    int updateByExample(@Param("record") Mybatis record, @Param("example") MybatisExample example);

    int updateByPrimaryKeySelective(Mybatis record);

    int updateByPrimaryKey(Mybatis record);
}