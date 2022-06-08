package com.czy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 员工pojo类<br>
 * id:员工id，lastName:姓名，email:邮箱，sex:性别，department:部门，birthday:生日<br>
 */
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer sex;
    private Department department;
    private Date birthday;
    public Employee(Integer id, String lastName, String email, Integer sex, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.sex = sex;
        this.department = department;
        this.birthday = new Date();
    }
}
