package com.lee.self.admin.service.impl;

import com.lee.self.admin.service.ITypeService;
import com.lee.self.common.result.JsonResult;
import com.lee.self.common.result.ResultCodeEnum;
import com.lee.self.common.vo.ReqTypeVO;
import com.lee.self.core.beans.Type;
import com.lee.self.core.dao.TypeReposity;
import com.qiniu.util.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TypeService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 13:57
 */
@Service
public class TypeService implements ITypeService {

    @Autowired
    private TypeReposity typeReposity;

    @Override
    public JsonResult add(ReqTypeVO type) {
        Type old = typeReposity.findByName(type.getTitle());
        if(old != null){
            return JsonResult.code(ResultCodeEnum.NAME_EXIST);
        }
        typeReposity.save(new Type(type.getTitle(), type.getIcon()));
        return JsonResult.ok();
    }

    @Override
    public List<Type> getAll() {
        List<Type> types = typeReposity.findAll();
        return types;
    }



    @Override
    public JsonResult update(Type type) {
        return null;
    }

    @Override
    public List<Type> findRecent(Integer num) {
        return typeReposity.findRecent(num);
    }
}
