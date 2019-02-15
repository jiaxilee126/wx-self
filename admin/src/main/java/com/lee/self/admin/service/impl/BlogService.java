package com.lee.self.admin.service.impl;

import com.lee.self.admin.service.IBlogService;
import com.lee.self.common.vo.BlogVO;
import com.lee.self.core.beans.Blog;
import com.lee.self.core.beans.Type;
import com.lee.self.core.dao.BlogReposity;
import com.lee.self.core.dao.TypeReposity;
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
 * @Date 2019/2/13 11:20
 */
@Service
public class BlogService implements IBlogService {

    @Autowired
    private BlogReposity blogReposity;

    @Autowired
    private TypeReposity typeReposity;

    @Override
    public List<BlogVO> getAll() {
        List<Blog> blogs  = blogReposity.findAll();
        List<BlogVO> blogVOS = new ArrayList<>();
        for (Blog blog : blogs) {
            BlogVO blogVO = new BlogVO();
            BeanUtils.copyProperties(blog, blogVO);
            Optional<Type> type = typeReposity.findById(blog.getTypeid());
            if(type.isPresent()){
                blogVO.setType(type.get().getTitle());
            }
            blogVOS.add(blogVO);
        }
        return blogVOS;
    }

    @Override
    public List<BlogVO> getRecent(Integer pageSize) {
        List<Blog> blogs = blogReposity.findRecent(10);
        List<BlogVO> blogVOS = new ArrayList<>();
        for (Blog blog : blogs) {
            BlogVO blogVO = new BlogVO();
            BeanUtils.copyProperties(blog, blogVO);
            Optional<Type> type = typeReposity.findById(blog.getTypeid());
            if(type.isPresent()){
                blogVO.setType(type.get().getTitle());
            }
            blogVOS.add(blogVO);
        }
        return blogVOS;
    }

    @Override
    public Integer getMouth() {
        return blogReposity.getMonth();
    }
}
