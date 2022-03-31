package com.example.appligsb;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AjoutEchant extends Activity {

    private EditText ajoutEditTextCode;
    private EditText ajoutEditTextLib;
    private EditText ajoutEditTextStock;
    private Button ajoutButtonAjouter;
    private TextView ajoutTextViewMessage;
    private BdAdapter BdAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajout_echant);

        // On prépare l'écriture dans la base de données
        BdAdapter = new BdAdapter(AjoutEchant.this);
        BdAdapter.open();

        ajoutTextViewMessage = findViewById(R.id.ajoutTextViewMessage);
        // On récupère des champs avec leur id
        ajoutEditTextCode = findViewById(R.id.ajoutEditTextCode);
        ajoutEditTextLib = findViewById(R.id.ajoutEditTextLib);
        ajoutEditTextStock = findViewById(R.id.ajoutEditTextStock);

        ajoutButtonAjouter = findViewById(R.id.ajoutButtonAjouter);
        ajoutButtonAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ajoutEditTextCode.getText().length() != 0 && ajoutEditTextLib.getText().length() != 0 && ajoutEditTextStock.getText().length() != 0) {
                    Echantillon unEchant = new Echantillon(ajoutEditTextCode.getText().toString(), ajoutEditTextLib.getText().toString(), ajoutEditTextStock.getText().toString());
                    if (BdAdapter.getEchantillonWithLib(ajoutEditTextCode.getText().toString()) == null){
                        // Insertion en base de données
                        BdAdapter.insererEchantillon(unEchant);
                        // Cloture la requête en base
                        BdAdapter.close();
                        // Message
                        ajoutTextViewMessage.setTextColor(Color.GREEN);
                        ajoutTextViewMessage.setText("L'Echantillon " + ajoutEditTextCode.getText() + " a été ajouté avec succès!");
                        Toast.makeText(getApplicationContext(), "L'Echantillon " + ajoutEditTextCode.getText() + " a été ajouté avec succès !", Toast.LENGTH_LONG).show();
                    }
                    else {
                        ajoutTextViewMessage.setText("L'Echantillon existe déjà !");
                    }
                }
                else {
                    ajoutTextViewMessage.setTextColor(Color.RED);
                    ajoutTextViewMessage.setText("Merci de bien compléter tous les champs !");
                }
            }
        });
    }

    public void echantQuit(View view){
        Intent intent = new Intent(this, AjoutEchant.class);
        finish();
    }
}