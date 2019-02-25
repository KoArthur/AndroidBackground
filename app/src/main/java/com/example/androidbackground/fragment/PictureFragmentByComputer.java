package com.example.androidbackground.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.Indicators.PagerIndicator;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.example.androidbackground.Class.Album;
import com.example.androidbackground.Class.ComputerPicture;
import com.example.androidbackground.R;
import com.example.androidbackground.adapter.AlbumSortAdapter;
import com.example.androidbackground.adapter.ComputerPictureAdapter;
import java.util.ArrayList;
import java.util.List;

public class PictureFragmentByComputer extends Fragment {

    List<ComputerPicture> computerPictureList = new ArrayList<>();
    List<Album> albumList = new ArrayList<>();

    List<String> albumNameList = new ArrayList<>();                                                 //专辑名字
    List<String> albumCoverUrlList = new ArrayList<>();                                             //专辑封面地址
    List<String> albumIdList = new ArrayList<>();                                                   //专辑ID
    List<Integer> albumFavsList = new ArrayList<>();                                                //专辑收藏数
    List<String> sortNames = new ArrayList<>();                                                     //类别名字
    List<String> sortCoverUrls = new ArrayList<>();                                                 //类别封面地址
    List<String> sortIds = new ArrayList<>();                                                       //类别ID
    List<String> albumLcoverUrlList = new ArrayList<>();                                            //专辑大封面地址
    List<String> albumBannerThumUrlList = new ArrayList<>();                                        //推荐专辑封面地址
    List<String> albumBannerIdList = new ArrayList<>();                                             //推荐专辑ID
    List<String> albumDescList = new ArrayList<>();                                                 //专辑描述
    List<String> albumBannerDescList = new ArrayList<>();                                           //推荐专辑描述
    List<String> albumBannerNameList = new ArrayList<>();                                           //推荐专辑名字
    View view;

    public void setData(List<String> albumNameList, List<String> albumCoverUrlList, List<String> albumIdList,
                        List<Integer> albumFavsList, List<String> sortNames, List<String> sortCoverUrls,
                        List<String> sortIds, List<String> albumLcoverUrlList, List<String> albumBannerThumUrlList,
                        List<String> albumBannerIdList, List<String> albumDescList,List<String> albumBannerDescList,
                        List<String> albumBannerNameList ) {
        this.albumNameList = albumNameList;
        this.albumCoverUrlList = albumCoverUrlList;
        this.albumIdList = albumIdList;
        this.albumFavsList = albumFavsList;
        this.sortNames = sortNames;
        this.sortCoverUrls = sortCoverUrls;
        this.sortIds = sortIds;
        this.albumLcoverUrlList = albumLcoverUrlList;
        this.albumBannerThumUrlList = albumBannerThumUrlList;
        this.albumBannerIdList = albumBannerIdList;
        this.albumDescList = albumDescList;
        this.albumBannerNameList = albumBannerNameList;
        this.albumBannerDescList = albumBannerDescList;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (sortNames == null && sortCoverUrls == null && sortIds == null) {
            addAlbum();
            view = inflater.inflate(R.layout.album_sort, container, false);
            initImageSlider();
            RecyclerView recyclerView = view.findViewById(R.id.album_recycler);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
            AlbumSortAdapter albumSortAdapter = new AlbumSortAdapter();
            albumSortAdapter.setData(albumList);
            recyclerView.setAdapter(albumSortAdapter);
        } else {
            addComputerPicture();
            view = inflater.inflate(R.layout.picture_fragment_layout, container, false);
            RecyclerView recyclerView = view.findViewById(R.id.picture_recycle);
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(staggeredGridLayoutManager);
            ComputerPictureAdapter computerPictureAdapter = new ComputerPictureAdapter();
            computerPictureAdapter.setData(computerPictureList);
            recyclerView.setAdapter(computerPictureAdapter);
        }
        return view;
    }

    //广告轮播条
    private void initImageSlider() {
        SliderLayout sliderLayout = view.findViewById(R.id.slider);
        PagerIndicator indicator = view.findViewById(R.id.custom_indicator);
        for (int i = 0; i < albumBannerThumUrlList.size(); i++) {
            TextSliderView textSliderView = new TextSliderView(getActivity());
            textSliderView.image(albumBannerThumUrlList.get(i)).description(albumBannerNameList.get(i) + "：" + albumBannerDescList.get(i));
            final int position = i;
            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Toast.makeText(getActivity(), albumBannerNameList.get(position) + "：" + albumBannerDescList.get(position), Toast.LENGTH_SHORT).show();
                }
            });
            sliderLayout.addSlider(textSliderView);
        }
        sliderLayout.setCustomAnimation(new DescriptionAnimation());
        sliderLayout.setPresetTransformer(SliderLayout.Transformer.DepthPage);
        sliderLayout.setDuration(5000);
        sliderLayout.setCustomIndicator(indicator);
    }

    private void addAlbum() {
        Log.d("Album", "albumNameList = " + albumNameList.size() + "albumCoverUrlList = " +
                albumCoverUrlList.size() + "albumIdList = " + albumIdList.size() + "albumLcoverUrlList = " +
                albumLcoverUrlList.size() + "albumFavsList = " + albumFavsList.size() + "albumDescList = " + albumDescList.size());
        for (int i = 0; i < albumNameList.size(); i++) {
            Album album = new Album();
            album.setData(albumNameList.get(i), albumCoverUrlList.get(i), albumIdList.get(i), albumLcoverUrlList.get(i),
                    albumFavsList.get(i), albumDescList.get(i));
            albumList.add(album);
        }
    }

    private void addComputerPicture() {
        for (int i = 0; i < sortIds.size(); i++) {
            ComputerPicture computerPicture = new ComputerPicture( sortNames.get(i), sortCoverUrls.get(i), sortIds.get(i));
            computerPictureList.add(computerPicture);
        }
    }
}
