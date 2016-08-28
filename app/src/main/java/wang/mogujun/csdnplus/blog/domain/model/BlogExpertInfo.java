package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogExpertInfo {


    /**
     * id : 769
     * username : abcjennifer
     * nickname : Rachel-Zhang
     * realname : 张睿卿
     * content : 浙江大学CS硕士在读，关注计算机视觉，机器学习，算法研究，博弈， 人工智能
     * channel : 编程语言
     * channelId : 16
     * avatar : http://avatar.csdn.net/1/A/0/1_abcjennifer.jpg
     */

    private int id;
    private String username;
    private String nickname;
    private String realname;
    private String content;
    private String channel;
    private int channelId;
    private String avatar;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
