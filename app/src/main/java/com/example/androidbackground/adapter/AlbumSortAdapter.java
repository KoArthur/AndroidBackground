package com.example.androidbackground.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.androidbackground.Activity.AlbumContentActivity;
import com.example.androidbackground.Class.Album;
import com.example.androidbackground.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class AlbumSortAdapter extends RecyclerView.Adapter <AlbumSortAdapter.ViewHolder>{

    List<Album> albumList = new ArrayList<>();
    Context context;

    public void setData(List<Album> albumList) {
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.album, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.album.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = viewHolder.getAdapterPosition();
                new AlbumContentActivity().actionStart(context, albumList.get(i).getId(),
                        albumList.get(i).getName(), albumList.get(i).getLcoverUrl());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Album album = albumList.get(i);
        viewHolder.album_name.setText(album.getName());
        viewHolder.album_desc.setText(album.getDesc());
        Picasso.with(context).load(albumList.get(i).getCoverUrl()).placeholder(R.drawable.loading_detail).
                error(R.drawable.loading_no_more).into(viewHolder.album_cover);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView album_cover;
        TextView album_name;
        TextView album_desc;
        View album;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            album_cover = itemView.findViewById(R.id.album_cover);
            album_name = itemView.findViewById(R.id.album_name);
            album_desc = itemView.findViewById(R.id.album_desc);
            album = itemView;
        }
    }

}
