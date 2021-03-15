package com.iSpringboot.service;

import com.iSpringboot.bean.Demo;
import com.iSpringboot.bean.DemoExample;
import com.iSpringboot.dao.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author GuoBenben
 * @version 2021/01/15
 */
@Service
public class DemoServicePlus {

    @Autowired
    private DemoMapper demoMapper;

    public Demo getDemoById(Integer id) {
        return Optional.ofNullable(demoMapper.selectById(id)).orElse(new Demo());
    }

    public List<Demo> getList() {
        return demoMapper.selectByMap(new HashMap<String, Object>(10));
    }

}
