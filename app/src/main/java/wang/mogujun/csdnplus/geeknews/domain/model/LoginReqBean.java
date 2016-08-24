package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/4/5.
 */
public class LoginReqBean {

    public String username;
    public String password;

    public LoginReqBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
