package com.lee.self.wxapi.service.impl;

import com.lee.self.wxapi.service.IBlogService;
import javafx.scene.control.Alert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogServiceTest {

    @Autowired
    IBlogService blogService;

    @Test
    public void getById() throws Exception {
        blogService.getById(1);
    }

    @Test
    public void getAll() throws Exception {
    }

}