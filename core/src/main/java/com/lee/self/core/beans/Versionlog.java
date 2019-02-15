package com.lee.self.core.beans;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @ClassName Versionlog
 * @Description TODO
 * @Auth JussiLee
 * @Date 2019/2/15 17:26
 */
@Data
@Entity
@Table
public class Versionlog {
    @Id
    @GeneratedValue
    private Integer id;
    private String version;
    private String discription;
    private Date time;

}
