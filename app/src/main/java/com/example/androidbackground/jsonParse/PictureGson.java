package com.example.androidbackground.jsonParse;

import java.util.List;

public class PictureGson {

    /**
     * code : 0
     * msg : success
     * res : {"vertical":{"atime":1.550226003E9,"cid":["4e4d610cdf714d2966000003"],"cr":false,"desc":"","favs":18,"id":"5c107fb4e7bce75ea7b2fe2f","img":"http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f?imageMogr2/thumbnail/!720x1280r/gravity/Center/crop/720x1280","ncos":2,"preview":"http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f","rank":104,"rule":"?imageMogr2/thumbnail/!$<Width>x$<Height>r/gravity/Center/crop/$<Width>x$<Height>","store":"qiniu","tag":[],"thumb":"http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f?imageMogr2/thumbnail/!350x540r/gravity/Center/crop/350x540","url":[],"views":0,"wp":"http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f","xr":false}}
     */

    private int code;
    private String msg;
    private ResBean res;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResBean getRes() {
        return res;
    }

    public void setRes(ResBean res) {
        this.res = res;
    }

    public static class ResBean {
        /**
         * vertical : {"atime":1.550226003E9,"cid":["4e4d610cdf714d2966000003"],"cr":false,"desc":"","favs":18,"id":"5c107fb4e7bce75ea7b2fe2f","img":"http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f?imageMogr2/thumbnail/!720x1280r/gravity/Center/crop/720x1280","ncos":2,"preview":"http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f","rank":104,"rule":"?imageMogr2/thumbnail/!$<Width>x$<Height>r/gravity/Center/crop/$<Width>x$<Height>","store":"qiniu","tag":[],"thumb":"http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f?imageMogr2/thumbnail/!350x540r/gravity/Center/crop/350x540","url":[],"views":0,"wp":"http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f","xr":false}
         */

        private VerticalBean vertical;

        public VerticalBean getVertical() {
            return vertical;
        }

        public void setVertical(VerticalBean vertical) {
            this.vertical = vertical;
        }

        public static class VerticalBean {
            /**
             * atime : 1.550226003E9
             * cid : ["4e4d610cdf714d2966000003"]
             * cr : false
             * desc :
             * favs : 18
             * id : 5c107fb4e7bce75ea7b2fe2f
             * img : http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f?imageMogr2/thumbnail/!720x1280r/gravity/Center/crop/720x1280
             * ncos : 2
             * preview : http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f
             * rank : 104
             * rule : ?imageMogr2/thumbnail/!$<Width>x$<Height>r/gravity/Center/crop/$<Width>x$<Height>
             * store : qiniu
             * tag : []
             * thumb : http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f?imageMogr2/thumbnail/!350x540r/gravity/Center/crop/350x540
             * url : []
             * views : 0
             * wp : http://img5.adesk.com/5c107fb4e7bce75ea7b2fe2f
             * xr : false
             */

            private double atime;
            private boolean cr;
            private String desc;
            private int favs;
            private String id;
            private String img;
            private int ncos;
            private String preview;
            private int rank;
            private String rule;
            private String store;
            private String thumb;
            private int views;
            private String wp;
            private boolean xr;
            private List<String> cid;
            private List<?> tag;
            private List<?> url;

            public double getAtime() {
                return atime;
            }

            public void setAtime(double atime) {
                this.atime = atime;
            }

            public boolean isCr() {
                return cr;
            }

            public void setCr(boolean cr) {
                this.cr = cr;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getFavs() {
                return favs;
            }

            public void setFavs(int favs) {
                this.favs = favs;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public int getNcos() {
                return ncos;
            }

            public void setNcos(int ncos) {
                this.ncos = ncos;
            }

            public String getPreview() {
                return preview;
            }

            public void setPreview(String preview) {
                this.preview = preview;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public String getRule() {
                return rule;
            }

            public void setRule(String rule) {
                this.rule = rule;
            }

            public String getStore() {
                return store;
            }

            public void setStore(String store) {
                this.store = store;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public String getWp() {
                return wp;
            }

            public void setWp(String wp) {
                this.wp = wp;
            }

            public boolean isXr() {
                return xr;
            }

            public void setXr(boolean xr) {
                this.xr = xr;
            }

            public List<String> getCid() {
                return cid;
            }

            public void setCid(List<String> cid) {
                this.cid = cid;
            }

            public List<?> getTag() {
                return tag;
            }

            public void setTag(List<?> tag) {
                this.tag = tag;
            }

            public List<?> getUrl() {
                return url;
            }

            public void setUrl(List<?> url) {
                this.url = url;
            }
        }
    }
}
