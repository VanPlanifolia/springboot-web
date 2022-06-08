package com.czy.controller;

import com.czy.dao.DepartmentDao;
import com.czy.dao.EmployeeDao;
import com.czy.pojo.Department;
import com.czy.pojo.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Collection;
//员工的Controller类
@Controller
public class EmployeeController {
    //自动注入EmployeeDao
    @Resource(name = "employeeDao")
    EmployeeDao employeeDao;
    @Resource(name = "departmentDao")
    DepartmentDao departmentDao;
    /**
     * 获取全部员工信息
     * @return 跳转的页面
     */
    @RequestMapping("/getAllEmp")
    public String getAllEmployee(Model model){
        Collection<Employee> emps = employeeDao.getAllEmployee();
        model.addAttribute("emps",emps);
        return "emp/list.html";
    }

    /**
     * 跳转到添加员工的页面Controller
     * @return
     */
    @GetMapping("/emp")
    public String toAddEmp(Model model){
        Collection<Department> allDepartments = departmentDao.getAllDepartment();
        model.addAttribute("allDepartments",allDepartments);
        return "emp/add";
    }

    /**
     * 处理添加用户请求的Controller
     * @param employee 被添加的用户信息
     * @return 重定向/getAllEmp
     */
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/getAllEmp";
    }

    /**
     * 使用restful风格的接受Url，并且将Url携带的参数id绑定到 @PathVariable("id") Integer id 上
     * @param model 传递给前端的消息，用户与部门
     * @param id restful风格的接受的被更新用户的id
     * @return emp/update.html
     */
    @RequestMapping("/emp/{id}")
    public String toUpdateEmp(Model model, @PathVariable("id") Integer id){
        Employee emp = employeeDao.getEmployeeById(id);
        Collection<Department> departments = departmentDao.getAllDepartment();
        model.addAttribute("emp",emp);
        model.addAttribute("departments",departments);
        return "emp/update";
    }

    /**
     * 用户的删除操作
     * @param id restful风格传来的参数
     * @return 重定向/getAllEmp
     */
    @RequestMapping("/empdel/{id}")
    public String deleteEmp( @PathVariable("id") Integer id){
        employeeDao.deleteEmployee(id);
        return "redirect:/getAllEmp";
    }
    /**
     *
     * @param employee 被修改的用户信息
     * @return 重定向/getAllEmp
     */
    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.addEmployee(employee);
        return "redirect:/getAllEmp";
    }
}
