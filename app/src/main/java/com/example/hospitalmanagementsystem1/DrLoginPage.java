package com.example.hospitalmanagementsystem1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class DrLoginPage extends AppCompatActivity {
    Button Login;
    EditText drphone,password;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr_login_page);
        Login=findViewById(R.id.login_button);
        drphone = findViewById(R.id.dphone);
        password = findViewById(R.id.drpass);
        if(Login!=null) {

            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String phone = drphone.getText().toString();
                    String drpass = password.getText().toString();
                    if(phone.isEmpty() || drpass.isEmpty()){
                        Toast.makeText(DrLoginPage.this,"Fields cant be empty",Toast.LENGTH_SHORT).show();
                    }else{
                        Intent intent = new Intent(DrLoginPage.this,viewappointments.class);
                        startActivity(intent);
                    }
                }

            });
        }

    }
    /*public void Login_clicked(){
        if(!ValidateFields()){
            return;
        }
        else{
            Intent intent = new Intent(DrLoginPage.this,viewappointments.class);
            startActivity(intent);
        }



    }

    private Boolean ValidateFields(){
        String Username = drphone.getText().toString().trim();
        String Password = password.getText().toString().trim();

        if(Username.isEmpty()){
            Toast.makeText(DrLoginPage.this,"Username cant be empty",Toast.LENGTH_SHORT).show();
        }else if(Password.isEmpty()){
            Toast.makeText(DrLoginPage.this,"Password cant be empty",Toast.LENGTH_SHORT).show();
        }

        return true;
    }*/
}
