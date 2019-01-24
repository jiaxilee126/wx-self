package com.lee.self.wxapi.service.impl;

import com.lee.self.common.result.JsonResult;
import com.lee.self.common.vo.BlogVO;
import com.lee.self.core.beans.Blog;
import com.lee.self.core.dao.BlogReposity;
import com.lee.self.wxapi.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName BlogService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/23 17:37
 */
@Service
public class BlogService implements IBlogService {
    @Autowired
    private BlogReposity blogReposity;

    @Override
    public JsonResult getById(Integer id) {
        Optional<Blog> blogOptional = blogReposity.findById(id);
        Blog blog = blogOptional.get();
        BlogVO blogVO = new BlogVO();
        BeanUtils.copyProperties(blog, blogVO);
        return JsonResult.data(blogVO);
    }

    @Override
    public JsonResult getAll() {
        List<Blog> blogs = blogReposity.findAll();
        List<BlogVO> blogVOs = new ArrayList<>();
        for (Blog blog: blogs
             ) {
            BlogVO blogVO = new BlogVO();
            BeanUtils.copyProperties(blog, blogVO);
            blogVOs.add(blogVO);
        }
        return JsonResult.data(blogVOs);
    }
}
