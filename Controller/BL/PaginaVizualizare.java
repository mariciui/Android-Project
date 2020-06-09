
/**
 * clasa responsabila cu fereastra pentru optiunile de vizualizare ale clientului
 */


package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookgo.R;

public class PaginaVizualizare extends Activity {
    Button btn1,btn2,btn3,btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vizualizare);


        btn1 = (Button) findViewById(R.id.button19);
        btn2 = (Button) findViewById(R.id.button20);
        btn3 = (Button) findViewById(R.id.button21);
        btn4 = (Button) findViewById(R.id.button23);




        //cazare
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openviewWindow = new Intent(v.getContext(), ViewCazareBL.class);
                startActivity(openviewWindow);

            }
        });
        //transport
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openviewWindow = new Intent(v.getContext(), ViewTransportBL.class);
                startActivity(openviewWindow);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openviewOferteWindow = new Intent(v.getContext(), ViewOferteBL.class);
                startActivity(openviewOferteWindow);

            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openWindowHarta = new Intent(v.getContext(), ClientMap.class);
                startActivity(openWindowHarta);
            }
        });
    }
}
