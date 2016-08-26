package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/5/3.
 */
public class HeadlineCommentInfo {


    public static final int STATUS_SUCCESS = 300;
    public static final int STATUS_FAIL = 301;


    /**
     * status : 300
     * data : {"comment_count":"24","body":"bucuo","is_markdown":"1","reply_count":"12","dislike_count":"0","dislike_people":"","from":"2","avatar":"http://avatar.csdn.net/D/F/5/3_yisizhu520.jpg","id":"475478","timestamp":"1462092039","username":"yisizhu520","like_people":"","content_id":"0","like_count":"0","create_time":"1秒前","parent_id":"0"}
     */

    private int status;
    /**
     * comment_count : 24
     * body : bucuo
     * is_markdown : 1
     * reply_count : 12
     * dislike_count : 0
     * dislike_people :
     * from : 2
     * avatar : http://avatar.csdn.net/D/F/5/3_yisizhu520.jpg
     * id : 475478
     * timestamp : 1462092039
     * username : yisizhu520
     * like_people :
     * content_id : 0
     * like_count : 0
     * create_time : 1秒前
     * parent_id : 0
     */

    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String comment_count;
        private String body;
        private String is_markdown;
        private String reply_count;
        private String dislike_count;
        private String dislike_people;
        private String from;
        private String avatar;
        private String id;
        private String timestamp;
        private String username;
        private String like_people;
        private String content_id;
        private String like_count;
        private String create_time;
        private String parent_id;

        public String getComment_count() {
            return comment_count;
        }

        public void setComment_count(String comment_count) {
            this.comment_count = comment_count;
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

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getLike_people() {
            return like_people;
        }

        public void setLike_people(String like_people) {
            this.like_people = like_people;
        }

        public String getContent_id() {
            return content_id;
        }

        public void setContent_id(String content_id) {
            this.content_id = content_id;
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
