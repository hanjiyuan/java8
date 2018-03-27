package org.chat;

public class User {
    private String userName;

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public boolean equals(Object user) {
        if (user instanceof User) {
            return userName.equals(((User) user).getUserName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return userName.hashCode();
    }
}
