/**
 * clasa responsabila cu fereastra de log in
 */

package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.Model.Client;
import com.example.bookgo.Model.Furnizor;
import com.example.bookgo.R;

public class LogIn extends Activity {
    DatabaseHelper myDB;
    EditText txtUser;
    EditText txtPass;
    CheckBox checkBox;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signinwindow);

        myDB=new DatabaseHelper(this);

        txtUser = (EditText) findViewById(R.id.editText2);
        txtPass = (EditText) findViewById(R.id.editText3);
        btn = (Button)findViewById(R.id.button4);
        checkBox=(CheckBox) findViewById(R.id.checkBox2);

        login();

    }

    public void login(){
        btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String user=txtUser.getText().toString();
                        String pas=txtPass.getText().toString();

                        if(checkBox.isChecked()){
                            Furnizor furnizor=myDB.findFunizorByUserLog(user);
                            System.out.println("ID Furnizor "+ furnizor.getIdFurnizor()+"Parola "+furnizor.getParola());

                            if (pas.equals(furnizor.getParola())){
                                System.out.println("Am intrat in if");
                                Toast.makeText(LogIn.this,"Bine ati venit",Toast.LENGTH_LONG).show();

                                Intent suppWindow = new Intent(v.getContext(),Supplier.class);
                                String idFS= String.valueOf(furnizor.getIdFurnizor());
                                suppWindow.putExtra("ID",idFS);
                                startActivity(suppWindow);
                            }
                            else{
                                Toast.makeText(LogIn.this,"User sau parola gresita",Toast.LENGTH_LONG).show();

                            }

                        }else{
                            Client client = myDB.findClientByUserLog(user);

                            if (pas.equals(client.getParola())){
                                Intent clientWindow = new Intent(v.getContext(),PaginaClient.class);
                                String idFS= String.valueOf(client.getIdClient());
                                clientWindow.putExtra("ID",idFS);
                                startActivity(clientWindow);
                                Toast.makeText(LogIn.this,"Bine ati venit",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(LogIn.this,"User sau parola gresita",Toast.LENGTH_LONG).show();

                            }
                        }

                    }
                }
        );
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
