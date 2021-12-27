package ru.netology.jclo_homework211.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
public class User {

    @NotNull
    private final String user;

    @NotNull
    private final String password;
    private final List<Authorities> authorities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user1 = (User) o;
        return user.equals(user1.user) && password.equals(user1.password);
    }
}
