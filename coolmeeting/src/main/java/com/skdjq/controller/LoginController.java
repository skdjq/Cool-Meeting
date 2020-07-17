package com.skdjq.controller;

import com.skdjq.model.Department;
import com.skdjq.model.Employee;
import com.skdjq.service.DepartmentService;
import com.skdjq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/")
    public String login(){
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(String username, String password, Model model, HttpSession session){
        Employee employee = employeeService.doLogin(username, password);
        if(employee == null){
            model.addAttribute("error", "用户名或密码错误！");
            return "forward:/";
        }else{
            if(employee.getStatus() == 0){
                model.addAttribute("error", "您的信息待审批中");
                return "forward:/";
            }else if(employee.getStatus() == 2){
                model.addAttribute("error", "您的审批未通过");
                return "forward:/";
            }else{
                session.setAttribute("currentuser", employee);
                return "redirect:/notifications";
            }
        }
    }

    @RequestMapping("/register")
    public String register(Model model){
        List<Department> lists = departmentService.getAllDeps();
        model.addAttribute("deps", lists);
        return "register";
    }

    @PostMapping("/doReg")
    public String doReg(Employee employee, Model model){
        Integer result = employeeService.doReg(employee);
        if(result == -1){
            model.addAttribute("error", "注册失败");
            return "forward:/register";
        }else{
            return "redirect:/";
        }
    }
}
