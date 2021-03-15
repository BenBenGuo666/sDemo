package com.example;


import com.StartAppliction;
import com.iSpringboot.bean.Demo;
import com.iSpringboot.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author guoga
 * @version 14:33 2020/6/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartAppliction.class)
/*@ContextConfiguration(classes = {
        Demo.class,
        DemoExample.class,
        DemoMapper.class,
        DemoService.class})*/
public class ITest
{

    @Autowired
    DemoService demoService;

    @Test
    public void demo()
    {
        //System.out.println(demoService.getList() + "111");
        processData(demoService.getList());
    }

    public void processData(List<Demo> datas)
    {
        String htmlTagProTmple = "<font size=\"3\" color=\"red\">";
        String htmlTagTmple = "</font>";
        //System.out.println(htmlTag);
        for (Demo demo:datas)
        {
            if(demo.getId() == 2)
                System.out.println(htmlTagProTmple + "id:" + demo.getId() + " name:" + demo.getName() + htmlTagTmple);
            else
                System.out.println("id:" + demo.getId() + " name:" + demo.getName());
        }
    }

}
