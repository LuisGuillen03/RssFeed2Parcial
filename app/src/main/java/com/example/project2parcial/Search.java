package com.example.project2parcial;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Search extends AppCompatActivity {
    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.busquedaperso);

        et1 = (EditText)findViewById(R.id.editTextBuscado);
    }
    public void showme(View view){
        Intent siguiente=new Intent(this,BusquedaPerso.class);
        siguiente.putExtra("dato",et1.getText().toString());
        startActivity(siguiente);
    }
}