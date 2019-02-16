package com.lee.self.admin.tag;

import com.lee.self.admin.service.ITypeService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName TypeTag
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/16 11:34
 */
@Component
public class TypeTag implements TemplateDirectiveModel {
    @Autowired
    private ITypeService typeService;

    private static final String pageSize = "pageSize";

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        Object pageSize = map.get(this.pageSize);
        String method = map.get("method").toString();
        environment.setVariable(method, getModel(recentBlog(pageSize)));
        //遇到一个坑，如果页面是这样写的<@blogTag  method="recentBlog"  pageSize="3" ></@blogTag>
        //中间没有任何内容，这里会一直报空指针异常
        templateDirectiveBody.render(environment.getOut());
    }

    public Object recentBlog(Object pageSize){

        if(pageSize !=null && !StringUtils.isEmpty(pageSize.toString())){
            return typeService.findRecent(Integer.valueOf(pageSize.toString()));
        }
        return typeService.getAll();
    }

    private DefaultObjectWrapper getBuilder() {
        return new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25).build();
    }

    private TemplateModel getModel(Object o) throws TemplateModelException {
        return this.getBuilder().wrap(o);
    }
}
