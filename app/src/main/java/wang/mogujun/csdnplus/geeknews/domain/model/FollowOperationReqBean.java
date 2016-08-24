package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/4/30.
 */
public class FollowOperationReqBean {

    /*
    username	u012558554
    fans	yisizhu520
     */


    private String username;
    private String fans;

    public String getUsername() {
        return username;
    }

    public FollowOperationReqBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getFans() {
        return fans;
    }

    public FollowOperationReqBean setFans(String fans) {
        this.fans = fans;
        return this;
    }
}
