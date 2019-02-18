package com.lee.self.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName ReqTechVO
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/18 8:37
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqTechVO {
    private String title;
    private MultipartFile file;
    private Integer level;
    private String description;
    private boolean status;

    public boolean volidate() {
        if ( !StringUtils.isEmpty(title) &&
                file != null &&
                !StringUtils.isEmpty(description))
            return true;
        return  false;
    }
}
