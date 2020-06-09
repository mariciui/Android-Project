
/**
 * clasa responsabila cu fereastra pentru crearea rezervarilor
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
import android.widget.Spinner;
import android.widget.Toast;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.Model.Cazare;
import com.example.bookgo.Model.Client;
import com.example.bookgo.Model.Oferte;
import com.example.bookgo.Model.Rezervare;
import com.example.bookgo.Model.Transport;
import com.example.bookgo.R;

import java.util.ArrayList;

public class RezervareBL extends Activity {
    Spinner spinnerCazare,spinnerTransport,spinnerOferta;
    CheckBox checkBox1,checkBox2,checkBox3;
    DatabaseHelper myDB;
    Button btn;

    int idCazare,idTransport,idOferta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rezervari);
        myDB=new DatabaseHelper(this);

        btn = (Button)findViewById(R.id.button22);
        spinnerCazare=(Spinner)findViewById(R.id.spinner3);
        spinnerTransport=(Spinner)findViewById(R.id.spinner4);
        spinnerOferta=(Spinner)findViewById(R.id.spinner5);
        checkBox1=(CheckBox) findViewById(R.id.checkBox7);
        checkBox2=(CheckBox) findViewById(R.id.checkBox8);
        checkBox3=(CheckBox) findViewById(R.id.checkBox9);
        Intent intent=getIntent();
        final String idCS=intent.getStringExtra("ID");
        final int idC= Integer.parseInt(idCS);

        final ArrayList<Cazare> cazares=myDB.listaCazare();
        final ArrayList<Transport> transports=myDB.listaTransport();
        final ArrayList<Oferte> ofertes=myDB.listaOferte();
        //spinner cazare
        ArrayList<String> list=listaCazari(cazares);
        ArrayList<String> list2=listaTransport(transports);
        ArrayList<String> list3=listaOferte(ofertes);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list);
        spinnerCazare.setAdapter(adapter);
        spinnerCazare.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idCazare=cazares.get(position).getIdCazare();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list2);
        spinnerTransport.setAdapter(adapter2);
        spinnerTransport.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idTransport=transports.get(position).getIdTransport();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,list3);
        spinnerOferta.setAdapter(adapter3);
        spinnerOferta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idOferta=ofertes.get(position).getIdOferta();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cazare cazare=new Cazare();
                if(checkBox1.isChecked()){
                    cazare.setIdCazare(idCazare);
                }else{
                    cazare.setIdCazare(-1);
                }


                Transport transport=new Transport();
                if(checkBox2.isChecked()){
                    transport.setIdTransport(idTransport);
                }else{
                    transport.setIdTransport(-1);
                }
                Oferte oferte=new Oferte();
                if(checkBox3.isChecked()){
                    oferte.setIdOferta(idOferta);
                }else{
                    oferte.setIdOferta(-1);
                }

                Client client=new Client(); client.setIdClient(idC);
                Rezervare rezervare=new Rezervare(cazare,transport,client,oferte,"","");

                boolean isInserted= myDB.insertRezervare(rezervare);
                if (isInserted==true){
                    Toast.makeText(RezervareBL.this,"Rezervare efectuata cu succes",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(RezervareBL.this,"Rezervarea nu a fost efectuata!",Toast.LENGTH_LONG).show();

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

    public ArrayList<String> listaOferte(ArrayList<Oferte> ofertes){
        ArrayList<String> listaOferta=new ArrayList<>();

        for(Oferte oferte: ofertes){
            Cazare cazare=myDB.findCazareID(oferte.getCazare());
            Transport transport=myDB.findTransportID(oferte.getCazare());
            float pret=cazare.getPret()+transport.getPret();
            String result=oferte.getIdOferta()+" "+cazare.getLocatie()+" "+cazare.getTipCazare()+" "+cazare.getDataStart()+" "+cazare.getDataStop()+ " ";
            result+=transport.getTipTransport()+" "+pret;
            listaOferta.add(result);
        }
        return listaOferta;
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
