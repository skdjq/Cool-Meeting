package com.skdjq.service;

import com.skdjq.model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee doLogin(String username, String password);

    public Integer doReg(Employee employee);

    public Employee checkUsername(String username);

    public List<Employee> getAllEmpsByStatus(Integer i);

    public Integer updatestatus(Integer employeeid, Integer status);

    Long getTotal(Employee employee);

    List<Employee> getAllEmps(Employee employee, Integer page, Integer pageSize);

    List<Employee> getempbydepid(Integer depId);

    Integer changepw(String password);
}
