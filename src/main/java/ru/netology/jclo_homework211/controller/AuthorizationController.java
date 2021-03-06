package ru.netology.jclo_homework211.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.netology.jclo_homework211.exceptions.InvalidCredentials;
import ru.netology.jclo_homework211.exceptions.UnauthorizedUser;
import ru.netology.jclo_homework211.model.Authorities;
import ru.netology.jclo_homework211.model.User;
import ru.netology.jclo_homework211.service.AuthorizationService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthorizationController {
    private AuthorizationService service;

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@Valid User user) {
        return service.getAuthorities(user);
    }

    @ExceptionHandler(InvalidCredentials.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String resolveException(InvalidCredentials exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UnauthorizedUser.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    String resolveException(UnauthorizedUser exception) {
        return exception.getMessage();
    }

}
