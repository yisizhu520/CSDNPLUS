package wang.mogujun.csdnplus.event;

/**
 * Created by WangJun on 2016/4/30.
 */
public class DetailChangeEvent {

    public static final int EVENT_NIGHT_MODE = 1;//0:日间模式 1：夜间模式
    public static final int EVENT_COLLECT = 2;//0：收藏一个 1：取消收藏

    private int eventType;
    private int eventValue;


    public DetailChangeEvent(int eventType, int eventValue) {
        this.eventType = eventType;
        this.eventValue = eventValue;
    }


    public int getEventValue() {
        return eventValue;
    }

    public void setEventValue(int eventValue) {
        this.eventValue = eventValue;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }
}
