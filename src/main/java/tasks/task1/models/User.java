package tasks.task1.models;

import tasks.task1.controllers.AbilitiesImpl;
import tasks.task1.controllers.Logging;

public class User {
    private String name;
    private Email eMail;
    private String password;
    private Role role;
    private final AbilitiesImpl ability = new AbilitiesImpl();

    public User(String name, Email eMail, String password, Role role) {
        if (name != null && eMail != null && password != null && role != null) {
            this.name = name;
            this.eMail = eMail;
            this.password = Logging.encryptPassword(password);
            this.role = role;
        } else throw new IllegalArgumentException("Заданы некорректные данные");
    }

    public User(String name, Email eMail, String password) {
        if (name != null && eMail != null && password != null) {
            this.name = name;
            this.eMail = eMail;
            this.password = Logging.encryptPassword(password);
        } else throw new IllegalArgumentException("Заданы некорректные данные");
    }

    public User() {
    }

    public AbilitiesImpl getAbility() {
        return ability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email geteMail() {
        return eMail;
    }

    public void seteMail(Email eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + eMail.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        User user = (User) obj;

        return name.equals(user.name) && eMail.equals(user.eMail);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}