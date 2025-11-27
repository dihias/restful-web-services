package com.didi.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
}
