package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User("user", "123", "USER"));
        userList.add(new User("admin", "123", "ADMIN"));
    }

    public void add(User user) {
        userList.add(user);
    }

    public List<User> getUserList() {
        return userList;
    }
}
