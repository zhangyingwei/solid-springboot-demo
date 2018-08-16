package com.zhangyingwei.solid.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class JekyllController {

    @GetMapping("/")
    public String index(Model model) {
        Map<String, Object> paginator = new HashMap<String,Object>();
        paginator.put("previous_page", "previous_page.html");
        paginator.put("next_page_path", "next_page_path.html");
        paginator.put("page", 1);
        paginator.put("posts", this.getPosts());
        model.addAttribute("paginator",paginator);
        model.addAttribute("site", this.getSite());
        return "index";
    }

    private Object getSite() {
        Map<String, Object> site = new HashMap<String, Object>();
        site.put("title", "张英伟的个人博客");
        return site;
    }

    private List<Map<String, String>> getPosts() {
        List<Map<String, String>> posts = new ArrayList<Map<String,String>>();
        for (int i = 0; i < 5; i++) {
            Map<String, String> post = new HashMap<String, String>();
            post.put("url", "post.html");
            post.put("title", "post title");
            post.put("content", "this is post content");
            posts.add(post);
        }
        return posts;
    }
}
