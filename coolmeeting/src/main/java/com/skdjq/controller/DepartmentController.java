package com.skdjq.controller;

import com.skdjq.model.Department;
import com.skdjq.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/departments")
    public String departments(Model model){
        model.addAttribute("deps", departmentService.getAllDeps());
        return "departments";
    }

    @PostMapping("/adddepartment")
    public String adddepartment(String departmentname, Model model){
        Department department = departmentService.getDepByName(departmentname);
        if(department != null){
            model.addAttribute("Deperror", "部门名重复！");
            return "forward:/admin/departments";
        }
        model.addAttribute("Deperror", "");
        Integer result = departmentService.adddepartment(departmentname);
        return "redirect:/admin/departments";
    }

    @RequestMapping("/deletedep")
    public String deletedep(Integer departmentid) {
        Integer result = departmentService.deletedepById(departmentid);
        return "redirect:/admin/departments";
    }

    @RequestMapping("/updatedep")
    @ResponseBody
    public String updatedep(Integer id, String name){
        Integer result = departmentService.updatedep(id, name);
        //result为影响的行数，这里sql语句影响的行数为1
        if(result == 1){
            return "success";
        }
        return "error";
    }
}
