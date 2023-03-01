package com.example.lspmoduleexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox checkBox = findViewById(R.id.tv_is_active);

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