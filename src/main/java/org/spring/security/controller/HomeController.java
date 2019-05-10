package org.spring.security.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/")
    public String displayTopic(){
        return "springSecurity";
    }
    @RequestMapping("/process")
    public String process(@RequestParam(name = "topic") String  topic, Model model){
        model.addAttribute("topic",topic);
        return "display";
    }

    @RequestMapping("/employee")
    public String employee(){
        return "employee";
    }

    @RequestMapping("/director")
    public String manager(){
        return "manager";
    }
}
