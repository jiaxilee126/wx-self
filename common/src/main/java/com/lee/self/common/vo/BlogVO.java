package com.lee.self.common.vo;

import lombok.Data;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName BlogVO
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/23 17:34
 */
@Data
public class BlogVO {
    private Integer id;
    private String title;
    private String description;
    private Boolean recomand;
    private String type;
    private Date createtime;
}
