package com.example.androidbackground.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.androidbackground.Activity.DownloadPictureActivity;
import com.example.androidbackground.Activity.SortPictureActivity;
import com.example.androidbackground.Class.Picture;
import com.example.androidbackground.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class PictureAdapter extends RecyclerView.Adapter<PictureAdapter.ViewHolder> {
    private List<Picture> picturesList;                                         //图片类集合
    private Context context;                                                    //获取上下文
    private Bitmap bitmap;

    public void setData(List<Picture> picturesList) {
        this.picturesList = picturesList;
        notifyDataSetChanged();                                                 //告诉RecyclerView： 数据更新了
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = null;
        context = viewGroup.getContext();
        if (picturesList.get(0).getGenre().equalsIgnoreCase("commend")) {
            view = LayoutInflater.from(context).inflate(R.layout.picture_commend, viewGroup, false);
        } else if (picturesList.get(0).getGenre().equalsIgnoreCase("sort")) {
            view = LayoutInflater.from(context).inflate(R.layout.picture, viewGroup, false);
        }
        final ViewHolder viewHolder = new ViewHolder(view);

        //设置每一个图片的点击事件
        if (picturesList.get(0).getGenre().equalsIgnoreCase("commend")) {
            viewHolder.iv_picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition();
                    DownloadPictureActivity.actionStart(context, picturesList.get(position).getTag(),
                            picturesList.get(position).getAtime(), picturesList.get(position).getRank(),
                            picturesList.get(position).getViews(), picturesList.get(position).getFavs(),
                            picturesList.get(position).getWp(), picturesList.get(position).getPictureID(),
                            picturesList.get(position).getImageURL());
                }
            });
        } else if (picturesList.get(0).getGenre().equalsIgnoreCase("sort")) {
            viewHolder.iv_picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition();
                    SortPictureActivity.actionStart(context, picturesList.get(position).getName(),
                            picturesList.get(position).getTypeNewUrl(), picturesList.get(position).getTypeHotUrl());
                }
            });
        }
        return viewHolder;
    }

    //设置图片
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Picture picture = picturesList.get(position);
        if (picturesList.get(0).getGenre().equalsIgnoreCase("commend")) {
            Picasso.with(context).load(picture.getPictureThumb()).placeholder(R.drawable.tacitly_approve_commend).
                    error(R.drawable.wrong_picture).into(viewHolder.iv_picture);
        } else if (picturesList.get(0).getGenre().equalsIgnoreCase("sort")) {
            Picasso.with(context).load(picture.getImageURL()).placeholder(R.drawable.tacitly_approve_picture).
                    error(R.drawable.wrong_picture).into(viewHolder.iv_picture);
            viewHolder.category.setText(picturesList.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return picturesList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv_picture;
        TextView category;

        public ViewHolder(View itemView){
            super(itemView);

            //按不同对象获取不同的布局并实例化
            if (picturesList.get(0).getGenre().equalsIgnoreCase("commend")) {
                iv_picture = itemView.findViewById(R.id.iv_picture_show);
            } else if (picturesList.get(0).getGenre().equalsIgnoreCase("sort")) {
                iv_picture = itemView.findViewById(R.id.iv_picture);
                category = itemView.findViewById(R.id.category);
            }
        }

    }

}
