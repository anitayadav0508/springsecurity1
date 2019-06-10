package org.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hr")
public class HRController {
    @RequestMapping("/add")
    public String add(){
        return "add";

    }

    @RequestMapping("/edit")
    public String edit(){
        return "edit";
    }
}
