package com.example.androidbackground.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.androidbackground.Activity.DownloadComputerPictureActivity;
import com.example.androidbackground.Activity.DownloadPictureActivity;
import com.example.androidbackground.Class.Picture;
import com.example.androidbackground.R;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class PictureAdapterBySort extends RecyclerView.Adapter<PictureAdapterBySort.ViewHolder> {

    private Context context;
    private String distinguish;

    private List<Picture> pictureList = new ArrayList<>();

    public void setData(List<Picture> pictureList,String distinguish) {
        this.pictureList = pictureList;
        this.distinguish = distinguish;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_picture;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            if (distinguish.equals("computer")) {
                iv_picture = itemView.findViewById(R.id.iv_computer_picture);
            } else {
                iv_picture = itemView.findViewById(R.id.iv_picture_show);
            }
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view;
        final ViewHolder viewHolder;
        if (distinguish.equals("computer")) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.computer_picture, viewGroup, false);
            viewHolder = new ViewHolder(view);
            viewHolder.iv_picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition();
                    DownloadComputerPictureActivity.actionStart(context, pictureList.get(position).getTag(),
                            pictureList.get(position).getAtime(), pictureList.get(position).getRank(),
                            pictureList.get(position).getViews(), pictureList.get(position).getFavs(),
                            pictureList.get(position).getWp(), pictureList.get(position).getPictureID(),
                            pictureList.get(position).getImageURL());
                }
            });
        } else {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.picture_commend, viewGroup, false);
            viewHolder = new ViewHolder(view);
            viewHolder.iv_picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition();
                    DownloadPictureActivity.actionStart(context, pictureList.get(position).getTag(),
                            pictureList.get(position).getAtime(), pictureList.get(position).getRank(),
                            pictureList.get(position).getViews(), pictureList.get(position).getFavs(),
                            pictureList.get(position).getWp(), pictureList.get(position).getPictureID(),
                            pictureList.get(position).getImageURL());
                }
            });
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PictureAdapterBySort.ViewHolder viewHolder, int position) {
        Picture picture = pictureList.get(position);
        if (distinguish.equals("computer")) {
            Picasso.with(context).load(picture.getPictureThumb()).
                    placeholder(R.drawable.tacitly_approve_picture).
                    error(R.drawable.wrong_picture_computer).into(viewHolder.iv_picture);
        } else {
            Picasso.with(context).load(picture.getPictureThumb()).
                    placeholder(R.drawable.tacitly_approve_commend).
                    error(R.drawable.wrong_picture).into(viewHolder.iv_picture);
        }
    }

    @Override
    public int getItemCount() {
        return pictureList.size();
    }

}
