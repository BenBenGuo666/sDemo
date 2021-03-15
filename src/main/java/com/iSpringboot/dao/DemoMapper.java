package com.iSpringboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iSpringboot.bean.Demo;
import com.iSpringboot.bean.DemoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DemoMapper extends BaseMapper<Demo> {
    long countByExample(DemoExample example);

    int deleteByExample(DemoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Demo record);

    int insertSelective(Demo record);

    List<Demo> selectByExample(DemoExample example);

    Demo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Demo record, @Param("example") DemoExample example);

    int updateByExample(@Param("record") Demo record, @Param("example") DemoExample example);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
}