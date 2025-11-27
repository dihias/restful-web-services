package com.didi.rest.webservices.restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1,"didi", LocalDate.now().minusYears(30)));
        users.add(new User(2,"didi2", LocalDate.now().minusYears(29)));
        users.add(new User(3,"didi3", LocalDate.now().minusYears(28)));
        users.add(new User(4,"didi4", LocalDate.now().minusYears(31)));
    }

    public List<User> findAll()
    {
        return users;
    }

    public User findUser(int id) {
        //without Predicat
        // return users.stream().filter(user -> id == user.getId()).findFirst().orElse(null);
            Predicate<? super User> predicate = user -> user.getId().equals(id);
            return users.stream().filter(predicate).findFirst().get();


    }
}
