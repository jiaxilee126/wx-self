package com.lee.self.wxapi.service.impl;

import com.lee.self.common.result.JsonResult;
import com.lee.self.common.vo.ProjectDetailVO;
import com.lee.self.common.vo.ProjectVO;
import com.lee.self.core.beans.Project;
import com.lee.self.core.dao.ProjectReposity;
import com.lee.self.wxapi.service.IProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @ClassName ProjectService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/24 11:43
 */
@Service
public class ProjectService implements IProjectService {
    @Autowired
    private ProjectReposity projectReposity;

    @Override
    public JsonResult getAll() {
        List<Project> projects = projectReposity.findAll();
        List<ProjectVO> projectVOS = new ArrayList<>();
        for (Project project:projects
             ) {
            ProjectVO projectVO = new ProjectVO();
            BeanUtils.copyProperties(project, projectVO);
            projectVOS.add(projectVO);
        }
        return JsonResult.data(projectVOS);
    }

    @Override
    public JsonResult getById(Integer id) {
        Optional<Project> optional = projectReposity.findById(id);
        Project project = optional.get();
        ProjectDetailVO projectDetailVO = new ProjectDetailVO();
        BeanUtils.copyProperties(project, projectDetailVO);
        return JsonResult.data(projectDetailVO);
    }
}
