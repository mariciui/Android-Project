package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookgo.R;

/**
 * clasa responsabila cu fereastra pentru client
 */
public class PaginaClient extends Activity {

    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clientwindow);
        Intent intent=getIntent();
        final String idCS=intent.getStringExtra("ID");

        btn1=(Button)findViewById(R.id.button16);
        btn2=(Button)findViewById(R.id.button17);
      //  btn3=(Button)findViewById(R.id.button18);


        //vizualizare
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openWindow = new Intent(v.getContext(), PaginaVizualizare.class);
                startActivity(openWindow);


            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openRezervareWindow = new Intent(v.getContext(), RezervareBL.class);
                openRezervareWindow.putExtra("ID",idCS);
                startActivity(openRezervareWindow);

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
