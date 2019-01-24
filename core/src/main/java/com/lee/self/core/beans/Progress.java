package com.lee.self.core.beans;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Progress {
    @Id
    @GeneratedValue
    private Integer id;
    private String timenode;
    private String content;
}
