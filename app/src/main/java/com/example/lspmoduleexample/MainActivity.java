package com.example.lspmoduleexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.tv_is_active);

    }

    @Override
    protected void onResume() {
        super.onResume();
        checkBox.setChecked(isModuleActive());
    }

    private static boolean isModuleActive() {
        int i = 0;
        while (i++ < 3) {
            System.out.println("isModuleActive -> " + i);
        }

        return false;
    }
}