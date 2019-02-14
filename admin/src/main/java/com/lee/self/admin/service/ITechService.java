package com.lee.self.admin.service;

import com.lee.self.common.result.JsonResult;
import com.lee.self.common.vo.TechVO;
import com.lee.self.core.beans.Tech;
import com.qiniu.util.Json;

import java.util.List;

/**
 * @ClassName ITechService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 16:48
 */
public interface ITechService {
    List<TechVO> getAll();
    JsonResult add(Tech tech);
    JsonResult update(Tech tech);

    /**
     * 查找最近新学的技能
     * @return
     */
    List<TechVO> findRecent();
}
