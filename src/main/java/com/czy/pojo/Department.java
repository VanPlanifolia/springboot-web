package com.czy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门pojo类<br>
 * id:部门id departmentName:部门名称<br>
 * 使用lombok工具类，通过注解的方式来生成有参无参构造方法，以及gs方法
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
