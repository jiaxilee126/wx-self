package com.lee.self.admin.controller;

import com.lee.self.admin.service.IQiniuService;
import com.lee.self.common.result.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName QiniuController
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 15:19
 */
public class QiniuController {

    @Autowired
    private IQiniuService qiniuService;


    @RequestMapping("/upload")
    @ResponseBody
    public JsonResult upload(@RequestParam("file") MultipartFile file){
        return qiniuService.uploadImg(file);
    }




}
