package com.ctgu.crm.controller;

import com.ctgu.crm.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController extends BaseController {

    //登录
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    //欢迎
    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("main")
    public String main(){
        return "main";
    }

}
