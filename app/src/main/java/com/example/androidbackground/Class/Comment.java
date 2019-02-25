package com.example.androidbackground.Class;

public class Comment {
    private String userName;
    private String user_ivUrl;
    private String content;
    private String id;

    public Comment(String user_ivUrl, String userName, String content, String id) {
        this.id = id;
        this.content = content;
        this.user_ivUrl = user_ivUrl;
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_ivUrl() {
        return user_ivUrl;
    }

    public void setUser_ivUrl(String user_ivUrl) {
        this.user_ivUrl = user_ivUrl;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
