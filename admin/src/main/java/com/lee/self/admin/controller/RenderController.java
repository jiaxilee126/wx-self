package com.lee.self.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName RenderController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/26 11:34
 */
@Controller
public class RenderController {

    @RequestMapping("/")
    public String login(){
        //System.out.println("======================");
        //ModelAndView mv = new ModelAndView("login");
        return "login";
    }
}
