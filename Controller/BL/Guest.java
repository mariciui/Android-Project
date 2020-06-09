package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.Model.Cazare;
import com.example.bookgo.Model.Transport;
import com.example.bookgo.R;

import java.util.ArrayList;
/**
 * clasa responsabila cu fereastra vizitatorului
 */
public class Guest extends Activity {

    Button btn;
    EditText editText;
    TextView textView;
    Button btnCazare;
    Button btnTransport;

    DatabaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guestmode);
        myDB=new DatabaseHelper(this);




        btn = (Button) findViewById(R.id.button6);
        btnCazare=(Button)findViewById(R.id.button13) ;
        btnTransport=(Button)findViewById(R.id.button14) ;
        textView=(TextView)findViewById(R.id.textView4) ;
        editText=(EditText)findViewById(R.id.editText23);

        btnCazare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startC();

            }
        });

        btnTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startT();

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startF();

            }
        });



    }

    public void startC(){
        ArrayList<Cazare> cazares=myDB.listaCazare();

        for(Cazare cazare:cazares){
            String result=cazare.getIdCazare()+" "+"Locatie"+" "+cazare.getLocatie()+"\n";
            result+="Perioada: "+cazare.getDataStart()+"-"+cazare.getDataStop()+ "\n";
            result+="Tip Cazare: "+" "+cazare.getTipCazare()+"\n";
            result+="Pret:"+cazare.getPret()+"\n\n";
            textView.append(result);
        }
    }

    public void startT(){
        ArrayList<Transport> transports=myDB.listaTransport();
        textView.setText("");
        for(Transport transport:transports){
            String result=transport.getIdTransport()+" "+"Traseu: "+transport.getLocatieStart()+"-"+transport.getLocatieStop()+"\n";
            result+="Pret:"+transport.getPret()+"\n";
            result+="Tip transport"+transport.getTipTransport()+"\n";
            result+="Data start/stop:"+transport.getDataStart()+"-"+transport.getDataStop()+"\n\n";
            textView.append(result);
        }
    }

    public void startF(){
        textView.setText("");
        String locatie=editText.getText().toString();
        String data=myDB.getLocatie(locatie);
        System.out.println(data);
        textView.setText(data);

    }

    public void showMessage(String title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
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
