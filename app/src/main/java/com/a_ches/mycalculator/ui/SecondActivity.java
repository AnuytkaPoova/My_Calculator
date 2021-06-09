package com.a_ches.mycalculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.a_ches.mycalculator.R;
import com.a_ches.mycalculator.domain.AppTheme;
import com.a_ches.mycalculator.domain.ThemStorage;

public class SecondActivity extends AppCompatActivity {

    public static final String KEY_RESULT = "KEY_RESULT";

    private ThemStorage storage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storage = new ThemStorage(this);
        setTheme(storage.getTheme().getResourses());
        setContentView(R.layout.activity_second);

    findViewById(R.id.default_theme).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            storage.setTheme(AppTheme.DEFAULT);
            recreate();
        }
    });
        findViewById(R.id.custom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storage.setTheme(AppTheme.CUSTOM);
                recreate();
            }
        });
    }
    private void runActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
    public void clickCalculator(View view) {
        runActivity(MainActivity.class);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

}