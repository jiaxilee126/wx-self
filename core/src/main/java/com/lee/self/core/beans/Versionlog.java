package com.lee.self.core.beans;

import lombok.Data;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String version;
    private String discription;
    private Date time;

}
