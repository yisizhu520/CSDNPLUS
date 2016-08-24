package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/4/30.
 */
public class FollowOperationInfo {


    /**
     * succ : 1
     * msg : 关注成功
     */

    private int succ;
    private String msg;

    public int getSucc() {
        return succ;
    }

    public void setSucc(int succ) {
        this.succ = succ;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
