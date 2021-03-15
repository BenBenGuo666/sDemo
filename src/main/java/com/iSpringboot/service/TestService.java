package com.iSpringboot.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author guoga
 * @version 15:26 2020/5/12
 */
@Component
public class TestService implements ApplicationContextAware
{

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
    {
        this.applicationContext = applicationContext;
    }

    public String test()
    {
        return applicationContext.getEnvironment().getProperty("key3");
    }


}
