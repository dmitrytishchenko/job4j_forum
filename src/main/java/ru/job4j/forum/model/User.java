package ru.job4j.forum.model;

import java.util.Objects;

public class User {
    private int id;
    private String login;
    private String password;
    private String role;
    private int countId;

    public User(String login, String password, String role) {
        this.id = ++countId;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(login, user.login)
                && Objects.equals(password, user.password)
                && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, role);
    }
}
