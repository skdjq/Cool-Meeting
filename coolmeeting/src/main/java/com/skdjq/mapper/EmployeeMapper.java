package com.skdjq.mapper;

import com.skdjq.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    public Employee doLogin(@Param("username") String username, @Param("password") String password);
    public Integer doReg(Employee employee);
    public Employee checkUsername(String username);
    public List<Employee> getAllEmpsByStatus(Integer i);
    public Integer updatestatus(@Param("employeeid") Integer employeeid, @Param("status") Integer status);

    List<Employee> getAllEmps(@Param("emp") Employee employee, @Param("page") Integer page, @Param("pageSize") Integer pageSize);

    Long getTotal(Employee employee);

    List<Employee> getempbydepid(Integer depId);

    Integer changepw(String password);
}
