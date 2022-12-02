//package ru.lexkml.spring.http.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//import ru.lexkml.spring.database.entity.Role;
//import ru.lexkml.spring.dto.UserReadDto;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Arrays;
//import java.util.List;
//
//@Controller
//@RequestMapping("/api/v1")
//@SessionAttributes({"user"})
//public class GreetingController {
//
//    @ModelAttribute("roles")
//    public List<Role> roles() {
//        return Arrays.asList(Role.values());
//    }
//
//    @GetMapping("/hello")
//
//    public String hello(Model model, HttpServletRequest request,
//                        @ModelAttribute("userReadDto") UserReadDto userReadDto) {
//        model.addAttribute("user", new UserReadDto(1L, "Ivan", null, null, null, null, null));
//        return "greeting/hello";
//    }
//
//    @GetMapping("/hello/{id}")
//    public ModelAndView hello2(ModelAndView modelAndView,
//                               HttpServletRequest request,
//                               @RequestParam Integer age,
//                               @RequestHeader String accept,
//                               @CookieValue("JSESSIONID") String jsessionId,
//                               @PathVariable Integer id
//    ) {
//        var ageParamValue = request.getParameter("age");
//        var acceptHeader = request.getHeader("accept");
//        var cookies = request.getCookies();
//        modelAndView.setViewName("greeting/hello");
//        return modelAndView;
//    }
//
//    @GetMapping("/bye")
//    public String bye(@SessionAttribute("user") UserReadDto userReadDto) {
//        return "greeting/bye";
//    }
//}
