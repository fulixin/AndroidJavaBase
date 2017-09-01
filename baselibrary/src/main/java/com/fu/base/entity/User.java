package com.fu.base.entity;

/**
 * Created by fulixin on 2017/7/27.
 */

public class User {
    public User() {
    }

    public User(String useraccount, String password, String menutypecode) {
        this.useraccount = useraccount;
        this.password = password;
        this.menutypecode = menutypecode;
    }

    public String getUseraccount() {
        return useraccount;
    }

    public void setUseraccount(String useraccount) {
        this.useraccount = useraccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMenutypecode() {
        return menutypecode;
    }

    public void setMenutypecode(String menutypecode) {
        this.menutypecode = menutypecode;
    }

    private String useraccount;
    private String password;
    private String menutypecode;
}
