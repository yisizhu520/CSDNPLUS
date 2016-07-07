package wang.mogujun.csdnplus.geeknews.domain.model;

import java.util.List;

/**
 * Created by WangJun on 2016/4/27.
 */
public class NewsCommentInfo {

    private int count;
    private int reply_count;
    private int status;
    private List<Comment> data;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getReply_count() {
        return reply_count;
    }

    public void setReply_count(int reply_count) {
        this.reply_count = reply_count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Comment> getData() {
        return data;
    }

    public void setData(List<Comment> data) {
        this.data = data;
    }

    public class Comment{

        /**
         * user_info :
         * body : <p>感谢博主的分享，学习了</p>
         * is_markdown : 1
         * user_page : http://geek.csdn.net/user/publishlist/u010786678
         * nickname : 任焱
         * reply_count : 0
         * dislike_count : 0
         * dislike_people :
         * from : 0
         * avatar : http://avatar.csdn.net/5/9/8/3_u010786678.jpg
         * timestamp : 1460209705
         * id : 471024
         * username : u010786678
         * content_id : 0
         * like_people :
         * like_count : 0
         * create_time : 1小时前
         * parent_id : 0
         */

        private String user_info;
        private String body;
        private String is_markdown;
        private String user_page;
        private String nickname;
        private String reply_count;
        private String dislike_count;
        private String dislike_people;
        private String from;
        private String avatar;
        private long timestamp;
        private String id;
        private String username;
        private String content_id;
        private String like_people;
        private String like_count;
        private String create_time;
        private String parent_id;

        public String getUser_info() {
            return user_info;
        }

        public void setUser_info(String user_info) {
            this.user_info = user_info;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getIs_markdown() {
            return is_markdown;
        }

        public void setIs_markdown(String is_markdown) {
            this.is_markdown = is_markdown;
        }

        public String getUser_page() {
            return user_page;
        }

        public void setUser_page(String user_page) {
            this.user_page = user_page;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getReply_count() {
            return reply_count;
        }

        public void setReply_count(String reply_count) {
            this.reply_count = reply_count;
        }

        public String getDislike_count() {
            return dislike_count;
        }

        public void setDislike_count(String dislike_count) {
            this.dislike_count = dislike_count;
        }

        public String getDislike_people() {
            return dislike_people;
        }

        public void setDislike_people(String dislike_people) {
            this.dislike_people = dislike_people;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public long getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(long timestamp) {
            this.timestamp = timestamp;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
        }

        public String getLike_people() {
            return like_people;
        }

        public void setLike_people(String like_people) {
            this.like_people = like_people;
        }

        public String getLike_count() {
            return like_count;
        }

        public void setLike_count(String like_count) {
            this.like_count = like_count;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }
    }


}
