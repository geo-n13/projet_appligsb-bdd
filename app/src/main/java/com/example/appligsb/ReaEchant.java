package com.example.appligsb;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class ReaEchant extends Activity {

    private ListView listViewRea;
    private BdAdapter echantBdd;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rea_echant);
        listViewRea = (ListView) findViewById(R.id.listeListViewRea);

        echantBdd = new BdAdapter(this);
        //On ouvre la base de données pour écrire dedans
        echantBdd.open();
        Cursor leCurseur = echantBdd.getDataRea();
        //Colonnes à afficher
        String[] colRea = new String[] {BdAdapter.COL_LIB, BdAdapter.COL_STOCK};
        // champs dans lesquelles afficher les colonnes
        int[] colNumeros = new int[] {R.id.listeTextViewLibRea, R.id.listeTextViewStockRea};
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.rea_entree,leCurseur,colRea,colNumeros);
        // Assign adapter to ListView
        listViewRea.setAdapter(dataAdapter);
        echantBdd.close();
    }

    public void listReaQuit(View view){
        Intent intent = new Intent(this, ReaEchant.class);
        finish();
    }
}
