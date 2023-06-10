package com.springBoot.SessionScope.Login.LoginComSessionScopeSpringBoot.userSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession implements Serializable {

    @Serial
    private  static final long serialVersionUID = 1L;

    private String username;
    private boolean loggedIn;

    // getters e setters

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
}
