
/**
 * clasa responsabila cu fereastra pentru afisarea furnizorului
 */

package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.Model.Furnizor;
import com.example.bookgo.R;

public class Supplier extends Activity {

    //DatabaseHelper myDB;
    Button btnCazare;
    Button btnTransport;
    Button btnOferta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supplier);

        btnCazare = (Button)findViewById(R.id.button8);
        btnTransport = (Button)findViewById(R.id.button11);
        btnOferta = (Button)findViewById(R.id.button12);

        Intent intent=getIntent();
        final String idFS=intent.getStringExtra("ID");


        btnCazare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCazareWindow = new Intent(v.getContext(), CazareBL.class);
                openCazareWindow.putExtra("ID",idFS);
                startActivity(openCazareWindow);

            }
        });

        btnTransport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openTransportWindow = new Intent(v.getContext(), TransportBL.class);
                openTransportWindow.putExtra("ID",idFS);
                startActivity(openTransportWindow);

            }
        });

        btnOferta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openOfertaWindow = new Intent(v.getContext(), OfertaBL.class);
                openOfertaWindow.putExtra("ID",idFS);
                startActivity(openOfertaWindow);

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
