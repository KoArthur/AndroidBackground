package com.example.androidbackground.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.androidbackground.Class.Picture;
import com.example.androidbackground.R;
import com.example.androidbackground.adapter.PictureAdapter;
import java.util.ArrayList;
import java.util.List;

public class PictureFragment extends Fragment {

    private String genre;

    private View pictureView;
    private Context context;

    private List<List<String>> tagList = new ArrayList<>();                         //壁纸标签
    private List<String> wpList = new ArrayList<>();                                //手机壁纸下载地址
    private List<Integer> viewsList = new ArrayList<>();                            //查看数
    private List<Integer> rankList = new ArrayList<>();                             //点赞数
    private List<Integer> favsList = new ArrayList<>();                             //收藏数
    private List<Double> atimeList = new ArrayList<>();                             //创建时间（单位：秒）
    private List<String> pictureThumbList = new ArrayList<>();                      //小缩略图壁纸
    private List<String> pictureImgList = new ArrayList<>();                        //大缩略图壁纸
    private List<String> names = new ArrayList<>();
    private List<String> pictureURLs = new ArrayList<>();
    private List<Picture> pictures = new ArrayList<>();
    private List<String> typeNewUrls = new ArrayList<>();
    private List<String> typeHotUrls = new ArrayList<>();
    private List<String> pictureIDs = new ArrayList<>();


    //将由网络获取的图片加载进去
    public void setData(List<String> urls, String genre, List<String> typeNewUrls, List<String> typeHotUrls,
                        List<String> names, List<String> pictureIDs, List<Integer> rankList, List<Integer> favsList,
                        List<Double> atimeList, List<String> pictureThumbList, List<String> pictureImgList,
                        List<List<String>> tagList, List<Integer> viewsList, List<String> wpList) {
        this.wpList = wpList;
        this.tagList = tagList;
        this.viewsList = viewsList;
        this.rankList = rankList;
        this.favsList = favsList;
        this.atimeList = atimeList;
        this.pictureThumbList = pictureThumbList;
        this.pictureImgList = pictureImgList;
        this.pictureIDs = pictureIDs;
        this.names = names;
        this.typeHotUrls = typeHotUrls;
        this.typeNewUrls = typeNewUrls;
        this.genre = genre;
        this.pictureURLs = urls;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = container.getContext();
        pictureView = inflater.inflate(R.layout.picture_fragment_layout, container, false);
        addPictures();
        RecyclerView recyclerView = pictureView.findViewById(R.id.picture_recycle);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        PictureAdapter pictureAdapter = new PictureAdapter();
        pictureAdapter.setData(pictures);
        recyclerView.setAdapter(pictureAdapter);

        return pictureView;
    }

    private void addPictures() {
        if (typeHotUrls != null && typeNewUrls != null && names != null && rankList == null && favsList == null
                && atimeList == null && pictureThumbList == null && pictureImgList == null && tagList == null &&
                viewsList == null && wpList == null) {
            for (int i = 0; i < pictureURLs.size(); i++) {
                Picture picture = new Picture(pictureURLs.get(i), genre, typeNewUrls.get(i), typeHotUrls.get(i),
                        names.get(i), pictureIDs.get(i), -1, -1, null, null,
                        null, -1, null, null);
                pictures.add(picture);
            }
        } else {
            for (int i = 0; i < pictureURLs.size(); i++) {
                Picture picture = new Picture(pictureURLs.get(i), genre, null, null,
                        null, pictureIDs.get(i), rankList.get(i), favsList.get(i), atimeList.get(i),
                        pictureThumbList.get(i), pictureImgList.get(i), viewsList.get(i), tagList.get(i), wpList.get(i));
                pictures.add(picture);
            }
        }
    }
}
