package com.example.androidbackground.Class;

public class ComputerPicture {
    private String sortName;                             //类别名字
    private String sortCover;                           //类别封面地址
    private String sortId;                              //类别ID

    public ComputerPicture(String sortName, String sortCover, String sortId) { ;
        this.sortCover = sortCover;
        this.sortId = sortId;
        this.sortName = sortName;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortCover() {
        return sortCover;
    }

    public void setSortCover(String sortCover) {
        this.sortCover = sortCover;
    }

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }
}
