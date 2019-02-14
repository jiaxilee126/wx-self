package com.lee.self.core.dao;

import com.lee.self.core.beans.Blog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogReposityTest {
    @Test
    public void findAll1() throws Exception {
    }

    @Test
    public void findById() throws Exception {
        Optional<Blog> blog = blogReposity.findById(1);
        Blog b = blog.get();
        System.out.println(b.getContent());
    }

    @Autowired
    BlogReposity blogReposity;

    @Test
    public void findAll() throws Exception {
        System.out.println(blogReposity);
        List<Blog> blogs = blogReposity.findAll();
        System.out.println(blogs.size());
    }

    @Test
    public void  findRecent() throws  Exception {
        List<Blog> blogs = blogReposity.findRecent(3);
        System.out.println(blogs.size());
    }

}