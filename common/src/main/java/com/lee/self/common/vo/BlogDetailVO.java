package com.lee.self.common.vo;

import lombok.Data;

/**
 * @ClassName BlogDetailVO
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/1/25 10:20
 */
@Data
public class BlogDetailVO {
    private String title;
    private String content;
    private Boolean remand;
    private String date;
    private String type;
}
