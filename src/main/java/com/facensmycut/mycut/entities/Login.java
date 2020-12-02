package com.facensmycut.mycut.entities;

import java.util.Objects;

public class Login {

    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return email.equals(login.email) &&
                password.equals(login.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}
