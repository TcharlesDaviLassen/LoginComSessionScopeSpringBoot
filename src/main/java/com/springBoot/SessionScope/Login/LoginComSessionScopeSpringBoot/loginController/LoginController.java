package com.springBoot.SessionScope.Login.LoginComSessionScopeSpringBoot.loginController;

import com.springBoot.SessionScope.Login.LoginComSessionScopeSpringBoot.userSession.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserSession userSession;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        // Verificar as credenciais do usuário
        if (username.equals("admin") && password.equals("admin123")) {
            userSession.setUsername(username);
            userSession.setLoggedIn(true);

            return "redirect:/home";
        } else {
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        userSession.setUsername(null);
        userSession.setLoggedIn(false);
        return "redirect:/login";
    }
}
