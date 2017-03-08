package com.appdockproject.appdock.apps_activities;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.appdockproject.appdock.R;
import com.appdockproject.appdock.TwilioSMS;
import com.appdockproject.appdock.appPage;
import com.appdockproject.appdock.devActivity;
import com.appdockproject.appdock.eduActivity;
import com.appdockproject.appdock.facebookActivity;
import com.appdockproject.appdock.feedbackActivity;

public class App1Activity extends AppCompatActivity {

    Button smsBtn;
    EditText phoneNumInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            int UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
            getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        }

        Button devBtn = (Button) findViewById(R.id.devBtn);
        Button eduBtn = (Button) findViewById(R.id.eduBtn);
        Button cmntBtn = (Button) findViewById(R.id.comBtn);
        Button fbBtn = (Button) findViewById(R.id.fbBtn);
        Button appBtn = (Button) findViewById(R.id.appBtn);

        //Activity Elements
        smsBtn = (Button) findViewById(R.id.getAppPhoneBtn);
        phoneNumInput = (EditText) findViewById(R.id.smsNumber);

        //get number by Text
        smsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //to send the text

                String userSMSNum = phoneNumInput.getText().toString(); //user input number as a string

                TwilioSMS ts = new TwilioSMS(App1Activity.this);

                if (ts.sendSMS(userSMSNum, getString(R.string.app1SMSLink)))
                    phoneNumInput.getText().clear();

            }
        });

        appBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(App1Activity.this, appPage.class);
                startActivity(intent);
            }
        });

        devBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(App1Activity.this, devActivity.class);
                startActivity(intent);
            }
        });


        eduBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(App1Activity.this, eduActivity.class);
                startActivity(intent);
            }
        });

        cmntBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(App1Activity.this, feedbackActivity.class);
                startActivity(intent);
            }
        });

        fbBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(App1Activity.this, facebookActivity.class);
                startActivity(intent);
            }
        });

    }

    // Needs this to remove statusbar and navigation layout after focus of activity regains focus
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
}