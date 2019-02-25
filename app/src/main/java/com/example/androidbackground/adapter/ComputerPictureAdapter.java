package com.example.androidbackground.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.androidbackground.Activity.ComputerTypePictureActivity;
import com.example.androidbackground.Class.ComputerPicture;
import com.example.androidbackground.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ComputerPictureAdapter extends RecyclerView.Adapter<ComputerPictureAdapter.ViewHolder> {

    String typeHotUrl;
    String typeNewUrl;
    List<ComputerPicture> computerPictures;
    Context context;

    public void setData(List<ComputerPicture> computerPictures) {
        this.computerPictures = computerPictures;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.picture, viewGroup, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.iv_picture.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = viewHolder.getAdapterPosition();
                    typeHotUrl = "http://service.picasso.adesk.com/v1/wallpaper/category/" + computerPictures.get(position).getSortId()
                            + "/wallpaper?limit=48&adult=false&first=1&order=hot";
                    typeNewUrl = "http://service.picasso.adesk.com/v1/wallpaper/category/" + computerPictures.get(position).getSortId()
                            + "/wallpaper?limit=48&adult=false&first=1&order=new";
                    ComputerTypePictureActivity.actionStart(context, computerPictures.get(position).getSortName(), typeNewUrl, typeHotUrl);
                }
            });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        ComputerPicture computerPicture = computerPictures.get(i);
        Picasso.with(context).load(computerPicture.getSortCover()).placeholder(R.drawable.tacitly_approve_picture).
                error(R.drawable.wrong_picture).into(viewHolder.iv_picture);
        viewHolder.category.setText(computerPicture.getSortName());
    }

    @Override
    public int getItemCount() {
        return computerPictures.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_picture;
        TextView category;
        public ViewHolder(View view) {
            super(view);
            iv_picture = view.findViewById(R.id.iv_picture);
            category = view.findViewById(R.id.category);
        }
    }
}
