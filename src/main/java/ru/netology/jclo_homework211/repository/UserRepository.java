package ru.netology.jclo_homework211.repository;

import org.springframework.stereotype.Repository;
import ru.netology.jclo_homework211.model.Authorities;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        return user.equals("admin") && password.equals("qwe") ? Arrays.asList(Authorities.values()) : Collections.emptyList();
    }
}
