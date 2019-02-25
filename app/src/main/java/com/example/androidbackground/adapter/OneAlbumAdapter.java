package com.example.androidbackground.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.androidbackground.Activity.DownloadComputerPictureActivity;
import com.example.androidbackground.Class.AlbumPicture;
import com.example.androidbackground.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class OneAlbumAdapter extends RecyclerView.Adapter<OneAlbumAdapter.ViewHolder> {

    private List<AlbumPicture> albumPictureList = new ArrayList<>();
    private Context context;

    public void setData(List<AlbumPicture> albumPictureList) {
        this.albumPictureList = albumPictureList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.one_album_picture, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.album_picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                AlbumPicture albumPicture = albumPictureList.get(position);
                new DownloadComputerPictureActivity().actionStart(context, null, albumPicture.getAtime(),
                        albumPicture.getRank(), -1, albumPicture.getFavs(), albumPicture.getWp(),
                        albumPicture.getId(), albumPicture.getThumb());
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Picasso.with(context).load(albumPictureList.get(i).getPreview()).placeholder(R.drawable.loading_detail).
                error(R.drawable.loading_no_more).into(viewHolder.album_picture);
    }

    @Override
    public int getItemCount() {
        return albumPictureList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView album_picture;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            album_picture = itemView.findViewById(R.id.album_picture);
        }
    }

}
