package ru.lexkml.spring.http.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.lexkml.spring.dto.UserCreateEditDto;
import ru.lexkml.spring.service.UserService;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAll(Model model) {
//        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
//        model.addAttribute("users", userService.findById());
        return "user/user";
    }

//    @PostMapping
//    public String create(@ModelAttribute UserCreateEditDto dto) {
//        userService.create(dto)
//        return "redirect:/users/" + user.getId();
//    }

//    @PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, UserCreateEditDto dto) {
//        userService.update(id, dto);
        return "redirect:/users/{id}";
    }

//    @DeleteMapping("{id}")
    @PostMapping("{id}/delete")
    public String delete(@PathVariable Long id) {
//        userService.delete(id);
        return "redirect:/users";
    }
}
