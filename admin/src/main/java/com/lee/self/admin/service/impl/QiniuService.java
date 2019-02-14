package com.lee.self.admin.service.impl;

import com.lee.self.admin.qiniu.FileTypeHelper;
import com.lee.self.admin.qiniu.QiniuImg;
import com.lee.self.admin.qiniu.QiniuStorage;
import com.lee.self.admin.service.IQiniuService;
import com.lee.self.common.result.JsonResult;
import com.lee.self.common.result.ResultCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @ClassName QiniuService
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/13 15:24
 */
@Slf4j
public class QiniuService implements IQiniuService {
    @Override
    public JsonResult uploadImg(MultipartFile file) {
        //获取源文件
        String filename = file.getOriginalFilename();
        String[] names=filename.split("\\.");//
        String type = names[names.length-1];
        boolean isImg = FileTypeHelper.isImg(type);
        String url = null;

        try {
            byte[] fileBytes = file.getBytes();
            if(isImg) {
                String key = QiniuStorage.uploadImage(fileBytes);
                QiniuImg img = new QiniuImg();
                img.setKey(key);
                url = img.getUrl512();
            }else {
                log.info("please input right support image");
                return JsonResult.code(ResultCodeEnum.SYSTEM_UNKNOWN_ERROR);
            }
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return JsonResult.data(url);
    }
}
