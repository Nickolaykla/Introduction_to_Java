package tasks.task3.model;

import tasks.task3.controller.UserLogging;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"name", "password", "role"})
public class User {
    private String name;
    private String password;
    private Role role;

    public User(String name, String password, Role role) {
        if (name != null && password != null && role != null) {
            this.name = name;
            this.password = password;
            this.role = role;
        } else throw new IllegalArgumentException("Введены некорректные данные для пользователя");
    }

    public User(String name, String password) {
        if (name != null && password != null) {
            this.name = name;
            this.password = UserLogging.encryptPassword(password);
            this.role = Role.USER;
        } else throw new IllegalArgumentException("Введены некорректные данные для пользователя");
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null) {
            this.name = name;
        } else System.out.println("Некорректно задано имя пользователя");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password != null) {
            this.password = password;
        } else System.out.println("Некорректно задан пароль");
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        if (role != null) {
            this.role = role;
        } else System.out.println("Неверно задана роль пользователя");
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + password.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;

        return name.equals(user.name) && password.equals(user.password);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}