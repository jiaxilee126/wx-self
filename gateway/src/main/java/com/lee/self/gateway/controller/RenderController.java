package com.lee.self.gateway.controller;

import com.lee.self.admin.client.AdminClient;
import com.lee.self.admin.service.IBlogService;
import com.lee.self.admin.service.ITechService;
import com.lee.self.admin.service.ITypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName RenderController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/26 11:34
 */
@Controller
@Slf4j
public class RenderController {

   /* @Autowired
    private AdminClient adminClient;*/

    @RequestMapping("/")
    public ModelAndView login() {
        log.info("===========================");
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

}
