package com.example.androidbackground.jsonParse;

import java.util.List;

public class SortGson {

    /**
     * msg : success
     * res : {"category":[{"count":50741,"ename":"girl","rname":"美女","cover_temp":"56a964df69401b2866828acb","name":"美女","cover":"http://img5.adesk.com/5c6d0e86e7bce75509a07c45?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":1,"filter":[],"sn":1,"icover":"582c34f869401b347e0b43fb","atime":1.291266021E9,"type":1,"id":"4e4d610cdf714d2966000000","picasso_cover":"5c6d0e86e7bce75509a07c45"},{"count":93572,"ename":"animation","rname":"动漫","cover_temp":"56a221c969401b3f4aa6700a","name":"动漫","cover":"http://img5.adesk.com/5c6655b2e7bce75509a07916?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":4,"id":"4e4d610cdf714d2966000003","icover":"5880889ae7bce7755f3607d9","sn":2,"atime":1.291266057E9,"type":1,"filter":[],"picasso_cover":"5c6655b2e7bce75509a07916"},{"count":72666,"ename":"landscape","rname":"风景","cover_temp":"56a770e269401b756c748b28","name":"风景","cover":"http://img5.adesk.com/5c63ff02e7bce755372a10f1?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":3,"id":"4e4d610cdf714d2966000002","icover":"581b0f2a69401b34865e6cd2","sn":3,"atime":1.291266049E9,"type":1,"filter":[],"picasso_cover":"5c63ff02e7bce755372a10f1"},{"count":14459,"ename":"game","rname":"游戏","cover_temp":"569f40fa69401b26c648eb87","name":"游戏","cover":"http://img5.adesk.com/5c6a77cae7bce75565528ea3?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":15,"filter":[],"sn":4,"icover":"5866127069401b347e0bd82b","atime":1.300683934E9,"type":1,"id":"4e4d610cdf714d2966000007","picasso_cover":"5c6a77cae7bce75565528ea3"},{"count":9644,"ename":"text","rname":"文字","cover_temp":"56a1f92369401b3f529d3a3f","name":"文字","cover":"http://img5.adesk.com/5c66aa38e7bce7554e13011c?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":5,"filter":[],"sn":5,"icover":"5864e5a769401b34865f1ccc","atime":1.359601742E9,"type":1,"id":"5109e04e48d5b9364ae9ac45","picasso_cover":"5c66aa38e7bce7554e13011c"},{"count":8134,"ename":"vision","rname":"视觉","cover_temp":"56a076f769401b323d865538","name":"视觉","cover":"http://img5.adesk.com/5c6bbe28e7bce75509a07bdb?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":8,"filter":[],"sn":6,"icover":"57f8be3d69401b347e0ab423","type":1,"id":"4fb479f75ba1c65561000027","picasso_cover":"5c6bbe28e7bce75509a07bdb"},{"count":15103,"ename":"emotion","rname":"情感","cover_temp":"56a03f5369401b26beeaea1d","name":"情感","cover":"http://img5.adesk.com/5c652c27e7bce7554e13003e?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":2,"id":"4ef0a35c0569795756000000","icover":"57c53c8769401b644d2782fb","sn":7,"type":1,"filter":[],"picasso_cover":"5c652c27e7bce7554e13003e"},{"count":8214,"ename":"creative","rname":"设计","cover_temp":"569b34af69401b7dd39e9fc3","name":"设计","cover":"http://img5.adesk.com/5c50076ee7bce7551b95cbcb?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":9,"id":"4fb47a195ba1c60ca5000222","icover":"575e7a9869401b01d8ef3ece","sn":8,"type":1,"filter":[],"picasso_cover":"5c50076ee7bce7551b95cbcb"},{"count":19797,"ename":"celebrity","rname":"明星","cover_temp":"56a9a70669401b338161138c","name":"明星","cover":"http://img5.adesk.com/5c6cff34e7bce755372a1470?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":6,"id":"5109e05248d5b9368bb559dc","icover":"5460349269401b3a428a47a7","sn":9,"atime":1.359601746E9,"type":1,"filter":[],"picasso_cover":"5c6cff34e7bce755372a1470"},{"count":23969,"ename":"stuff","rname":"物语","cover_temp":"56a61f1c69401b54eff72f31","name":"物语","cover":"http://img5.adesk.com/5c6aa55fe7bce7558d78f695?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":10,"filter":[],"sn":10,"icover":"557b8cf269401b1704e91bfc","type":1,"id":"4fb47a465ba1c65561000028","picasso_cover":"5c6aa55fe7bce7558d78f695"},{"count":10872,"ename":"art","rname":"艺术","cover_temp":"569f927669401b26beeae9e4","name":"艺术","cover":"http://img5.adesk.com/5c667186e7bce755372a11b4?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":16,"filter":[],"sn":11,"icover":"586381ea69401b34865f1729","type":1,"id":"4ef0a3330569795757000000","picasso_cover":"5c667186e7bce755372a11b4"},{"count":4229,"ename":"man","rname":"男人","cover_temp":"569b541d69401b7dc8ce2c68","name":"男人","cover":"http://img5.adesk.com/5bab19d5e7bce763a9b09aab?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":13,"id":"4e4d610cdf714d2966000006","icover":"548aa5db69401b7439ac1aea","sn":12,"atime":1.29825154E9,"type":1,"filter":[],"picasso_cover":"5bab19d5e7bce763a9b09aab"},{"count":26161,"ename":"cartoon","rname":"卡通","cover_temp":"56a03cda69401b26beeae9f4","name":"卡通","cover":"http://img5.adesk.com/5c6bbc29e7bce75565528fa6?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":11,"id":"4e4d610cdf714d2966000004","icover":"57b7cb8b69401b644d2765a1","sn":13,"atime":1.291266067E9,"type":1,"filter":[],"picasso_cover":"5c6bbc29e7bce75565528fa6"},{"count":23698,"ename":"machine","rname":"机械","cover_temp":"56a99e1f69401b1ce58c12dc","name":"机械","cover":"http://img5.adesk.com/5c6261a5e7bce75509a0770e?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":12,"id":"4e4d610cdf714d2966000005","icover":"587f2a85e7bce7750997720a","sn":13,"atime":1.297756191E9,"type":1,"filter":[],"picasso_cover":"5c6261a5e7bce75509a0770e"},{"count":13628,"ename":"cityscape","rname":"城市","cover_temp":"569b540969401b7dd39ea06d","name":"城市","cover":"http://img5.adesk.com/5c52aeece7bce75599168c87?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":7,"filter":[],"sn":14,"icover":"5792cf7369401b71e3555741","type":1,"id":"4fb47a305ba1c60ca5000223","picasso_cover":"5c52aeece7bce75599168c87"},{"count":19477,"ename":"animal","rname":"动物","cover_temp":"56a4d1da69401b753a684e69","name":"动物","cover":"http://img5.adesk.com/5c6ba807e7bce755372a13fd?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":14,"filter":[],"sn":16,"icover":"58636cda69401b34865f1406","atime":1.291266042E9,"type":1,"id":"4e4d610cdf714d2966000001","picasso_cover":"5c6ba807e7bce755372a13fd"},{"count":7903,"ename":"sport","rname":"运动","cover_temp":"56a08e6a69401b3241740a24","name":"运动","cover":"http://img5.adesk.com/5c614da6e7bce75565528b58?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":17,"filter":[],"sn":17,"icover":"56f7af6669401b4eb5d53188","type":1,"id":"4ef0a34e0569795757000001","picasso_cover":"5c614da6e7bce75565528b58"},{"count":18343,"ename":"movie","rname":"影视","cover_temp":"56a59cbe69401b753a684f7a","name":"影视","cover":"http://img5.adesk.com/5c6d098de7bce7558d78f763?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480","rank":18,"filter":[],"sn":18,"icover":"58aecf3369401b34865f35d1","type":1,"id":"4e58c2570569791a19000000","picasso_cover":"5c6d098de7bce7558d78f763"}]}
     * code : 0
     */

    private String msg;
    private ResBean res;
    private int code;

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static class ResBean {
        private List<CategoryBean> category;

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public static class CategoryBean {
            /**
             * count : 50741
             * ename : girl
             * rname : 美女
             * cover_temp : 56a964df69401b2866828acb
             * name : 美女
             * cover : http://img5.adesk.com/5c6d0e86e7bce75509a07c45?imageMogr2/thumbnail/!640x480r/gravity/Center/crop/640x480
             * rank : 1
             * filter : []
             * sn : 1
             * icover : 582c34f869401b347e0b43fb
             * atime : 1.291266021E9
             * type : 1
             * id : 4e4d610cdf714d2966000000
             * picasso_cover : 5c6d0e86e7bce75509a07c45
             */

            private int count;
            private String ename;
            private String rname;
            private String cover_temp;
            private String name;
            private String cover;
            private int rank;
            private int sn;
            private String icover;
            private double atime;
            private int type;
            private String id;
            private String picasso_cover;
            private List<?> filter;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public String getEname() {
                return ename;
            }

            public void setEname(String ename) {
                this.ename = ename;
            }

            public String getRname() {
                return rname;
            }

            public void setRname(String rname) {
                this.rname = rname;
            }

            public String getCover_temp() {
                return cover_temp;
            }

            public void setCover_temp(String cover_temp) {
                this.cover_temp = cover_temp;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public int getSn() {
                return sn;
            }

            public void setSn(int sn) {
                this.sn = sn;
            }

            public String getIcover() {
                return icover;
            }

            public void setIcover(String icover) {
                this.icover = icover;
            }

            public double getAtime() {
                return atime;
            }

            public void setAtime(double atime) {
                this.atime = atime;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPicasso_cover() {
                return picasso_cover;
            }

            public void setPicasso_cover(String picasso_cover) {
                this.picasso_cover = picasso_cover;
            }

            public List<?> getFilter() {
                return filter;
            }

            public void setFilter(List<?> filter) {
                this.filter = filter;
            }
        }
    }
}
