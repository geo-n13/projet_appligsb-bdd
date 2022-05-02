package com.example.appligsb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
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

        //test de la BDD
        // testBd();
    }

    /* public void testBd(){
        //Création d'une instance de la classe echantBDD
        BdAdapter echantBdd = new BdAdapter(this);
        //Création d'un Echantillon
        Echantillon unEchant = new Echantillon("code1", "lib1", "3");
        //On ouvre la base de données pour écrire dedans
        echantBdd.open();

        //On insère DES ECHANTILLONS DANS LA BDD
        echantBdd.insererEchantillon(new Echantillon("code1", "lib1", "3"));
        echantBdd.insererEchantillon(new Echantillon("code2", "lib2", "5"));
        echantBdd.insererEchantillon(new Echantillon("code3", "lib3", "7"));
        echantBdd.insererEchantillon(new Echantillon("code4", "lib4", "6"));
        Cursor unCurseur = echantBdd.getData();
        System.out.println("il y a "+String.valueOf(unCurseur.getCount())+" echantillons dans la BD");

        //On insère l'echantillon que l'on vient de créer
        echantBdd.insererEchantillon(unEchant);
        //System.out.println("insertion echantillon");
        //Pour vérifier que l'on a bien créé un echantillon dans la BDD
        //on extrait l’echantillon de la BDD grâce au libelle de l'echantillon que l'on a créé précédemment
        Echantillon unEchantFromBdd = echantBdd.getEchantillonWithLib("lib1");
        //Si un unArticle est retourné (donc si le unEchant à bien été ajouté à la BDD)

        if(unEchantFromBdd != null){
            //On affiche les infos de l’echantillon dans un Toast
            Toast.makeText(this, unEchantFromBdd.getLibelle(), Toast.LENGTH_LONG).show();
            System.out.println("echantillon trouve : "+unEchantFromBdd.getLibelle());
            //On modifie le titre de l’echantillon
            unEchantFromBdd.setLibelle("lib2");
            //Puis on met à jour la BDD
            echantBdd.updateEchantillon(unEchantFromBdd.getCode(), unEchantFromBdd);
        }

        else {
            Toast.makeText(this, "echantillon non trouvé", Toast.LENGTH_LONG).show();
            System.out.println("echantillon non trouvé");
        }

        //On extrait l’Article de la BDD grâce à son nouveau lib

        unEchantFromBdd = echantBdd.getEchantillonWithLib("Lib2");
        //S'il existe un Article possédant cette désignation dans la BDD
        if(unEchantFromBdd != null){
            //On affiche les nouvelles info de l’echantillon pour vérifié que le lib de l’echantillon a bien été maj
            Toast.makeText(this, unEchantFromBdd.getLibelle(), Toast.LENGTH_LONG).show();
            //on supprime le unEchant de la BDD grâce à son ID
            echantBdd.removeEchantillonWithCode(unEchantFromBdd.getCode());
        }

        //On essait d'extraire de nouveau l’echantillon de la BDD toujours grâce à son nouveau libelle
        unEchantFromBdd = echantBdd.getEchantillonWithLib("lib2");
        //Si aucun unEchant n'est retourné

        if(unEchantFromBdd == null){
            //On affiche un message indiquant que l’echantillon n'existe pas dans la BDD
            Toast.makeText(this, "Cet echantillon n'existe pas dans la BDD", Toast.LENGTH_LONG).show();
        }

        else{
            //Si l'Aechantillon existe (mais normalement il ne devrait pas)
            //on affiche un message indiquant que l’echantillon existe dans la BDD
            Toast.makeText(this, "Cet echantillon existe dans la BDD", Toast.LENGTH_LONG).show();
        }
        echantBdd.close();
    }*/

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
            case R.id.rea:
                Intent intent4 = new Intent(this, ReaEchant.class);
                startActivity(intent4);
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

    public void openReaEchantillon(View view){
        Intent intent4 = new Intent(this, ReaEchant.class);
        startActivity(intent4);
    }

    public void quitApp(View view){
        finish();
    }
}