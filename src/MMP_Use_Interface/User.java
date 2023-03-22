package MMP_Use_Interface;

import java.io.Serializable;

public class User implements Serializable {

    private String email;
    private String name;
    private int brithYear;

    public User(String email, String name, int brithYear) {
        this.email = email;
        this.name = name;
        this.brithYear = brithYear;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getBrithYear() {
        return brithYear;
    }

    @Override
    public String toString() {
        return "MMP.User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", brithYear=" + brithYear +
                '}';
    }
}
