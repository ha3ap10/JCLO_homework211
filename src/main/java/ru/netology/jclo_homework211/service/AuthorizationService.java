package ru.netology.jclo_homework211.service;

import org.springframework.stereotype.Service;
import ru.netology.jclo_homework211.exceptions.InvalidCredentials;
import ru.netology.jclo_homework211.exceptions.UnauthorizedUser;
import ru.netology.jclo_homework211.model.Authorities;
import ru.netology.jclo_homework211.model.User;
import ru.netology.jclo_homework211.repository.UserRepository;

import java.util.List;

@Service
public class AuthorizationService {
    private UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(User user) {
        if (isEmpty(user.getUser()) || isEmpty(user.getPassword())) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(user);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user.getUser());
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
