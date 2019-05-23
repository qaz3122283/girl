package com.test.girl.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

    @Value("${hive.jdbc.url}")
    private String url;

    @Value("${hive.username}")
    private String username;

    @Value("${hive.password}")
    private String password;

    @Value("${content}")
    private String content;

    @RequestMapping(value = "/hello/{id}",method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id) {
        return url+id;
    }

    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String say1(@RequestParam(value = "id" ,defaultValue = "0") Integer id) {
        return url+id;
    }

    @GetMapping("/hello2")
    public String say2(Integer id) {
        return id+"";
    }
}
