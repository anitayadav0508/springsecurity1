package org.spring.security.controller;

import org.spring.security.entity.Authority;
import org.spring.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.hibernate.SessionFactory;
import org.hibernate.Session;


@Controller
@RequestMapping("/")
public class HomeController {
   /* @Autowired
    private SessionFactory sessionFactory;*/

    @RequestMapping("/")
    public String displayTopic() {
        return "springSecurity";
    }

    @RequestMapping("/process")
    public String process(@RequestParam(name = "topic") String topic, Model model) {
        model.addAttribute("topic", topic);
        return "display";
    }

    @RequestMapping("/employee")
    public String employee() {
        return "employee";
    }

    @RequestMapping("/director")
    public String manager() {
        return "manager";
    }

   /* @RequestMapping("/register")
    public String register(Model model, @RequestParam(name = "username")
            String username, @RequestParam(name = "email") String email, @RequestParam(name = "password") String password) {

        Session session = sessionFactory.getCurrentSession();


        try {
            session.beginTransaction();
            User user = new User("alisha","alisha123","alisha@gmail.com","ROLE_EMPLOYEE");
            Authority authority = new Authority();
            authority.setUser(user);
            session.save(user);
            model.addAttribute("msg", "addedsucessfully");
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "sucess";
    }*/

    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
