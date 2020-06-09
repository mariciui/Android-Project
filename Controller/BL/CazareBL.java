/**
 * clasa responsabila cu fereastra de adaugare cazare
 */

package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.Model.Cazare;
import com.example.bookgo.R;

public class CazareBL extends Activity {
    DatabaseHelper myDB;
    EditText locatie,pret,dataInc,dataSf;
    CheckBox hotel, apartament;
    Button btn;
    String tip;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cazarewindow);

        myDB=new DatabaseHelper(this);

        locatie = (EditText)findViewById(R.id.editText17);
        pret = (EditText)findViewById(R.id.editText19);
        dataInc = (EditText)findViewById(R.id.editText5);
        dataSf = (EditText)findViewById(R.id.editText15);

        hotel = (CheckBox)findViewById(R.id.checkBox3);
        apartament = (CheckBox)findViewById(R.id.checkBox5);

        btn = (Button)findViewById(R.id.button9);

        Intent intent=getIntent();
        final String idFS=intent.getStringExtra("ID");
        int idF= Integer.parseInt(idFS);

        add(idF);


    }

    public void add(final int idF){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hotel.isChecked())
                {
                    tip = "hotel";
                }
                else if (apartament.isChecked()){
                    tip = "apartament";
                }

                int pretint = Integer.parseInt(pret.getText().toString());
                Cazare cazare = new Cazare(idF,locatie.getText().toString(),pretint, dataInc.getText().toString(),dataSf.getText().toString(), tip);

                boolean isInserted = myDB.insertCazare(cazare);
                if (isInserted==true){
                    Toast.makeText(CazareBL.this,"Cazarea a fost creata cu succes",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(CazareBL.this,"Cazarea nu fost creata!",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }
}
