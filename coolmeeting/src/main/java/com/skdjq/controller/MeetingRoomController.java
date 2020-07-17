package com.skdjq.controller;

import com.skdjq.model.MeetingRoom;
import com.skdjq.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeetingRoomController {

    @Autowired
    private MeetingRoomService meetingRoomService;

    @RequestMapping("/meetingrooms")
    public String meetingrooms(Model model){
        model.addAttribute("mrs", meetingRoomService.getAllMr());
        return "meetingrooms";
    }

    @RequestMapping("/roomdetails")
    public String roomdetails(Integer roomid, Model model){
        model.addAttribute("mr", meetingRoomService.getMrById(roomid));
        return "roomdetails";
    }

    @PostMapping("/updateroom")
    public String updateroom(MeetingRoom meetingRoom){
        Integer result = meetingRoomService.updateroom(meetingRoom);
        if(result == 1){
            return "redirect:/meetingrooms";
        }else{
            return "forward:/roomdetails";
        }
    }

    @RequestMapping("/admin/addmeetingroom")
    public String addmeetingroom(){
        return "addmeetingroom";
    }

    @RequestMapping("/admin/doAddMr")
    public String doAddMr(MeetingRoom meetingRoom){
        Integer result = meetingRoomService.doAddMr(meetingRoom);
        return "redirect:/meetingrooms";
    }
}
