package com.lee.self.admin.service;

import com.lee.self.common.result.JsonResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName IQiniuService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 15:23
 */
public interface IQiniuService {
    JsonResult uploadImg(MultipartFile file);
}
