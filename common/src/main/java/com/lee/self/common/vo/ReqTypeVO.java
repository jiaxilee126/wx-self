package com.lee.self.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

/**
 * @ClassName ReqTypeVO
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/16 9:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReqTypeVO {
    private String title;
    private String icon;

    public boolean volidate() {
        if(!StringUtils.isEmpty(title) && !StringUtils.isEmpty(icon))
            return true;
        return false;
    }
}
