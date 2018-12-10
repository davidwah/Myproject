package com.dwp.login;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ASUS on 12/02/2017.
 */
public class Session {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Context ctx;
    private String username, password, area, fullName, email, saldo, tagID;
    private String ip = "203.189.120.153";

    public Session(Context ctx) {
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("myApp", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedIn(Boolean loggedIn) {
        editor.putBoolean("loggedInmode",loggedIn);
        editor.commit();
    }

    public void saveSaldo(String saldo) {
        this.saldo = saldo;
        editor.putString("saldo",saldo);
        editor.commit();
    }

    public void saveTagID(String tagID) {
        this.tagID = tagID;
        editor.putString("tagID", tagID);
        editor.commit();
    }

    public void saveEmail(String email) {
        this.email = email;
        editor.putString("email", email);
        editor.commit();
    }

    public void saveUsername(String username) {
        this.username = username;
        editor.putString("username", username);
        editor.commit();
    }

    public void savePassword(String password) {
        this.password = password;
        editor.putString("password", password);
        editor.commit();
    }

    public String getsaveUsername() {
        return prefs.getString("username", username);
    }

    public String getsavePassword() {

        return prefs.getString("password", password);
    }

    public String getsaveSaldo() {

        return prefs.getString("saldo", saldo);
    }

    public String getsaveTagID() {

        return prefs.getString("tagID", tagID);
    }

    public String getsaveEmail() {

        return prefs.getString("email", email);
    }

    public boolean loggedin() {

        return prefs.getBoolean("loggedInmode",false);
    }
}
