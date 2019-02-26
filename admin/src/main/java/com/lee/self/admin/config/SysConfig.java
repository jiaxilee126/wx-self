package com.lee.self.admin.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName SysConfig
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/21 8:16
 */
@Configuration
@Slf4j
public class SysConfig {

    @Data
    @Component
    class SysConstant {
        private String path = "admin";
    }

    @Autowired
    private freemarker.template.Configuration configuration ;

    @Autowired
    private SysConstant sysConstant;

    @PostConstruct
    public void shareVariable (){
        try {
            configuration.setSharedVariable("config",sysConstant.getPath());
        }catch (Exception e) {
            log.error(e.getMessage());
        }

    }
}
