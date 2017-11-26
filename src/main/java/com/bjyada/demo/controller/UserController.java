package com.bjyada.demo.controller;

import com.bjyada.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/10/16.
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/")
    public String  index(){
        return "index";
    }
    @RequestMapping("/add")
    @ResponseBody
    public Map<String,Object> addUser(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("state","success");
        map.put("date",userService.save("ming"));
        return map;
    }

    @RequestMapping("/findall")
    @ResponseBody
    public Map<String,Object> findAll(){
         Map<String, Object> map = new HashMap<String, Object>();
         map.put("state","succcess");
         map.put("date",userService.findAll());
         return map;
    }

    @RequestMapping("/findByid")
    @ResponseBody
    public String getUser(Integer id )
    {
        return userService.findById(id).toString();
    }

}
