package wang.mogujun.csdnplus.event;


/**
 * Created by WangJun on 2016/4/29.
 */
public class DetailMenuClickEvent {

    private int index;

    public DetailMenuClickEvent(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
