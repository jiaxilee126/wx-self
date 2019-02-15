package com.lee.self.admin.tag;

import com.lee.self.admin.service.IVersionService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName VersionTag
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/15 17:34
 */
@Component
public class VersionTag implements TemplateDirectiveModel {

    @Autowired
    private IVersionService versionService;
    private static final String pageSize = "pageSize";

    public Object recentVersion(String num) {
        if(!StringUtils.isEmpty(pageSize)){
            return versionService.getRecent(Integer.valueOf(pageSize));
        }
        return versionService.getRecent(10);
    }

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        String pageSize = map.get(this.pageSize).toString();
        String method = map.get("method").toString();
        environment.setVariable(method, getModel(recentVersion(pageSize)));
        //遇到一个坑，如果页面是这样写的<@blogTag  method="recentBlog"  pageSize="3" ></@blogTag>
        //中间没有任何内容，这里会一直报空指针异常
        templateDirectiveBody.render(environment.getOut());
    }

    private DefaultObjectWrapper getBuilder() {
        return new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25).build();
    }

    private TemplateModel getModel(Object o) throws TemplateModelException {
        return this.getBuilder().wrap(o);
    }
}
