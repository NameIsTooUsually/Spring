package com.chenhao.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
@Data
public class AssignmentVo implements Serializable {

    private Integer uid;

    private String name;

    private List<Map> practiceList;

}