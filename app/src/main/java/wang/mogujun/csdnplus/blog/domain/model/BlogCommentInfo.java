package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogCommentInfo {


    /**
     * content : 回复u010850027: 谢谢您的点评！
     * blogger : woliuyunyicai
     * id : 5991673
     * username : woliuyunyicai
     * article_title : 简单算法汇总
     * article_id : 51194108
     * nickname : 流云易采
     * create_at : 2016-04-20 18:48:51
     * avatar : http://avatar.csdn.net/1/5/7/1_woliuyunyicai.jpg
     * parent_id : 0
     */

    private String content;
    private String blogger;
    private int id;
    private String username;
    private String article_title;
    private int article_id;
    private String nickname;
    private String create_at;
    private String avatar;
    private int parent_id;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBlogger() {
        return blogger;
    }

    public void setBlogger(String blogger) {
        this.blogger = blogger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public int getArticle_id() {
        return article_id;
    }

    public void setArticle_id(int article_id) {
        this.article_id = article_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }
}
