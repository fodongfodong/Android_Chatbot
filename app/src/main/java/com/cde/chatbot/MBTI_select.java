package com.cde.chatbot;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MBTI_select extends AppCompatActivity {
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mbti_select);

        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(MBTI_select.this, MainActivity.class);
                startActivity(main);
                finish();
            }
        });
    }
}