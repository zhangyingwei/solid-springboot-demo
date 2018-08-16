package com.zhangyingwei.solid.springboot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

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

    @GetMapping("/post/{index}")
    public String post(Model model,@PathVariable("index") Integer index) {
        Map<String, Object> paginator = new HashMap<String,Object>();
        paginator.put("previous_page", "previous_page.html");
        paginator.put("next_page_path", "next_page_path.html");
        paginator.put("page", 1);
        model.addAttribute("paginator",paginator);
        model.addAttribute("site", this.getSite());
        model.addAttribute("page", this.getPage());
        return "_layouts/post";
    }

    private Object getPage() {
        Map<String, Object> page = new HashMap<String, Object>();
        page.put("title", "张英伟的第一篇博客");
        page.put("author", "张英伟");
        page.put("date", System.currentTimeMillis());
        return page;
    }

    private Object getSite() {
        Map<String, Object> site = new HashMap<String, Object>();
        site.put("title", "张英伟的个人博客");
        site.put("baseurl", "");
        return site;
    }

    private List<Map<String, String>> getPosts() {
        List<Map<String, String>> posts = new ArrayList<Map<String,String>>();
        for (int i = 1; i < 10; i++) {
            Map<String, String> post = new HashMap<String, String>();
            post.put("url", "/post/"+i);
            post.put("title", "post title");
            post.put("content", "this is post content");
            post.put("date", new Date().toString());
            posts.add(post);
        }
        return posts;
    }
}
