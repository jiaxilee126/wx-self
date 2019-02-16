package com.lee.self.admin.resperror;

import lombok.Getter;

@Getter
public enum BlogPublishErrorEnum {
    BLOG_NAME_EXIST(21001,"名称已存在"),
    BLOG_NAME_NOT_EMPTY(21002,"名称不能为空"),
    BLOG_DES_NOT_EMPTY(21003,"描述不能为空"),
    BLOG_CONTENT_NOT_EMPTY(21004,"内容不能为空"),
    ;
    private int code;
    private String msg;
    private BlogPublishErrorEnum(int code, String msg) {

    }
}
