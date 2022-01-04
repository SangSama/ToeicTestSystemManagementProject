package com.sangtt.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping("/test")
    @ResponseBody //dùng để đánh dấu phương thức này sẽ được trả ra client
    public String test() {
        return "test nè!!!";
    }
}
