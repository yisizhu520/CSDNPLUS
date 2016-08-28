package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogNormalListInfo {


    /**
     * blogId : 4846429
     * articleId : 51286791
     * title : 浅谈iOS单元测试
     * userName : IT_DS
     * nickname : 欣麒骥
     * avatar : http://avatar.csdn.net/4/0/8/1_it_ds.jpg
     * description : 什么是单元测试？是指对软件中的最小可测试单元进行检查和验证。
     * viewCount : 21
     * digg : 1
     * bury : 0
     * commentCount : 0
     * tags : ios,单元测试,测试
     * postTime : 2016-04-30 16:05:37
     * url : http://blog.csdn.net/IT_DS/article/details/51286791
     * channelId : 0
     */

    private int blogId;
    private int articleId;
    private String title;
    private String userName;
    private String nickname;
    private String avatar;
    private String description;
    private int viewCount;
    private int digg;
    private int bury;
    private int commentCount;
    private String tags;
    private String postTime;
    private String url;
    private int channelId;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getDigg() {
        return digg;
    }

    public void setDigg(int digg) {
        this.digg = digg;
    }

    public int getBury() {
        return bury;
    }

    public void setBury(int bury) {
        this.bury = bury;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }
}
