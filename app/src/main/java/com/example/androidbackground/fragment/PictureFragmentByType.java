package com.example.androidbackground.fragment;

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
import com.example.androidbackground.adapter.PictureAdapterBySort;
import java.util.ArrayList;
import java.util.List;

public class PictureFragmentByType extends Fragment {
    private View pictureView;
    private List<String> picturePrevieewUrls = new ArrayList<>();
    private List<Picture> pictureList = new ArrayList<>();
    private List<String> pictureIDs = new ArrayList<>();
    private List<Integer> rankList = new ArrayList<>();                             //点赞数
    private List<Integer> favsList = new ArrayList<>();                             //收藏数
    private List<Double> atimeList = new ArrayList<>();                             //创建时间（单位：秒）
    private List<String> pictureThumbList = new ArrayList<>();                      //小缩略图壁纸
    private List<String> pictureImgList = new ArrayList<>();                        //大缩略图壁纸
    private List<List<String>> tagList = new ArrayList<>();                         //壁纸标签
    private List<String> wpList = new ArrayList<>();                                //手机壁纸下载地址
    private String distinguish = null;

    public void setData(List<String> picturePreviewUrls, List<String> pictureIDs, List<Integer> rankList,
                        List<Integer> favsList, List<Double> atimeList, List<String> pictureThumbList,
                        List<String> pictureImgList, List<List<String>> tagList, List<String> wpList,
                        String distinguish) {
        this.tagList = tagList;
        this.wpList = wpList;
        this.rankList = rankList;
        this.favsList = favsList;
        this.atimeList = atimeList;
        this.pictureThumbList = pictureThumbList;
        this.pictureImgList = pictureImgList;
        this.pictureIDs = pictureIDs;
        this.picturePrevieewUrls = picturePreviewUrls;
        this.distinguish = distinguish;
    }

    @Override
    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        pictureView = inflater.inflate(R.layout.picture_fragment_layout, container, false);
        addPictures();
        RecyclerView recyclerView = (RecyclerView) pictureView.findViewById(R.id.picture_recycle);
        StaggeredGridLayoutManager staggeredGridLayoutManager;
        if (distinguish.equals("computer")) {
            staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        } else {
            staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        }
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        PictureAdapterBySort pictureAdapterBySort = new PictureAdapterBySort();
        pictureAdapterBySort.setData(pictureList, distinguish);
        recyclerView.setAdapter(pictureAdapterBySort);
        return pictureView;
    }

    private void addPictures() {
        for (int i = 0; i < picturePrevieewUrls.size(); i++) {
            Picture picture = new Picture(picturePrevieewUrls.get(i), "new_hot", null,
                    null, null, pictureIDs.get(i), rankList.get(i), favsList.get(i),
                    atimeList.get(i), pictureThumbList.get(i), pictureImgList.get(i), -1,
                    tagList.get(i), wpList.get(i));
            pictureList.add(picture);
        }
    }
}
