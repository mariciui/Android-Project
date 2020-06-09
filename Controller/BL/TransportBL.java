
/**
 * clasa responsabila cu fereastra pentru adaugarea de transporturi
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
import com.example.bookgo.Model.Transport;
import com.example.bookgo.R;

public class TransportBL extends Activity {
    DatabaseHelper myDB;
    EditText dataInc, dataSf, locatieInc, locatieSf, pret;
    CheckBox avion, autocar;
    Button btn;
    String tip;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transportwindow);
        myDB=new DatabaseHelper(this);

        dataInc = (EditText)findViewById(R.id.editText16);
        dataSf = (EditText)findViewById(R.id.editText18);
        locatieInc = (EditText)findViewById(R.id.editText20);
        locatieSf = (EditText)findViewById(R.id.editText22);
        pret = (EditText)findViewById(R.id.editText21);

        avion = (CheckBox)findViewById(R.id.checkBox4);
        autocar = (CheckBox)findViewById(R.id.checkBox6);

        btn = (Button)findViewById(R.id.button10);

        Intent intent=getIntent();
        final String idFS=intent.getStringExtra("ID");
        int idF= Integer.parseInt(idFS);

        add(idF);
    }

    public void add(final int idF){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (avion.isChecked())
                {
                    tip = "avion";
                }
                else if (autocar.isChecked())
                    tip = "autocar";
                int pretint = Integer.parseInt(pret.getText().toString());
                Transport transport = new Transport(idF,locatieInc.getText().toString(), locatieSf.getText().toString(),pretint, dataInc.getText().toString(),dataSf.getText().toString(),tip);


                boolean isInserted = myDB.insertTransport(transport);
                if (isInserted==true){
                    Toast.makeText(TransportBL.this,"Transportul a fost creat cu succes",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(TransportBL.this,"Trnasportul nu fost creat!",Toast.LENGTH_LONG).show();
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
