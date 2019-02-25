package com.example.androidbackground.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.androidbackground.Class.Comment;
import com.example.androidbackground.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.MyViewHolder> implements View.OnClickListener {

    private List<Comment> commentList = null;
    private Context context = null;

    public void setData(List<Comment> commentList) {
        this.commentList = commentList;
//        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        context = viewGroup.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.comment, viewGroup, false);
        final MyViewHolder myViewHolder = new MyViewHolder(view);
        myViewHolder.user_name.setOnClickListener(this);
        myViewHolder.user_content.setOnClickListener(this);
        myViewHolder.iv_user.setOnClickListener(this);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentAdapter.MyViewHolder myViewHolder, int i) {
        Comment comment = commentList.get(i);
        myViewHolder.user_name.setText(comment.getUserName());
        myViewHolder.user_content.setText(comment.getContent());
        Picasso.with(context).load(comment.getUser_ivUrl()).placeholder(R.drawable.loading_detail).
                error(R.drawable.loading_no_more).into(myViewHolder.iv_user);
    }

    @Override
    public int getItemCount() {
        return commentList.size();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_user:
                Toast.makeText(context, "点击了头像！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_content:
                Toast.makeText(context, "点击了评论！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.user_name:
                Toast.makeText(context, "点击了名字！", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_user;
        TextView user_name;
        TextView user_content;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_user = itemView.findViewById(R.id.iv_user);
            user_content = itemView.findViewById(R.id.user_content);
            user_name = itemView.findViewById(R.id.user_name);
        }
    }
}
