package com.example.appligsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.ajout:
                Intent intent = new Intent(this, AjoutEchant.class);
                startActivity(intent);
                return true;
            case R.id.liste:
                Intent intent2 = new Intent(this, ListeEchant.class);
                startActivity(intent2);
                return true;
            case R.id.maj:
                Intent intent3 = new Intent(this, MajEchant.class);
                startActivity(intent3);
                return true;
            case R.id.quitter:
                finish();
        }
        return false;

    }

    public void openAjoutEchantillon(View view){
        Intent intent = new Intent(this, AjoutEchant.class);
        startActivity(intent);
    }

    public void openListeEchantillon(View view){
        Intent intent2 = new Intent(this, ListeEchant.class);
        startActivity(intent2);
    }

    public void openMajEchantillon(View view){
        Intent intent3 = new Intent(this, MajEchant.class);
        startActivity(intent3);
    }

    public void quitApp(View view){
        finish();
    }
}