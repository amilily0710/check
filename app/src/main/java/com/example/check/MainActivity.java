package com.example.check;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
  Button button;
  FirebaseDatabase database;
  DatabaseReference reference;
  Member member;
  int i = 0;


  CheckBox c1,c2,c3,c4,c5,c6,c7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reference = database.getInstance().getReference().child("week");

        member = new Member();

        button = findViewById(R.id.Button);
        c1=findViewById(R.id.Monday);
        c2=findViewById(R.id.Tuesday);
        c3=findViewById(R.id.Wednesday);
        c4=findViewById(R.id.Thursday);
        c5=findViewById(R.id.Friday);
        c6=findViewById(R.id.Saturday);
        c7=findViewById(R.id.Sunday);

        String d1 = "Monday";
        String d2="Tuesday";
        String d3 = "Wednesday";
        String d4 = "Thursday";
        String d5 = "Friday";
        String d6 = "Saturday";
        String d7 = "Sunday";
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    i = (int)dataSnapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (c1.isChecked()) {
                    member.setDay(d1);
                    reference.child(String.valueOf(i + 1)).setValue(member);
                } else {

                }
                if (c2.isChecked()) {
                    member.setDay(d2);
                    reference.child(String.valueOf(i + 1)).setValue(member);
                }
               else{
            }
                if(c3.isChecked()){
                    member.setDay(d3);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else{

                }
                if(c4.isChecked()){
                    member.setDay(d4);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else{

                }
                if(c5.isChecked()){
                    member.setDay(d5);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else{

                }
                if(c6.isChecked()){
                    member.setDay(d6);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else{

                }
                if(c7.isChecked()){
                    member.setDay(d7);
                    reference.child(String.valueOf(i+1)).setValue(member);
                }else{

                }

            }
        });
}}