package com.chenhao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 15:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user_student_assignment")
public class Assignment {
    private Integer id;
    private Integer userId;
    private String username;
    private Integer assignmentId;
    private String assignmentName;
    private Integer assignmentType;
    private Integer status;
    private Date createdOn;
    private Character isDeleted;
}
