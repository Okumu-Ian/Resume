package com.company.resume.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class ResumeStorage {
    public static String USER_NAME = "USER_NAME";
    public static String USER_DETAILS = "USER_DETAILS";
    public static String USER_WORK = "USER_WORK";
    public static String USER_EDUCATION = "USER_EDUCATION";
    public static String USER_SKILLS = "USER_SKILLS";
    public static String USER_ACHIEVEMNTS="USER_ACHIEVEMENTS";





    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public ResumeStorage(Context context){
        this.context = context;
        preferences = this.context.getSharedPreferences("USER",Context.MODE_PRIVATE);
    }

    public String getUser_name() {
        return preferences.getString(USER_NAME,"John Doe");
    }

    public void setUser_name(String user_name) {
        editor = preferences.edit();
        editor.putString(USER_NAME,user_name);
        editor.apply();
    }

    public String getUser_details() {
        return preferences.getString(USER_DETAILS,"Details");
    }

    public void setUser_details(String user_details) {
        editor = preferences.edit();
        editor.putString(USER_DETAILS,user_details);
        editor.apply();
    }

    public String getUser_work() {
        return preferences.getString(USER_WORK,"Just Living");
    }

    public void setUser_work(String user_work) {
        editor = preferences.edit();
        editor.putString(USER_WORK,user_work);
        editor.apply();
    }

    public String getUser_education() {
        return preferences.getString(USER_EDUCATION,"High School Diploma");
    }

    public void setUser_education(String user_education) {
        editor = preferences.edit();
        editor.putString(USER_EDUCATION,user_education);
        editor.apply();
    }

    public String getUser_skill() {
        return preferences.getString(USER_SKILLS,"Swimming enthusiast");
    }

    public void setUser_skill(String user_skill) {
        editor = preferences.edit();
        editor.putString(USER_SKILLS,user_skill);
        editor.apply();
    }

    public String getUser_achievements() {
        return preferences.getString(USER_ACHIEVEMNTS,"Member of NFL Supporters");
    }

    public void setUser_achievements(String user_achievements) {
        editor = preferences.edit();
        editor.putString(USER_ACHIEVEMNTS,user_achievements);
        editor.apply();
    }
}
