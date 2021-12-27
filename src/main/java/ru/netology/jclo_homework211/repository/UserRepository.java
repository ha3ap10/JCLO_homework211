package ru.netology.jclo_homework211.repository;

import org.springframework.stereotype.Repository;
import ru.netology.jclo_homework211.model.Authorities;
import ru.netology.jclo_homework211.model.User;

import java.util.*;

@Repository
public class UserRepository {

    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        save(new User("admin", "qwe",Arrays.asList(Authorities.values())));
        save(new User("foo", "bar", Arrays.asList(Authorities.READ, Authorities.WRITE)));
        save(new User("user", "pass", Arrays.asList(Authorities.READ)));
    }

    public List<Authorities> getUserAuthorities(User user) {
        int index = users.indexOf(user);
        return index != -1 ? users.get(index).getAuthorities() : Collections.emptyList();
    }

    public synchronized void save(User user) {
        users.add(user);
    }
}
