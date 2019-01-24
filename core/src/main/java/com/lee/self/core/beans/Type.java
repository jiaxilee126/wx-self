package com.lee.self.core.beans;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Type {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String icon;
    private Date createtime;
}
