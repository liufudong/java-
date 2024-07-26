package com.szyh.ldd;

public class AutoWireByName {
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "AutoWireByName{" +
                "user=" + user +
                '}';
    }
}
