package spring_boot_security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spring_boot_security.service.UserService;

@Controller
@RequestMapping("/")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getMainPage() {
        return "/user/index";
    }

    @GetMapping("/user")
    public String getCurrentUserInfo(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "/user/user";
    }

    @GetMapping("/user/{userName}")
    public String getUserPage(Model model, @PathVariable("userName") String userName) {
        model.addAttribute("user", userService.getUserByName(userName));
        return "/user/user";
    }
}
