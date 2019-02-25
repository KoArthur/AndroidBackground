package com.example.androidbackground.Class;

public class Album {

    private String name;
    private String coverUrl;
    private String id;
    private int favs;
    private String lcoverUrl;
    private String desc;

    public void setData(String name, String coverUrl, String id, String lcoverUrl, int favs, String desc) {
        this.name = name;
        this.coverUrl = coverUrl;
        this.id = id;
        this.favs = favs;
        this.lcoverUrl = lcoverUrl;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFavs() {
        return favs;
    }

    public void setFavs(int favs) {
        this.favs = favs;
    }

    public String getLcoverUrl() {
        return lcoverUrl;
    }

    public void setLcoverUrl(String lcoverUrl) {
        this.lcoverUrl = lcoverUrl;
    }
}
