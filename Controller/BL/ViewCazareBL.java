
/**
 * clasa responsabila cu fereastra pentru afisarea listei de cazari
 */

package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.Model.Cazare;
import com.example.bookgo.R;

import java.util.ArrayList;

public class ViewCazareBL extends Activity {
    DatabaseHelper myDB;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcazare);
        myDB=new DatabaseHelper(this);

        textView=(TextView)findViewById(R.id.textView18) ;

        loadCazare();




    }

    public void loadCazare(){
        ArrayList<Cazare> cazares=myDB.listaCazare();

        for(Cazare cazare:cazares){
            String result=cazare.getIdCazare()+" "+"Locatie"+" "+cazare.getLocatie()+"\n";
            result+="Perioada: "+cazare.getDataStart()+"-"+cazare.getDataStop()+ "\n";
            result+="Tip Cazare: "+" "+cazare.getTipCazare()+"\n";
            result+="Pret:"+cazare.getPret()+"\n\n";
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
