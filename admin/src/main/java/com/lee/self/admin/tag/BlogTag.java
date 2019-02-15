package com.lee.self.admin.tag;

import com.lee.self.admin.service.IBlogService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @ClassName BlogTag
 * @Description 使用方法<@blogTag method="recentBlog" pageSize="10"></@blogTag> 对应的是recentblog方法
 *
 * @Auth JussiLee
 * @Date 2019/2/15 9:19
 */
@Component
public class BlogTag implements TemplateDirectiveModel{

    //定义<@blogTag>标签中的参数名称
    private static final String pageSize = "pageSize";

    @Autowired
    private IBlogService blogService;

    public Object recentBlog(String pageSize){
        if(!StringUtils.isEmpty(pageSize)){
            return blogService.getRecent(Integer.valueOf(pageSize));
        }
        return blogService.getRecent(10);
    }

    /**
     *
     * @param environment 运行的环境
     * @param map 方法参数map  方法名和值
     * @param templateModels
     * @param templateDirectiveBody 输出形式
     * @throws TemplateException
     * @throws IOException
     */
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        String pageSize = map.get(this.pageSize).toString();
        String method = map.get("method").toString();
        environment.setVariable(method, getModel(recentBlog(pageSize)));
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
