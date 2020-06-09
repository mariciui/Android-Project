
/**
 * clasa responsabila cu fereastra pentru afisarea listei de transporturi
 */

package com.example.bookgo.Controller.BL;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.Model.Cazare;
import com.example.bookgo.Model.Transport;
import com.example.bookgo.R;

import java.util.ArrayList;

public class ViewTransportBL extends Activity {
    DatabaseHelper myDB;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewtransport);
        myDB=new DatabaseHelper(this);

        textView=(TextView)findViewById(R.id.textView9) ;

        loadTransport();

    }

    public void  loadTransport(){
        ArrayList<Transport> transports=myDB.listaTransport();

        for(Transport transport:transports){
            String result=transport.getIdTransport()+" "+"Traseu: "+transport.getLocatieStart()+"-"+transport.getLocatieStop()+"\n";
            result+="Pret:"+transport.getPret()+"\n";
            result+="Tip transport"+transport.getTipTransport()+"\n";
            result+="Data start/stop:"+transport.getDataStart()+"-"+transport.getDataStop()+"\n\n";
            textView.append(result);
        }
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
