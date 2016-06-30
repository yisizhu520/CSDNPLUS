package wang.mogujun.csdnplus.event;

/**
 * Created by WangJun on 2016/4/28.
 */
public class HeadlineTabReselectedEvent {

    private int commId;

    public HeadlineTabReselectedEvent(int commId) {
        this.commId = commId;
    }

    public int getCommId() {
        return commId;
    }
}
