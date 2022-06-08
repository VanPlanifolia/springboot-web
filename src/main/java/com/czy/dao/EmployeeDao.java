package com.czy.dao;

import com.czy.pojo.Department;
import com.czy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工类的模拟dao操作
 */
@Repository
public class EmployeeDao {
    //创建一个哈希map来模拟数据库
    private static Map<Integer, Employee> employees=null;
    private static Integer id=1005;
    //自动注入DepartmentDao
    @Resource(name = "departmentDao")
    private DepartmentDao departmentDao;
    //模拟插入数据库信息
    static {
        employees=new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001,"张三","1@qq.com",1,new Department(1001,"教学部")));
        employees.put(1002,new Employee(1002,"李四","2@qq.com",1,new Department(1002,"后勤部")));
        employees.put(1003,new Employee(1003,"王五","3@qq.com",1,new Department(1003,"销售部")));
        employees.put(1004,new Employee(1004,"赵六","4@qq.com",1,new Department(1004,"研发部")));
    }
    //模拟dao操作
    //查询所有员工
    public Collection<Employee> getAllEmployee(){
        return employees.values();
    }
    //按id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //添加员工
    public void addEmployee(Employee employee){
        //如果没有传入id则使用自增
        if(employee.getId()==null){
            employee.setId(id++);
        }
        //添加部门信息
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }
    //删除员工
    public void deleteEmployee(Integer id){
        employees.remove(id);
    }
}
