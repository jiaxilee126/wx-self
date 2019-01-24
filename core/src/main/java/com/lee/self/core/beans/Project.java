package com.lee.self.core.beans;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Project {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String usedtech;
    private String content;
    private String responsibility;
}
