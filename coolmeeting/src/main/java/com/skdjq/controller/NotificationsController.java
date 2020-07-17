package com.skdjq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotificationsController {

    @GetMapping("/notifications")
    public String notifications(){
        return "notifications";
    }
}
