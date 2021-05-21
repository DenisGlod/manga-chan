package com.mangachan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

    @RequestMapping(path = {"/", "/index.html"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(path = {"/login.html"}, method = RequestMethod.GET)
    public String login() {
        return "page/login";
    }

    @RequestMapping(path = {"/info.html"}, method = RequestMethod.GET)
    public String info() {
        return "page/info";
    }

}
