package com.example.androidbackground.jsonParse;

import java.util.List;

public class CommentByGson {

    /**
     * msg : success
     * res : {"comment":[{"reply_user":{},"reply_meta":{},"content":"鱝。","isup":false,"user":{"gcid":"","name":"笃図","title":[],"gender":0,"follower":0,"avatar":"http://thirdqq.qlogo.cn/qqapp/100428621/143E7E598F252A77A92595CD654C83C4/100","viptime":1.525691376E9,"following":2,"isvip":false,"id":"5af033f004220828469dd1e2"},"atime":1.550117532E9,"id":"5c64ea9cc8cfb728d854a585","size":1},{"reply_user":{},"reply_meta":{},"content":"喜欢","isup":false,"user":{"gcid":"","name":"就算是妹妹有爱就没问题了对吧","title":[{"name":"行星饭","icon":"http://s.adesk.com/achieve/title/xingxingfan.png"},{"name":"四叶草","icon":"http://s.adesk.com/achieve/title/siyecao.png?v=2"},{"name":"骑士团","icon":"http://s.adesk.com/achieve/title/qishituan.png?v=2"},{"name":"砖家","icon":"http://s.adesk.com/achieve/title/zhuanjia.png?v=2"},{"name":"油菜花","icon":"http://s.adesk.com/achieve/title/youcaihua.png?v=2"},{"name":"沙发客","icon":"http://s.adesk.com/achieve/title/shafake.png?v=2"}],"gender":1,"follower":891,"avatar":"http://img0.adesk.com/download/5639fceb174cf165a95439a6","viptime":1.522646993E9,"following":4,"isvip":false,"id":"5270e9cb2d74c8604abd5572"},"atime":1.550068985E9,"id":"5c642cf9c8cfb728cb2ab2d1","size":2},{"reply_user":{"gcid":"","name":"123","gender":0,"follower":242,"avatar":"http://img0.adesk.com/download/5b0538d1e7bce75bf7f25a62","viptime":9.782784E8,"following":4,"isvip":false,"id":"5773807d94e5cc3e6a4991d6"},"reply_meta":{"parent_id":"5c63f2b5c8cfb728cb2a1688","comment_id":"5c63f2b5c8cfb728cb2a1688","uid":"5773807d94e5cc3e6a4991d6"},"content":"我来顶","isup":false,"user":{"gcid":"","name":"啊♂乖乖站好","title":[],"gender":1,"follower":5,"avatar":"http://thirdqq.qlogo.cn/qqapp/100428621/ED3F8067E45BA608F68B18ED68F027EA/100","viptime":1.539907613E9,"following":5,"isvip":false,"id":"5bc9201de7bce76303182540"},"atime":1.55005916E9,"id":"5c6406989a1aa323bf6e22c9","size":2},{"reply_user":{},"reply_meta":{},"content":"顶不住顶不住","isup":false,"user":{"gcid":"","name":"123","title":[{"name":"行星饭","icon":"http://s.adesk.com/achieve/title/xingxingfan.png"},{"name":"四叶草","icon":"http://s.adesk.com/achieve/title/siyecao.png?v=2"},{"name":"骑士团","icon":"http://s.adesk.com/achieve/title/qishituan.png?v=2"},{"name":"油菜花","icon":"http://s.adesk.com/achieve/title/youcaihua.png?v=2"},{"name":"砖家","icon":"http://s.adesk.com/achieve/title/zhuanjia.png?v=2"},{"name":"沙发客","icon":"http://s.adesk.com/achieve/title/shafake.png?v=2"}],"gender":0,"follower":242,"avatar":"http://img0.adesk.com/download/5b0538d1e7bce75bf7f25a62","viptime":9.782784E8,"following":4,"isvip":false,"id":"5773807d94e5cc3e6a4991d6"},"atime":1.550054069E9,"id":"5c63f2b5c8cfb728cb2a1688","size":2},{"reply_user":{},"reply_meta":{},"content":"ԅ(¯ㅂ¯ԅ)口水","isup":false,"user":{"gcid":"","name":"清隆凌小路","title":[],"gender":0,"follower":19,"avatar":"http://thirdqq.qlogo.cn/qqapp/100428621/C663418F3C07F3A70E7F2F7AD65EEED2/100","viptime":1.520348904E9,"following":16,"isvip":false,"id":"5a9eaee825495925db824e13"},"atime":1.550051342E9,"id":"5c63e80e0422083d767549c7","size":3}],"hot":[],"meta":{"more":false},"vertical":{"isfavor":false}}
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
        /**
         * comment : [{"reply_user":{},"reply_meta":{},"content":"鱝。","isup":false,"user":{"gcid":"","name":"笃図","title":[],"gender":0,"follower":0,"avatar":"http://thirdqq.qlogo.cn/qqapp/100428621/143E7E598F252A77A92595CD654C83C4/100","viptime":1.525691376E9,"following":2,"isvip":false,"id":"5af033f004220828469dd1e2"},"atime":1.550117532E9,"id":"5c64ea9cc8cfb728d854a585","size":1},{"reply_user":{},"reply_meta":{},"content":"喜欢","isup":false,"user":{"gcid":"","name":"就算是妹妹有爱就没问题了对吧","title":[{"name":"行星饭","icon":"http://s.adesk.com/achieve/title/xingxingfan.png"},{"name":"四叶草","icon":"http://s.adesk.com/achieve/title/siyecao.png?v=2"},{"name":"骑士团","icon":"http://s.adesk.com/achieve/title/qishituan.png?v=2"},{"name":"砖家","icon":"http://s.adesk.com/achieve/title/zhuanjia.png?v=2"},{"name":"油菜花","icon":"http://s.adesk.com/achieve/title/youcaihua.png?v=2"},{"name":"沙发客","icon":"http://s.adesk.com/achieve/title/shafake.png?v=2"}],"gender":1,"follower":891,"avatar":"http://img0.adesk.com/download/5639fceb174cf165a95439a6","viptime":1.522646993E9,"following":4,"isvip":false,"id":"5270e9cb2d74c8604abd5572"},"atime":1.550068985E9,"id":"5c642cf9c8cfb728cb2ab2d1","size":2},{"reply_user":{"gcid":"","name":"123","gender":0,"follower":242,"avatar":"http://img0.adesk.com/download/5b0538d1e7bce75bf7f25a62","viptime":9.782784E8,"following":4,"isvip":false,"id":"5773807d94e5cc3e6a4991d6"},"reply_meta":{"parent_id":"5c63f2b5c8cfb728cb2a1688","comment_id":"5c63f2b5c8cfb728cb2a1688","uid":"5773807d94e5cc3e6a4991d6"},"content":"我来顶","isup":false,"user":{"gcid":"","name":"啊♂乖乖站好","title":[],"gender":1,"follower":5,"avatar":"http://thirdqq.qlogo.cn/qqapp/100428621/ED3F8067E45BA608F68B18ED68F027EA/100","viptime":1.539907613E9,"following":5,"isvip":false,"id":"5bc9201de7bce76303182540"},"atime":1.55005916E9,"id":"5c6406989a1aa323bf6e22c9","size":2},{"reply_user":{},"reply_meta":{},"content":"顶不住顶不住","isup":false,"user":{"gcid":"","name":"123","title":[{"name":"行星饭","icon":"http://s.adesk.com/achieve/title/xingxingfan.png"},{"name":"四叶草","icon":"http://s.adesk.com/achieve/title/siyecao.png?v=2"},{"name":"骑士团","icon":"http://s.adesk.com/achieve/title/qishituan.png?v=2"},{"name":"油菜花","icon":"http://s.adesk.com/achieve/title/youcaihua.png?v=2"},{"name":"砖家","icon":"http://s.adesk.com/achieve/title/zhuanjia.png?v=2"},{"name":"沙发客","icon":"http://s.adesk.com/achieve/title/shafake.png?v=2"}],"gender":0,"follower":242,"avatar":"http://img0.adesk.com/download/5b0538d1e7bce75bf7f25a62","viptime":9.782784E8,"following":4,"isvip":false,"id":"5773807d94e5cc3e6a4991d6"},"atime":1.550054069E9,"id":"5c63f2b5c8cfb728cb2a1688","size":2},{"reply_user":{},"reply_meta":{},"content":"ԅ(¯ㅂ¯ԅ)口水","isup":false,"user":{"gcid":"","name":"清隆凌小路","title":[],"gender":0,"follower":19,"avatar":"http://thirdqq.qlogo.cn/qqapp/100428621/C663418F3C07F3A70E7F2F7AD65EEED2/100","viptime":1.520348904E9,"following":16,"isvip":false,"id":"5a9eaee825495925db824e13"},"atime":1.550051342E9,"id":"5c63e80e0422083d767549c7","size":3}]
         * hot : []
         * meta : {"more":false}
         * vertical : {"isfavor":false}
         */

        private MetaBean meta;
        private VerticalBean vertical;
        private List<CommentBean> comment;
        private List<?> hot;

        public MetaBean getMeta() {
            return meta;
        }

        public void setMeta(MetaBean meta) {
            this.meta = meta;
        }

        public VerticalBean getVertical() {
            return vertical;
        }

        public void setVertical(VerticalBean vertical) {
            this.vertical = vertical;
        }

        public List<CommentBean> getComment() {
            return comment;
        }

        public void setComment(List<CommentBean> comment) {
            this.comment = comment;
        }

        public List<?> getHot() {
            return hot;
        }

        public void setHot(List<?> hot) {
            this.hot = hot;
        }

        public static class MetaBean {
            /**
             * more : false
             */

            private boolean more;

            public boolean isMore() {
                return more;
            }

            public void setMore(boolean more) {
                this.more = more;
            }
        }

        public static class VerticalBean {
            /**
             * isfavor : false
             */

            private boolean isfavor;

            public boolean isIsfavor() {
                return isfavor;
            }

            public void setIsfavor(boolean isfavor) {
                this.isfavor = isfavor;
            }
        }

        public static class CommentBean {
            /**
             * reply_user : {}
             * reply_meta : {}
             * content : 鱝。
             * isup : false
             * user : {"gcid":"","name":"笃図","title":[],"gender":0,"follower":0,"avatar":"http://thirdqq.qlogo.cn/qqapp/100428621/143E7E598F252A77A92595CD654C83C4/100","viptime":1.525691376E9,"following":2,"isvip":false,"id":"5af033f004220828469dd1e2"}
             * atime : 1.550117532E9
             * id : 5c64ea9cc8cfb728d854a585
             * size : 1
             */

            private ReplyUserBean reply_user;
            private ReplyMetaBean reply_meta;
            private String content;
            private boolean isup;
            private UserBean user;
            private double atime;
            private String id;
            private int size;

            public ReplyUserBean getReply_user() {
                return reply_user;
            }

            public void setReply_user(ReplyUserBean reply_user) {
                this.reply_user = reply_user;
            }

            public ReplyMetaBean getReply_meta() {
                return reply_meta;
            }

            public void setReply_meta(ReplyMetaBean reply_meta) {
                this.reply_meta = reply_meta;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public boolean isIsup() {
                return isup;
            }

            public void setIsup(boolean isup) {
                this.isup = isup;
            }

            public UserBean getUser() {
                return user;
            }

            public void setUser(UserBean user) {
                this.user = user;
            }

            public double getAtime() {
                return atime;
            }

            public void setAtime(double atime) {
                this.atime = atime;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public static class ReplyUserBean {
            }

            public static class ReplyMetaBean {
            }

            public static class UserBean {
                /**
                 * gcid :
                 * name : 笃図
                 * title : []
                 * gender : 0
                 * follower : 0
                 * avatar : http://thirdqq.qlogo.cn/qqapp/100428621/143E7E598F252A77A92595CD654C83C4/100
                 * viptime : 1.525691376E9
                 * following : 2
                 * isvip : false
                 * id : 5af033f004220828469dd1e2
                 */

                private String gcid;
                private String name;
                private int gender;
                private int follower;
                private String avatar;
                private double viptime;
                private int following;
                private boolean isvip;
                private String id;
                private List<?> title;

                public String getGcid() {
                    return gcid;
                }

                public void setGcid(String gcid) {
                    this.gcid = gcid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getGender() {
                    return gender;
                }

                public void setGender(int gender) {
                    this.gender = gender;
                }

                public int getFollower() {
                    return follower;
                }

                public void setFollower(int follower) {
                    this.follower = follower;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public double getViptime() {
                    return viptime;
                }

                public void setViptime(double viptime) {
                    this.viptime = viptime;
                }

                public int getFollowing() {
                    return following;
                }

                public void setFollowing(int following) {
                    this.following = following;
                }

                public boolean isIsvip() {
                    return isvip;
                }

                public void setIsvip(boolean isvip) {
                    this.isvip = isvip;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public List<?> getTitle() {
                    return title;
                }

                public void setTitle(List<?> title) {
                    this.title = title;
                }
            }
        }
    }
}