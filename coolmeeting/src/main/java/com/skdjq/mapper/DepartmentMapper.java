package com.skdjq.mapper;

import com.skdjq.model.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    Department getDepById(Integer id);

    List<Department> getAllDeps();

    Integer adddepartment(String departmentname);

    Department getDepByName(String departmentname);

    Integer deletedepById(Integer departmentid);

    Integer updatedep(@Param("id") Integer id, @Param("name") String name);

}
