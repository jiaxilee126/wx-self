package com.lee.self.core.dao;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TypeReposityTest {
    @Autowired
    private TypeReposity typeReposity;

    @Test
    public void findByName(){
        log.info("findByName_>java:{}", typeReposity.findByName("Spring"));
    }
}