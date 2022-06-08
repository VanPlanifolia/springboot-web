package com.czy.dao;

import com.czy.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 部门类的模拟Dao
 */
@Repository
public class DepartmentDao {
    //创建map模拟数据库
    private static Map<Integer, Department> departments=null;
    //通过静态代码块来为模拟数据库put值
    static {
        departments=new HashMap<Integer, Department>();
        departments.put(1001,new Department(1001,"教学部"));
        departments.put(1002,new Department(1002,"后勤部"));
        departments.put(1003,new Department(1003,"销售部"));
        departments.put(1004,new Department(1004,"研发部"));
    }
    //模拟dao操作

    /**
     * 查询所有的部门信息
     * @return 所有部门信息
     */
    public Collection<Department> getAllDepartment(){
        return departments.values();
    }

    /**
     * 查询指定id的部门信息
     * @param id 指定的id
     * @return 指定id的部门信息
     */
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
