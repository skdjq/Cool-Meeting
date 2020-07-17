package com.skdjq.service;

import com.skdjq.model.Department;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    public Department getDepById(Integer id);

    public List<Department> getAllDeps();

    public Integer adddepartment(String departmentname);

    public Department getDepByName(String departmentname);

    public Integer deletedepById(Integer departmentid);

    public Integer updatedep(Integer id, String name);

}
