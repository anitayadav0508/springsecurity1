package org.spring.security.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.spring.security.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class RegistrationController {

    SessionFactory sessionFactory=new Configuration().configure().addAnnotatedClass(User.class).buildSessionFactory();
    Session session=sessionFactory.getCurrentSession();

    @RequestMapping("/register")
    public String registration(){

      return "register";
    }

    @RequestMapping("/insert")
    public String add(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      Model model) {
        session.beginTransaction();
        User user = new User(username,"{noop}"+password,1);
        session.save(user);
        session.getTransaction().commit();
        session.close();
        return "display";
    }
}
