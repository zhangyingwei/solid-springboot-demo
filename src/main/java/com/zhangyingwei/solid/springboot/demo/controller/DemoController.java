package com.zhangyingwei.solid.springboot.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DemoController {
    @RequestMapping(value = "/index")
    public String index(Model model) {
        System.out.println("index controller");
        model.addAttribute("username", "张英伟");
        model.addAttribute("password", "123456");

        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("name" + i, i));
        }
        model.addAttribute("users", users);
        return "index";
    }

    public class User {
        String name;
        int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
