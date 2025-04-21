package com.LVM.LSM.controller;

import com.LVM.LSM.model.Role;
import com.LVM.LSM.model.User;
import com.LVM.LSM.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/login")
public RedirectView login(@RequestParam String username, @RequestParam String password) {
    User user = userService.login(username, password);

    // Determine the role of the user and redirect accordingly
    RedirectView redirectView = new RedirectView();
    if (user.getRoles().contains(Role.CUSTOMER)) {
        redirectView.setUrl("/home.html?role=CUSTOMER&username=" + username);
    } else if (user.getRoles().contains(Role.SERVICETECHNICIAN)) {
        redirectView.setUrl("/home.html?role=SERVICETECHNICIAN&username=" + username);
    } else if (user.getRoles().contains(Role.VENDOR)) {
        redirectView.setUrl("/home.html?role=VENDOR&username=" + username);
    } else {
        throw new RuntimeException("Unknown role");
    }
    return redirectView;
}
}

