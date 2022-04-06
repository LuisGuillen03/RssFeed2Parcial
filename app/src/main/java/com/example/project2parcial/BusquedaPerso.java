package com.example.project2parcial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class BusquedaPerso extends AppCompatActivity {
    private RecyclerView recycler;
    private elemento Elemento;
    private ArrayList<elemento> lista;
    private Adapter Adapt;
    private com.android.volley.RequestQueue RequestQueue;
    public Context context=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler=findViewById(R.id.Recycler_Vista);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        lista=new ArrayList<>();
        RequestQueue= Volley.newRequestQueue(this);

        parseJSON();
    }

    private void parseJSON(){
        String dato=getIntent().getStringExtra("dato");

        String URL="https://pixabay.com/api/?key=26496692-25e6c7969eeec864f2a87be37&q=" + dato + "&image_type=photo&pretty=true";

        JsonObjectRequest request= new JsonObjectRequest(Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{
                    JSONArray jsonArray=response.getJSONArray("hits");

                    for(int i=0; i< jsonArray.length();i++){
                        JSONObject hit = jsonArray.getJSONObject(i);

                        String NCreador=hit.getString("user");
                        String imageURL=hit.getString("webformatURL");
                        int likeCount=hit.getInt("likes");

                        lista.add(new elemento(imageURL,NCreador,likeCount));
                    }
                    Adapt =new Adapter(context,lista);
                    recycler.setAdapter(Adapt);
                } catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        RequestQueue.add(request);
    }
}
