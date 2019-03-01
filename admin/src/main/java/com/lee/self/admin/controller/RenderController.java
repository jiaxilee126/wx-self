package com.lee.self.admin.controller;

import com.lee.self.admin.security.CustomSecurityUser;
import com.lee.self.admin.service.IBlogService;
import com.lee.self.admin.service.ITechService;
import com.lee.self.admin.service.ITypeService;
import com.lee.self.admin.service.impl.BlogService;
import com.lee.self.core.dao.BlogReposity;
import com.lee.self.user.beans.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 * @ClassName RenderController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/26 11:34
 */
@Controller
public class RenderController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ITypeService typeService;

    @Autowired
    private ITechService techService;

    @RequestMapping(value = {"/login","/"})
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    /**
     * 主页
     * @return
     */
    @RequestMapping("/home")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("pages/home");
        mv.addObject("blognum", blogService.getAll().size());
        mv.addObject("technum", techService.getAll().size());
        mv.addObject("month", blogService.getMouth());
        mv.addObject("looks",2198);

        //默认显示10
        mv.addObject("blogrecent", blogService.getRecent(10));
        mv.addObject("techrecent", techService.findRecent());
        return mv;
    }



    /**
     * 文章列表页
     * @return
     */
    @RequestMapping("/articles")
    public ModelAndView articles() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("blogs", blogService.getAll());
        mv.setViewName("pages/article-list");
        return  mv;
    }

    /**
     * 类型列表页
     * @return
     */
    @RequestMapping("/types")
    public ModelAndView types() {
        ModelAndView mv = new ModelAndView("pages/type-list");
        mv.addObject("types", typeService.getAll());
        return  mv;
    }

    /**
     * 文章发布页
     * @return
     */
    @RequestMapping("/publish")
    public ModelAndView publish(){
        ModelAndView mv = new ModelAndView("pages/publish");
        return mv;
    }

    /**
     * 技能中心
     * @return
     */
    @RequestMapping("/techcenter")
    public ModelAndView techcenter() {
        ModelAndView mv = new ModelAndView("pages/techcenter");
        mv.addObject("techs", techService.getAll());
        return mv;
    }

    /**
     * 技能列表
     * @return
     */
    @RequestMapping("/techs")
    public ModelAndView techs() {
        ModelAndView mv = new ModelAndView("pages/tech-list");
        mv.addObject("techs", techService.getAll());
        return mv;
    }

    /**
     * 个人中心
     * @return
     */
    @RequestMapping("/self")
    public ModelAndView self() {
        ModelAndView mv = new ModelAndView("pages/selfcenter");

        return  mv;
    }


    @RequestMapping("/blogTag")
    public ModelAndView tag() {
        ModelAndView mv = new ModelAndView("pages/blogTag");

        return mv;
    }

    @ModelAttribute("user")
    public CustomSecurityUser getUser() {
        CustomSecurityUser user = null;
        SecurityContext ctx = SecurityContextHolder.getContext();
        Authentication auth = ctx.getAuthentication();
        if (auth.getPrincipal() instanceof UserDetails) user = (CustomSecurityUser) auth.getPrincipal();
        return user;
    }
}
