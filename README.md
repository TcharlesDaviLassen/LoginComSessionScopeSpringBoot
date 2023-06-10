### Para usar a funcionalidade de sessão no Spring Boot, você pode aproveitar o suporte embutido do framework para gerenciar a sessão do usuário. Aqui está um exemplo completo de como usar a dependência spring-session para gerenciar sessões em um aplicativo Spring Boot:

#### Adicionar a dependência no arquivo pom.xml do seu projeto:

```xml

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-session</artifactId>
</dependency>
```

#### Configurar o aplicativo para usar o suporte a sessão no arquivo application.properties:

```properties

# Configurações de sessão
spring.session.store-type=none
spring.session.timeout=30m
```

#### Criar uma classe para representar os dados do usuário, por exemplo, `UserSession`:

```java
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserSession {
private String username;
private boolean loggedIn;

    // getters e setters
}
```

#### Criar um controlador para lidar com a funcionalidade de login e logout, por exemplo, `LoginController`:

```java

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
```

#### Criar uma página de login `login.html` usando o Thymeleaf:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="/login" method="post">
        <input type="text" name="username" placeholder="Username">
        <input type="password" name="password" placeholder="Password">
        <button type="submit">Login</button>
    </form>
</body>
</html>
```


#### Criar uma página de home `home.html` para exibir o conteúdo protegido:

```html

<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
</head>
<body>
    <h1>Welcome, <span th:text="${userSession.username}"></span>!</h1>
    <a th:href="@{/logout}">Logout</a>
</body>
</html>
```
Com esse exemplo, você terá um sistema de login e logout básico que utiliza o suporte a sessão do Spring Boot. O objeto UserSession é configurado com escopo de sessão e pode ser injetado em outros componentes ou controladores para armazenar informações específicas do usuário durante a sessão.

Lembre-se de configurar a autenticação adequada e proteger suas rotas para garantir a segurança do sistema. Este exemplo demonstra apenas a funcionalidade básica de gerenciamento de sessão.

#
#

# LoginComSessionScopeSpringBoot
