package com.lee.self.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @ClassName ReqUserVO
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/19 10:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqUserVO {
    private String username;
    private String password;

    public boolean volidate() {
        if (!StringUtils.isEmpty(username) &&
             !StringUtils.isEmpty(password))
            return true;
        return false;
    }
}
