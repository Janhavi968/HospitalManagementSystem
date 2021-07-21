package com.example.hospitalmanagementsystem1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private EditText names,ages,numbers,dates,lt_name,lt_age,lt_number,lt_date;
    private Button btns,loads;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Test test;
    private ListView listViews;
    final  ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        names = findViewById(R.id.names);
        ages = findViewById(R.id.ages);
        dates=findViewById(R.id.dates);
        btns = findViewById(R.id.btns);
        numbers=findViewById(R.id.numbers);
        lt_name = findViewById(R.id.lt_name);
        lt_age = findViewById(R.id.lt_age);

        lt_number = findViewById(R.id.lt_number);

        lt_date = findViewById(R.id.lt_date);

        //listViews = findViewById(R.id.listviews);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Lab Test");
        test = new Test();
        loads = findViewById(R.id.loads);
        btns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names_holder = names.getText().toString();
                String ages_holder = ages.getText().toString();
                String numbers_holder = numbers.getText().toString();
                String dates_holder = dates.getText().toString();
                if(TextUtils.isEmpty(names_holder) && TextUtils.isEmpty(ages_holder)){
                    Toast.makeText(MainActivity.this,"Please add some data",Toast.LENGTH_SHORT).show();
                }else {
                    addDatatoFirebase(names_holder,ages_holder,numbers_holder,dates_holder);

                }
            }
        });
        loads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names_holder = names.getText().toString();
                String ages_holder = ages.getText().toString();
                String numbers_holder = numbers.getText().toString();
                String dates_holder = dates.getText().toString();
                getdata(numbers_holder,ages_holder,names_holder,dates_holder);

            }
        });






    }
    private void addDatatoFirebase(String names,String ages,String numbers,String dates)
    {
        test.setAges(ages);
        test.setNames(names);
        test.setNumbers(numbers);
        test.setDates(dates);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull  DataSnapshot snapshot) {
                databaseReference.child(numbers).setValue(test);
                Toast.makeText(MainActivity.this,"Test booked",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MainActivity.this,"Fail to add data"+error,Toast.LENGTH_SHORT).show();

            }
        });
    }
    private  void getdata(String numbers,String ages,String names,String dates)
    {
        lt_date.setText(dates);
        lt_number.setText(numbers);
        lt_age.setText(ages);
        lt_name.setText(names);
    }

}
