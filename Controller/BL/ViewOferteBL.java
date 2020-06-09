
/**
 * clasa responsabila cu fereastra pentru afisarea listei de oferte
 */

package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.Model.Cazare;
import com.example.bookgo.Model.Oferte;
import com.example.bookgo.Model.Transport;
import com.example.bookgo.R;

import java.util.ArrayList;

public class ViewOferteBL extends Activity {
    DatabaseHelper myDB;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewoferte);
        myDB=new DatabaseHelper(this);

        textView=(TextView)findViewById(R.id.textView12) ;

        loadOferte();




    }

    public void loadOferte(){
        ArrayList<Oferte> ofertes=myDB.listaOferte();

        for(Oferte oferte: ofertes){
            Cazare cazare=myDB.findCazareID(oferte.getCazare());
            Transport transport=myDB.findTransportID(oferte.getCazare());
            float pret=cazare.getPret()+transport.getPret();
            String result=oferte.getIdOferta()+" "+"Locatie: "+cazare.getLocatie()+"\n";
            result+="Tip cazare: "+cazare.getTipCazare()+"\n";
            result+="Perioada: "+cazare.getDataStart()+"-"+cazare.getDataStop()+ "\n";
            result+="Tip transport: "+transport.getTipTransport()+"\n"+"Pret:"+pret+"\n\n";
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
