package com.springBoot.SessionScope.Login.LoginComSessionScopeSpringBoot.loginController;

import com.springBoot.SessionScope.Login.LoginComSessionScopeSpringBoot.userSession.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UserSession userSession;

    @GetMapping("/home")
    public String homePage(Model model) {
        if (userSession.isLoggedIn()) {
            var user = userSession.getUsername();
            userSession.setUsername(userSession.getUsername());
            userSession.setLoggedIn(true);

            model.addAttribute("userSession", user);
            return "home";
        }
        return "redirect:/login";
    }
}
