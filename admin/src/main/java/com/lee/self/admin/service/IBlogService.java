package com.lee.self.admin.service;

import com.lee.self.common.vo.BlogVO;
import com.lee.self.core.beans.Blog;

import java.util.List;

/**
 * @ClassName IBlogService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 11:19
 */
public interface IBlogService {
    List<BlogVO> getAll();

    List<BlogVO> getRecent(Integer pageSize);

    /**
     * 当月发布的文章数
     * @return
     */
    Integer getMouth();
}
