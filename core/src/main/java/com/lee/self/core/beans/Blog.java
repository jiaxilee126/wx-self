package com.lee.self.core.beans;

import lombok.Data;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 创建时间
     */
    //@Column(name = "Createtime")
    private Date createtime;
    /**
     * 博客标题
     */
    //@Column(name = "Title")
    private String title;
    /**
     * 博客内容
     */
    @Column(name = "Content")
    private String content;
    /**
     * 简述
     */
    //@Column(name = "Description")
    private String description;
    /**
     * 是否发布
     */
    //@Column(name = "Status")
    private Boolean status;
    /**
     * 是否推荐
     */
    //@Column(name = "Recomand")
    private Boolean recomand;
    /**
     * 类型id
     */
    //@Column(name = "Typeid")
    private Integer typeid;

}
