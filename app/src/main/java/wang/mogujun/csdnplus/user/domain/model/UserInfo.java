package wang.mogujun.csdnplus.user.domain.model;

/**
 * Created by WangJun on 2016/4/5.
 */
public class UserInfo {

    /*
        id": 0,
        "userId": 25195366,
        "userName": "yisizhu520",
        "email": "1914731404@qq.com",
        "mobile": "13411393967",
        "nickname": "StevenMoon",
        "userInfo": "lsjWNVbRI2RMyXDUNyG3mcOFUeyeHO5EQQnzJeq6GGFWCPdzHX07s4aAHSGegaaNDgdpgLB8FYxSpgZM/Tw7llK95jTmDan8hGbzjGEDaZ6ymirAw+dD7bTCXArIYcuW49iFp0rcDqUHJBwWbYXdbQ==",
        "created_at": "",
        "updated_at": "",
        "avatarUpdateTime": 0,
        "app": null,
        "tgc": "TGT-58009-fyZ7sibbbM3az2muIoaeRvXegyxGsmkN6HpDaHvyVgSA2eGfUE-passport.csdn.net",
        "avatar": "http://avatar.csdn.net/D/F/5/1_yisizhu520.jpg"
     */

    private String id;
    private String userId;
    private String userName;
    private String email;
    private String mobile;
    private String nickname;
    private String userInfo;
    private String created_at;
    private String updated_at;
    private String avatarUpdateTime;
    private String app;
    private String tgc;
    private String avatar;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getAvatarUpdateTime() {
        return avatarUpdateTime;
    }

    public void setAvatarUpdateTime(String avatarUpdateTime) {
        this.avatarUpdateTime = avatarUpdateTime;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getTgc() {
        return tgc;
    }

    public void setTgc(String tgc) {
        this.tgc = tgc;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
