package com.lee.self.admin.config;

import com.lee.self.admin.tag.BlogTag;
import com.lee.self.admin.tag.VersionTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @ClassName TagConfig
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/15 10:24
 */
@Configuration
public class TagConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private BlogTag blogTag;

    @Autowired
    private VersionTag versionTag;

    @PostConstruct
    public void shareVariable() {
        configuration.setSharedVariable("versionTag", versionTag);
        configuration.setSharedVariable("blogTag", blogTag);
    }
}
