package com.iSpringboot.controller;

import com.iSpringboot.bean.Demo;
import com.iSpringboot.service.DemoService;
import com.iSpringboot.service.DemoServicePlus;
import com.iSpringboot.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author guoga
 * @version 11:54 2020/5/12
 */
@RestController// @RestponseBody 和 @Controller 的组合
//@PropertySource(value = "classpath:test.properties", encoding = "utf-8")
@RequestMapping("/demo")
public class DemoController {

    private final static Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Value("${book.name}")
    private String bookname;

    @Autowired
    private DemoService demoService;

    @Autowired
    private DemoServicePlus demoServicePlus;

    @Autowired
    private TestService testService;

    @GetMapping("/hello/{id}")
    public String hello(@PathVariable(value = "id") Integer id) {
        logger.info("hello---------------------->id:" + id);
        return Optional.ofNullable(demoService.getDemoById(id)).map(Demo::toString).orElse("Empty String");
    }

    @GetMapping("/helloPlus/{id}")
    public String helloPlus(@PathVariable(value = "id") Integer id) {
        logger.info("helloPlus---------------------->id:" + id);
        return Optional.ofNullable(demoServicePlus.getDemoById(id)).map(Demo::toString).orElse("Empty String");
    }

    @GetMapping("/getBookname")
    public String getBookname() {
        return this.bookname;
    }

    @GetMapping("test")
    public String test() {
        return testService.test();
    }

}
