package com.mangachan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @ModelAttribute
    public void addTittle(Model model) {
        model.addAttribute("title", "Читать мангу онлайн");
    }

    @RequestMapping(path = {"/", "/index.html"}, method = RequestMethod.GET)
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("title", "Читать мангу онлайн");
        modelAndView.setViewName("index");
        return modelAndView;
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
