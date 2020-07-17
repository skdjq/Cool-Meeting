package com.skdjq.controller;

import com.skdjq.model.Employee;
import com.skdjq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    @Autowired
    private EmployeeService employeeService;


    @RequestMapping("/mymeetings")
    public String mymeetings(){
        return "mymeetings";
    }

    @RequestMapping("/mybookings")
    public String mybookings(){
        return "mybookings";
    }

    @RequestMapping("/notifications")
    public String notifications(){
        return "notifications";
    }

    @RequestMapping("/changepassword")
    public String changepassword(){
        return "changepassword";
    }

    @RequestMapping("/changepw")
    public String changepw(String password){
        Integer result = employeeService.changepw(password);
        if(result == 1) {
            return "redirect:/";
        }else{
            return "forward:/changepassword";
        }
    }
}
