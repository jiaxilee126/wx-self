package com.lee.self.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * @ClassName ReqBlogVO
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/16 11:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqBlogVO {
    private String title;
    private String content;
    private String description;
    private boolean status;
    private boolean recomand;
    private Integer typeid;

    public boolean validate() {
        if( !StringUtils.isEmpty(title) &&
                !StringUtils.isEmpty(content) &&
                !StringUtils.isEmpty(description))
            return true;
        return false;
    }
}
