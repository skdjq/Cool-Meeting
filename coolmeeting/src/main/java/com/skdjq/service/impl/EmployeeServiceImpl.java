package com.skdjq.service.impl;

import com.skdjq.mapper.EmployeeMapper;
import com.skdjq.model.Employee;
import com.skdjq.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public Employee doLogin(String username, String password){
        return employeeMapper.doLogin(username, password);
    }

    public Integer doReg(Employee employee){
        if(employeeMapper.checkUsername(employee.getUsername()) != null){
            return -1;
        }
        employee.setRole(1);
        employee.setStatus(0);
        return employeeMapper.doReg(employee);
    }

    public Employee checkUsername(String username) {
        return employeeMapper.checkUsername(username);
    }

    public List<Employee> getAllEmpsByStatus(Integer i) {
        return employeeMapper.getAllEmpsByStatus(i);
    }

    public Integer updatestatus(Integer employeeid, Integer status) {
        return employeeMapper.updatestatus(employeeid, status);
    }

    public Long getTotal(Employee employee) {
        return employeeMapper.getTotal(employee);
    }

    public List<Employee> getAllEmps(Employee employee, Integer page, Integer pageSize) {
        page = (page - 1) * pageSize;
        return employeeMapper.getAllEmps(employee, page, pageSize);
    }

    public List<Employee> getempbydepid(Integer depId) {
        return employeeMapper.getempbydepid(depId);
    }

    public Integer changepw(String password) {
        return employeeMapper.changepw(password);
    }
}
