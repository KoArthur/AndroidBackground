package com.example.androidbackground.Class;

public class AlbumPicture {
    Double atime;                       //每张图片发布的时间
    int rank;                           //每张图片的点赞数量
    int favs;                           //每张图片得收藏数量
    String thumb;                       //每张图片（三种图片中为中等大小）
    String img;                         //每张图片（三种图片中最大）
    String preview;                     //每张图片（三种图片中最小）
    String id;                          //每张图片的ID
    String wp;                          //每张图片的下载地址

    public void setData(Double atime, int rank, int favs, String thumb, String img, String preview, String id, String wp) {
        this.atime = atime;
        this.rank = rank;
        this.favs = favs;
        this.thumb = thumb;
        this.img = img;
        this.preview = preview;
        this.id = id;
        this.wp = wp;
    }

    public String getWp() {
        return wp;
    }

    public void setWp(String wp) {
        this.wp = wp;
    }

    public Double getAtime() {
        return atime;
    }

    public void setAtime(Double atime) {
        this.atime = atime;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getFavs() {
        return favs;
    }

    public void setFavs(int favs) {
        this.favs = favs;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
