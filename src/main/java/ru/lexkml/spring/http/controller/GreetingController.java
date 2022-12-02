package ru.lexkml.spring.http.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.lexkml.spring.dto.UserReadDto;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @GetMapping("/hello")

    public ModelAndView hello(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("greeting/hello");
        modelAndView.addObject("user", new UserReadDto(1L, "Ivan"));
        return modelAndView;
    }

    @GetMapping("/hello/{id}")
    public ModelAndView hello2(ModelAndView modelAndView,
                               HttpServletRequest request,
                               @RequestParam Integer age,
                               @RequestHeader String accept,
                               @CookieValue("JSESSIONID") String jsessionId,
                               @PathVariable Integer id
    ) {
        var ageParamValue = request.getParameter("age");
        var acceptHeader = request.getHeader("accept");
        var cookies = request.getCookies();
        modelAndView.setViewName("greeting/hello");
        return modelAndView;
    }

    @GetMapping("/bye")
    public ModelAndView bye(ModelAndView modelAndView, @SessionAttribute("user") UserReadDto userReadDto) {
        modelAndView.setViewName("greeting/bye");
        return modelAndView;
    }
}
