package ru.job4j.forum.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

@Controller
public class UserControl {
    private final UserService users;

    public UserControl(UserService users) {
        this.users = users;
    }

    @GetMapping({"/reg"})
    public String users() {
        return "reg";
    }

    @PostMapping({"/reg"})
    public String createUser(@RequestParam("name") String login,
                             @RequestParam("password2") String password,
                             @RequestParam("role") String role, Model model
    ) {
        users.add(new User(login, password, role));
        model.addAttribute("users", users.getUserList());
        return "login";
    }

}
