package com.chenhao.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/6 14:55
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String mobile;
    private String password;
    private String salt;
    private String status;
    private Date createdOn;
    private String isDeleted;
    private Integer roleId;
    private Integer classId;
    private Integer groupId;
    private String groupName;
    private Integer integral;
}
