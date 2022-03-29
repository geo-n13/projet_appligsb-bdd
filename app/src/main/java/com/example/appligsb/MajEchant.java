package com.example.appligsb;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MajEchant extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maj_echant);
    }

    public void majQuit(View view){
        Intent intent = new Intent(this, MajEchant.class);
        finish();
    }

}
