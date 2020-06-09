
/**
 * clasa responsabila cu fereastra pentru crearea ofertelor
 */
package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.Model.Cazare;
import com.example.bookgo.Model.Client;
import com.example.bookgo.Model.Oferte;
import com.example.bookgo.Model.Transport;
import com.example.bookgo.R;

import java.util.ArrayList;

public class OfertaBL extends Activity {
    DatabaseHelper myDB;
    Button btn;
    Spinner cazare;
    Spinner transport;
    TextView textView;
    int idCazare;
    int idTransport;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addoferta);
        myDB=new DatabaseHelper(this);


        btn = (Button)findViewById(R.id.button15);
        cazare=(Spinner)findViewById(R.id.spinner);
        transport=(Spinner)findViewById(R.id.spinner2);
        //textView=(TextView) findViewById(R.id.textView7);


        Intent intent=getIntent();
        final String idFS=intent.getStringExtra("ID");
        final int idF= Integer.parseInt(idFS);

        final ArrayList<Cazare> cazares=myDB.listaCazareFurnizor(idF);
        final ArrayList<Transport> transports=myDB.listaTransportFurnizor(idF);
        //spinner cazare
        ArrayList<String> list=listaCazari(cazares);
        ArrayList<String> list2=listaTransport(transports);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        cazare.setAdapter(adapter);
        cazare.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idCazare=cazares.get(position).getIdCazare();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list2);
        transport.setAdapter(adapter2);
        transport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idTransport=transports.get(position).getIdTransport();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Oferte oferte=new Oferte(idCazare,idTransport,idF);
                boolean isInserted= myDB.insertOferta(oferte);
                if (isInserted==true){
                    Toast.makeText( OfertaBL.this,"Oferta a fost creata cu succes",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText( OfertaBL.this,"Oferta nu fost creata!",Toast.LENGTH_LONG).show();

                }

            }
        });



    }


    public ArrayList<String> listaCazari(ArrayList<Cazare> cazares){
        ArrayList<String> listaCazari=new ArrayList<>();
        for (Cazare cazare:cazares){
            String result=cazare.getIdCazare()+" "+cazare.getLocatie()+" "+cazare.getPret()+" "+cazare.getTipCazare();
            listaCazari.add(result);
        }
        return listaCazari;
    }

    public ArrayList<String> listaTransport(ArrayList<Transport> transports){
        ArrayList<String> listaTransport=new ArrayList<>();
        for (Transport transport:transports){
            String result=transport.getIdTransport()+" "+transport.getLocatieStart()+" "+transport.getLocatieStop()+" "+transport.getTipTransport()+" "+transport.getPret();
            listaTransport.add(result);
        }
        return listaTransport;
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
