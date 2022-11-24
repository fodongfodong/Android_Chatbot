package com.cde.chatbot;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.Objects;

public class CustomDialog extends Dialog {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

        // 다이얼로그의 배경을 투명으로 만든다.
        Objects.requireNonNull(getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


        // 커스텀 다이얼로그의 각 위젯들을 정의한다.
        Button btn_no = findViewById(R.id.btn_no);
        Button btn_exit = findViewById(R.id.btn_exit);

        // 버튼 리스너 설정
        btn_exit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // '나가기' 버튼 클릭시
                // 상위액티비티 나가기
                CustomDialog.this.dismiss();
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);
                ((Activity)mContext).finish();
            }
        });
        btn_no.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                // '취소' 버튼 클릭시
                // ...코드..
                // Custom Dialog 종료
                dismiss();
            }
        });

    }

    public CustomDialog(Context mContext) {
        super(mContext);
        this.mContext = mContext;
    }


}




