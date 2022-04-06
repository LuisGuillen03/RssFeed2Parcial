package com.example.project2parcial;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private Context mContext;
    private ArrayList<elemento> mLista;

    public Adapter (Context context,ArrayList<elemento> lista){
        mContext=context;
        mLista=lista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mContext).inflate(R.layout.elemento,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        elemento actual=mLista.get(position);
        String urlImg= actual.getmImgUrl();
        String mCreador= actual.getmCreador();
        int mLikes=actual.getmLikes();

        holder.mCreador.setText("Creador: "+mCreador);
        holder.mLikes.setText("Likes: "+mLikes);
        Picasso.with(mContext).load(urlImg).fit().centerInside().into(holder.mImagen);
    }

    @Override
    public int getItemCount() {
        return mLista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImagen;
        public TextView mCreador;
        public  TextView mLikes;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImagen= itemView.findViewById(R.id.imagen_vista);
            mCreador= itemView.findViewById(R.id.text_creador);
            mLikes= itemView.findViewById(R.id.text_likes);
        }
    }
}
