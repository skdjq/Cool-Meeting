package com.skdjq.service.impl;

import com.skdjq.mapper.DepartmentMapper;
import com.skdjq.model.Department;
import com.skdjq.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    public Department getDepById(Integer id) {
        return departmentMapper.getDepById(id);
    }

    public List<Department> getAllDeps() {
        return departmentMapper.getAllDeps();
    }

    public Integer adddepartment(String departmentname) {
        return departmentMapper.adddepartment(departmentname);
    }

    public Department getDepByName(String departmentname) {
        return departmentMapper.getDepByName(departmentname);
    }

    public Integer deletedepById(Integer departmentid) {
        return departmentMapper.deletedepById(departmentid);
    }

    public Integer updatedep(Integer id, String name) {
        return departmentMapper.updatedep(id, name);
    }
}
