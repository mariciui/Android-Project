
/**
 * clasa responsabila cu fereastra pentru afisarea paginii de creare cont nou
 */

package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.Model.Admin;
import com.example.bookgo.Model.Client;
import com.example.bookgo.Model.Furnizor;
import com.example.bookgo.R;

import java.util.Observable;

public class SingUp extends Activity {
    DatabaseHelper myDB;
    EditText userLogTb,parolaTb,numeTb,prenumeTb,dataNasteriiTb;
    Button addBtn;
    CheckBox checkBox;
    Obs o = new Obs();
    Observable observable;
    Admin admin;
    Obs obs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        admin = new Admin("admin", "admin");
        obs = new Obs();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.signupwindow);
        myDB=new DatabaseHelper(this);

        userLogTb=(EditText)findViewById(R.id.editText7);
        parolaTb=(EditText)findViewById(R.id.editText8);
        numeTb=(EditText)findViewById(R.id.editText);
        prenumeTb=(EditText)findViewById(R.id.editText6);
        dataNasteriiTb=(EditText)findViewById(R.id.editText9);

        checkBox=(CheckBox)findViewById(R.id.checkBox) ;
        addBtn=(Button)findViewById(R.id.button5);

        observable = new Observable();

        add();


    }

    public void add(){
        addBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if (checkBox.isChecked()){
                            Furnizor furnizor=new Furnizor(userLogTb.getText().toString(),parolaTb.getText().toString(),numeTb.getText().toString(),prenumeTb.getText().toString(),dataNasteriiTb.getText().toString());

                            obs.registerObserver(admin);
                            obs.notify(observable, furnizor);

                            boolean isInserted= myDB.insertFurnizor(furnizor);
                            if (isInserted==true){
                                Toast.makeText(SingUp.this,"Furnizorul a fost creat cu succes",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(SingUp.this,"Furnizorul nu fost creat!",Toast.LENGTH_LONG).show();

                            }
                        }else{
                            Client client=new Client(userLogTb.getText().toString(),parolaTb.getText().toString(),numeTb.getText().toString(),prenumeTb.getText().toString(),"user",100,dataNasteriiTb.getText().toString());

                            boolean isInserted= myDB.insertClient(client);
                            if (isInserted==true){
                                Toast.makeText(SingUp.this,"Clientul a fost creat cu succes",Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(SingUp.this,"Clientul nu fost creat!",Toast.LENGTH_LONG).show();

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
