package com.example.imdb_movie_app.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imdb_movie_app.Modelss.Search_array_objects;
import com.example.imdb_movie_app.R;
import com.example.imdb_movie_app.listener.On_movie_click_listener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Home_recycler_adapter extends RecyclerView.Adapter<HomeViewHolder>{
   Context context;
   List<Search_array_objects> list;
   On_movie_click_listener listener;

    public Home_recycler_adapter(Context context, List<Search_array_objects> list, On_movie_click_listener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.home_movie_list, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getTitle());
        holder.textView.setSelected(true);
        Picasso.get().load(list.get(position).getImage()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.on_movie_clicked(list.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class HomeViewHolder extends RecyclerView.ViewHolder {

     ImageView imageView;
    TextView textView;
    CardView cardView;
    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView=itemView.findViewById(R.id.image_view_poster_id);
        textView=itemView.findViewById(R.id.movie_name_id);
        cardView=itemView.findViewById(R.id.home_contaoner_id);
    }
}

