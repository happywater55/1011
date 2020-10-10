package vo;

import tools.Md5;

import java.security.NoSuchAlgorithmException;

public class User {
    private String userName;//用户名
    private String password;
    private String chrName;//中文名
    private String role;

    public User() {
    }

    public User(String userName, String password, String chrName, String role) {
        this.userName = userName;
        this.password = password;
        this.chrName = chrName;
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getChrName() {
        return chrName;
    }

    public void setChrName(String chrName) {
        this.chrName = chrName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)  {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", chrName='" + chrName + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
