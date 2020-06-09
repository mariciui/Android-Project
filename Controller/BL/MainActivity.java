
/**
 * clasa responsabila cu fereastra principala a aplicatiei
 */
package com.example.bookgo.Controller.BL;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bookgo.Controller.DAO.DatabaseHelper;
import com.example.bookgo.R;


public class MainActivity extends Activity {
    DatabaseHelper myDB;

    Button btnLogIn;
    Button btnSignUp;
    Button btnGuest;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        myDB = new DatabaseHelper(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogIn = (Button) findViewById(R.id.button);
        btnSignUp = (Button) findViewById(R.id.button2);
        btnGuest = (Button)findViewById(R.id.button3);



        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openSecondWindow = new Intent(v.getContext(), SingUp.class);
                startActivity(openSecondWindow);
            }
        });

        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openLogIn = new Intent(v.getContext(), LogIn.class);
                startActivity(openLogIn);
            }
        });

        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openGuest = new Intent(v.getContext(), Guest.class);
                startActivity(openGuest);
            }
        });




    }
}
