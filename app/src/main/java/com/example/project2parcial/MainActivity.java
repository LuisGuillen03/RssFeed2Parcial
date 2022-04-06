package com.example.project2parcial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.portada);
    }
    public void Tend(View view){
        Intent siguiente=new Intent(this,BusquedaTend.class);
        startActivity(siguiente);
    }
    public void Perso(View view){
        Intent siguiente=new Intent(this,Search.class);
        startActivity(siguiente);
    }
    public void Profile(View view){
        Intent siguiente=new Intent(this,Profile.class);
        startActivity(siguiente);
    }
}

