package com.example.appligsb;

import android.app.Activity;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.function.BiFunction;

public class MajEchant extends Activity {

    private EditText majEditTextCode;
    private EditText majEditTextQte;
    private Button majButtonSupprimer;
    private Button majButtonAjouter;
    private Button majButtonDelete;
    private TextView majTextViewMessage;
    private BdAdapter BdAdapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maj_echant);

        // On prépare l'écriture dans la base de données
        BdAdapter = new BdAdapter(MajEchant.this);
        BdAdapter.open();

        majEditTextCode = findViewById(R.id.majEditTextCode);
        majEditTextQte = findViewById(R.id.majEditTextQte);
        majTextViewMessage = findViewById(R.id.majTextViewMessage);
        majButtonDelete = findViewById(R.id.majButtonDelete);

        // Fonction "Supprimer"
        majButtonSupprimer = findViewById(R.id.majButtonSupprimer);
        majButtonSupprimer.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if (majEditTextQte.getText().length() != 0) {
                    int quantite = Integer.parseInt(majEditTextQte.getText().toString());
                    if (quantite > 0) {
                        Echantillon unEchant = BdAdapter.getEchantillonWithLib(majEditTextCode.getText().toString());
                        if (unEchant != null) {
                            if (Integer.parseInt(unEchant.getQuantiteStock()) >= quantite) {
                                int nouvelleQuantite = Integer.parseInt(unEchant.getQuantiteStock()) - quantite;
                                Log.d("SCS", "La quantité "+nouvelleQuantite + "a été a");
                                unEchant.setQuantiteStock("" + nouvelleQuantite);
                                BdAdapter.updateEchantillon(majEditTextCode.getText().toString(), unEchant);
                                Toast.makeText(getApplicationContext(), "Nouvelle quantité : "+nouvelleQuantite + " de l'échantillon "+majEditTextCode.getText().toString()+", a été ajoutée au stock.", Toast.LENGTH_LONG).show();
                                finish();
                            } else {
                                Log.d("ERR01", "Quantité > stock");
                            }
                        } else {
                            Log.d("ERR02", "Echantillon non existant");
                        }
                    } else {
                        Log.d("ERR03", "Quantité négative");
                    }
                } else {
                    Log.d("ERR04", "Champs vides");
                }
            }
        });

        // Fonction "Ajouter"
        majButtonAjouter = findViewById(R.id.majButtonAjouter);
        majButtonAjouter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (majEditTextQte.getText().length() != 0) {
                    int quantite = Integer.parseInt(majEditTextQte.getText().toString());
                    if (quantite > 0) {
                        Echantillon unEchant = BdAdapter.getEchantillonWithLib(majEditTextCode.getText().toString());
                        if (unEchant != null){
                            int nouvelleQuantite = Integer.parseInt(unEchant.getQuantiteStock()) + quantite;
                            Log.d("SCS", "La quantité "+nouvelleQuantite + "a été a");
                            unEchant.setQuantiteStock("" + nouvelleQuantite);
                            BdAdapter.updateEchantillon(majEditTextCode.getText().toString(), unEchant);
                            Toast.makeText(getApplicationContext(), "Nouvelle quantité : "+nouvelleQuantite + " de l'échantillon "+majEditTextCode.getText().toString()+", a été ajoutée au stock.", Toast.LENGTH_LONG).show();
                            finish();
                        }else {
                            Log.d("ERR02", "Echantillon non existant");
                        }
                    } else {
                        Log.d("ERR03", "Quantité négative");
                    }
                } else {
                    Log.d("ERR04", "Champs vides");
                }
            }
        });

        // Fonction "Supprimer la ligne"
        majButtonDelete = findViewById(R.id.majButtonDelete);
        majButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (majEditTextCode.getText().length() != 0){
                    Echantillon unEchant = BdAdapter.getEchantillonWithLib(majEditTextCode.getText().toString());
                    if (unEchant != null){
                        BdAdapter.removeEchantillonWithCode(majEditTextCode.getText().toString());
                        finish();
                        Toast.makeText(getApplicationContext(), "Echantillon supprimé définitivement !", Toast.LENGTH_LONG).show();
                    }
                    else {
                        majTextViewMessage.setText("L'Echantillon n'existe pas !");
                    }
                }
                else {
                    majTextViewMessage.setText("Veuillez remplir tous les champs !");
                }
            }
        });
    }

    public void majQuit(View view){
        Intent intent = new Intent(this, MajEchant.class);
        finish();
    }

}
