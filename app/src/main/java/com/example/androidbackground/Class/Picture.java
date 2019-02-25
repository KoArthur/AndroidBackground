package com.example.androidbackground.Class;

import java.util.List;

public class Picture {

    private String pictureID;
    private String imageURL;
    private String genre;
    private String typeNewUrl;
    private String typeHotUrl;
    private String name;
    private int rank;                               //点赞数
    private int favs;                               //收藏数
    private Double atime;                           //创建时间（单位：秒）
    private String pictureThumb;                    //小缩略图壁纸
    private String pictureImg;                      //大缩略图壁纸
    private String wp;                              //手机壁纸下载地址
    private List<String> tag;                       //壁纸标签
    private int views;                              //查看数

    public Picture(String url, String genre, String typeNewUrl, String typeHotUrl, String name, String pictureID, int rank, int favs, Double atime, String pictureThumb, String pictureImg, int views, List<String> tag, String wp) {
        this.wp = wp;
        this.tag = tag;
        this.views = views;
        this.rank = rank;
        this.favs = favs;
        this.atime = atime;
        this.pictureImg = pictureImg;
        this.pictureThumb = pictureThumb;
        this.pictureID = pictureID;
        this.name = name;
        this.typeNewUrl = typeNewUrl;
        this.typeHotUrl = typeHotUrl;
        this.imageURL = url;
        this.genre = genre;
//        Log.d("URLs", url);
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void setTag(List<String> tag) {
        this.tag = tag;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }

    public int getViews() {
        return views;
    }

    public List<String> getTag() {
        return tag;
    }

    public String getWp() {
        return wp;
    }

    public void setPictureImg(String pictureImg) {
        this.pictureImg = pictureImg;
    }

    public void setPictureThumb(String pictureThumb) {
        this.pictureThumb = pictureThumb;
    }

    public void setAtime(Double atime) {
        this.atime = atime;
    }

    public void setFavs(int favs) {
        this.favs = favs;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setPictureID(String pictureID) {
        this.pictureID = pictureID;
    }

    public String getPictureImg() {
        return pictureImg;
    }

    public String getPictureThumb() {
        return pictureThumb;
    }

    public Double getAtime() {
        return atime;
    }

    public int getFavs() {
        return favs;
    }

    public int getRank() {
        return rank;
    }

    public String getPictureID() {
        return pictureID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String url) {
        imageURL = url;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setTypeHotUrl(String typeHotUrl) {
        this.typeHotUrl = typeHotUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setTypeNewUrl(String typeNewUrl) {
        this.typeNewUrl = typeNewUrl;
    }

    public String getTypeHotUrl() {
        return typeHotUrl;
    }

    public String getTypeNewUrl() {
        return typeNewUrl;
    }
}
