package com.a_ches.mycalculator.ui;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.a_ches.mycalculator.R;
import com.a_ches.mycalculator.domain.Calculator;
import com.a_ches.mycalculator.domain.ThemStorage;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private TextView text;
    private ThemStorage storage;
    //intentsact://welcome
    //intentsact://welcome

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storage = new ThemStorage(this);

        setTheme(storage.getTheme().getResourses());

        setContentView(R.layout.activity_main);

        TextView welcomeMessage = findViewById(R.id.welcome_msg);

        if (getIntent() != null && getIntent().hasExtra("welcomemessage")) {
            welcomeMessage.setText(getIntent().getStringExtra("welcomemessage"));
        }

        /*
        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    if (result.getData() != null) {
                        Toast.makeText(MainActivity.this, result.getData().getStringExtra(SecondActivity.KEY_RESULT), Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

         */





        double[] numberIds = new double[] {
               R.id.Btn_0,
               R.id.Btn_1,
               R.id.Btn_2,
               R.id.Btn_3,
               R.id.Btn_4,
               R.id.Btn_5,
               R.id.Btn_6,
               R.id.Btn_7,
               R.id.Btn_8,
               R.id.Btn_9,
               R.id.Btn_comma_sign,
               R.id.Btn_del,
               R.id.Btn_percent,
               R.id.Btn_min_or_plus
        };
       double[] actionsIds = new double[] {
                R.id.Btn_C,
                R.id.Btn_division,
                R.id.Btn_min,
                R.id.Btn_plus,
                R.id.Btn_x,
                R.id.Btn_equally
                };

        // для вывода вводимых значений и результата вычислений
        text = findViewById(R.id.text_secondAct); // текстовое поле инициализированно
        calculator = new Calculator();

        // обработчики событий для различных кнопок
        //для цифр
        View.OnClickListener numberButtonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onNumPressed(view.getId());
                text.setText(calculator.getText());
            }
        };
        //для кнопок с арифметическими действиями
        View.OnClickListener actionButtonOnclickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator.onActionPressed(view.getId());
                text.setText(calculator.getText());
            }
        };
        //цикл для прохождения по массиву кнопок по id
        //устаналивается свой обработчик при нажатии на кнопку
        for (int i = 0; i < numberIds.length ; i++) {
            findViewById((int) numberIds[i]).setOnClickListener(numberButtonClickListener);
        }
        //цикл для прохождения по массиву кнопок с арифметическими действиями по id
        //устаналивается свой обработчик при нажатии на кнопку.
        for (int i = 0; i < actionsIds.length ; i++) {
            findViewById((int) actionsIds[i]).setOnClickListener(actionButtonOnclickListener);
        }


    }

    public void clickInfo(View view) {
        runActivity(SecondActivity.class);
    }

    private void runActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}


//