package com.lee.self.admin.service;

import com.lee.self.admin.tag.VersionTag;
import com.lee.self.core.beans.Versionlog;

import java.util.List;

/**
 * @ClassName IVersionService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/15 17:35
 */
public interface IVersionService {
    List<Versionlog> getRecent(Integer num);
}
