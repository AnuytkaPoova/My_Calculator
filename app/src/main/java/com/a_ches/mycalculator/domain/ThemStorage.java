package com.a_ches.mycalculator.domain;

import android.content.Context;
import android.content.SharedPreferences;

public class ThemStorage {

    private  static final String KEY_APP_THEME = "KEY_APP_THEME";

    private final SharedPreferences sharedPreferences;

    public ThemStorage(Context context) {
        sharedPreferences = context.getSharedPreferences("app_theme", Context.MODE_PRIVATE);
    }

    public AppTheme getTheme() {
        String key = sharedPreferences.getString(KEY_APP_THEME, AppTheme.DEFAULT.getKey());

        for (AppTheme theme:
                AppTheme.values()) {
                    if (theme.getKey().equals(key)) {
                        return theme;
                    }
        }
        throw new IllegalStateException("Wrong!");
    }
    public void setTheme(AppTheme theme) {
        sharedPreferences.edit()
                .putString(KEY_APP_THEME, theme.getKey())
                .apply();
    }
}
