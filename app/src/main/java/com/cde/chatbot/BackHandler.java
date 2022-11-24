package com.cde.chatbot;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.widget.Toast;

public class BackHandler {
    private Activity activity;
    private Toast toast;
    public BackHandler(Activity activity) {
        this.activity = activity;
    }

    public void onBackPressed() {

    }

    private void showGuide() {
        toast = Toast.makeText(activity, "뒤로가기", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void showGuide(String msg) {
        toast = Toast.makeText(activity, msg, Toast.LENGTH_SHORT);
        toast.show();
    }
}
