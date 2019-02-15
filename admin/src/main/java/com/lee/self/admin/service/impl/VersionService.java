package com.lee.self.admin.service.impl;

import com.lee.self.admin.service.IVersionService;
import com.lee.self.core.beans.Versionlog;
import com.lee.self.core.dao.VersionReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName VersionService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/15 17:36
 */
@Service
public class VersionService implements IVersionService {

    @Autowired
    private VersionReposity versionReposity;

    @Override
    public List<Versionlog> getRecent(Integer num) {
        return versionReposity.findRecent(num);
    }
}
