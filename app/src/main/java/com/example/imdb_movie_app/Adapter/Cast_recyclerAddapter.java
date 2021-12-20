package com.example.imdb_movie_app.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdb_movie_app.Modelss.Cast;
import com.example.imdb_movie_app.R;

import java.util.List;

public class Cast_recyclerAddapter extends RecyclerView.Adapter<cast_view_holder>{
   Context context;
   List<Cast> list;

    public Cast_recyclerAddapter(Context context, List<Cast> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public cast_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cast_view_holder(LayoutInflater.from(context).inflate(R.layout.cast_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull cast_view_holder holder, int position) {

        holder.actor.setText(list.get(position).getActor());
        holder.character.setText(list.get(position).getCharacter());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class cast_view_holder extends RecyclerView.ViewHolder {


    TextView actor, character;

    public cast_view_holder(@NonNull View itemView) {
        super(itemView);

        actor = itemView.findViewById(R.id.actor_id);
        character = itemView.findViewById(R.id.character_id);
    }
}
