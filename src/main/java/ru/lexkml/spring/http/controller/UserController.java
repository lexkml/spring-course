package ru.lexkml.spring.http.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;
import ru.lexkml.spring.dto.UserCreateEditDto;
import ru.lexkml.spring.service.UserService;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        return userService.findById(id).map(user -> {
            model.addAttribute("users", user);
            return "user/user";
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
    public String create(@Validated UserCreateEditDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/user/login";
        }
        return "redirect:/users/" + userService.create(dto).getId();
    }

    //    @PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String update(@PathVariable Long id, @Validated UserCreateEditDto dto) {
        return userService.update(id, dto)
                .map(it -> "redirect:/users/{id}")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //    @DeleteMapping("{id}")
    @PostMapping("{id}/delete")
    public String delete(@PathVariable Long id) {
        if (!userService.delete(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return "redirect:/users";
        }
    }
}
