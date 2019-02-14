package com.lee.self.admin.service;

import com.lee.self.common.result.JsonResult;
import com.lee.self.core.beans.Type;

import java.util.List;

/**
 * @ClassName ITypeService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 13:53
 */
public interface ITypeService {
    JsonResult add(Type type);

    List<Type> getAll();

    JsonResult update(Type type);

    /**
     * 查找最近的类型
     * @return
     */
    List<Type> findRecent();
}
