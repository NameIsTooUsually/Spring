package com.chenhao.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ChenHao
 * @version 1.0
 * @description:
 * @date 2022/6/7 12:36
 */
@TableName("ks_class")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KsClass {
    private Integer id;
    private String  name;
    private Date createdOn;
    private String isDeleted;
}
