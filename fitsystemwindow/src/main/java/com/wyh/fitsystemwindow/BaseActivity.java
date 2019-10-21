package com.wyh.fitsystemwindow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author WangYingHao
 * @since 2019-09-25
 */
public class BaseActivity extends AppCompatActivity {

    View dialog;

    @Override
    protected void onResume() {
        super.onResume();
        if (dialog == null) {
            dialog = LayoutInflater.from(this).inflate(R.layout.dialog, null);
            ViewGroup decorView = getWindow().getDecorView().findViewById(Window.ID_ANDROID_CONTENT);
            decorView.addView(dialog);
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        ViewParent parent = dialog.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(dialog);
        }
    }
}
