package ru.lexkml.spring.http.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class GreetingController {

    public ModelAndView hello(ModelAndView modelAndView) {
        modelAndView.setViewName("greeting/hello");
        return modelAndView;
    }

    public ModelAndView bye(ModelAndView modelAndView) {
        modelAndView.setViewName("greeting/bye");
        return modelAndView;
    }


}
