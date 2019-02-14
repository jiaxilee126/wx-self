package com.lee.self.admin.controller;

import com.lee.self.admin.service.IBlogService;
import com.lee.self.admin.service.ITechService;
import com.lee.self.admin.service.ITypeService;
import com.lee.self.admin.service.impl.BlogService;
import com.lee.self.core.dao.BlogReposity;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    /**
     * 主页
     * @return
     */
    @RequestMapping("/")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView("pages/home");
        mv.addObject("blognum", blogService.getAll().size());
        mv.addObject("technum", techService.getAll().size());
        mv.addObject("month", blogService.getMouth());
        mv.addObject("looks",2198);

        mv.addObject("blogrecent", blogService.getRecent());
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
}
