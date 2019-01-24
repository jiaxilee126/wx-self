package com.lee.self.core.beans;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Tech {
    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private String icon;
    private Integer level;
    private String content;
    private Boolean status;
}
