package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.User;
import ru.job4j.forum.store.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userList;

    public UserService(UserRepository userList) {
        this.userList = userList;
    }

    public void add(User user) {
        userList.save(user);
    }

    public List<User> getUserList() {
        List<User> users = new ArrayList<>();
        userList.findAll().forEach(users::add);
        return users;
    }
}
