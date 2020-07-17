package com.skdjq.controller;

import com.skdjq.model.Department;
import com.skdjq.model.Employee;
import com.skdjq.model.Meeting;
import com.skdjq.service.DepartmentService;
import com.skdjq.service.EmployeeService;
import com.skdjq.service.MeetingRoomService;
import com.skdjq.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MeetingController {

    @Autowired
    private MeetingRoomService meetingRoomService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MeetingService meetingService;

    @RequestMapping("/bookmeeting")
    public String bookmeeting(Model model){
        model.addAttribute("mrs", meetingRoomService.getAllMr());
        return "bookmeeting";
    }

    @RequestMapping("/alldeps")
    @ResponseBody
    public List<Department> alldeps(){
        return departmentService.getAllDeps();
    }

    @RequestMapping("/getempbydepid")
    @ResponseBody
    public List<Employee> getempbydepid(Integer depId){
        return employeeService.getempbydepid(depId);
    }

    @RequestMapping("/doAddMeeting")
    public String doAddMeeting(Meeting meeting, Integer[] mps, HttpSession session) {
        Employee currentuser = (Employee) session.getAttribute("currentuser");
        meeting.setReservationistid(currentuser.getEmployeeid());
        Integer result = meetingService.addMeeting(meeting,mps);
        if (result == 1) {
            return "redirect:/searchmeetings";
        }else{
            return "forward:/bookmeeting";
        }
    }

    @RequestMapping("/searchmeetings")
    public String searchmeetings() {
        return "searchmeetings";
    }
}
