package com.a_ches.mycalculator.domain;

import com.a_ches.mycalculator.R;

public enum AppTheme {

   CUSTOM(R.style.MyTheme_dark, "custom"),

    DEFAULT(R.style.MyTheme, "default"); // LIGHT

    AppTheme(int resourses, String key) {
        this.resourses = resourses;
        this.key = key;
    }

    private  int resourses;

    private String key;

    public int getResourses() {
        return resourses;
    }

    public String getKey() {
        return key;
    }
}
