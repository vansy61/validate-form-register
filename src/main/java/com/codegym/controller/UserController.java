package com.codegym.controller;

import com.codegym.dto.UserDto;
import com.codegym.model.User;
import com.codegym.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/users", produces = "text/html; charset=utf-8")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("")
    public String index(@RequestParam(defaultValue = "") String name, Model model,
                        @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("users", userService.findByName(name, pageable));
        model.addAttribute("name", name);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("users", new UserDto());
        return "/create";
    }


    @PostMapping("/save")
    public String save(@ModelAttribute("users") @Validated UserDto userDto,
                       BindingResult bindingResult,
                       RedirectAttributes attributes,
                       Model model) {
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            try {
                userService.save(user);
                attributes.addFlashAttribute("success", "Add new users successfully!");
                return "redirect:/users";
            } catch (RuntimeException e) {
                model.addAttribute("errorMessage", e.getMessage());
                return "/create";
            }
        }
    }
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id, Model model) {
        model.addAttribute("users", userService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(User user, RedirectAttributes redirect) {
        userService.delete(user);
        redirect.addFlashAttribute("success", "Removed user successfully!");
        return "redirect:/users";
    }
}
