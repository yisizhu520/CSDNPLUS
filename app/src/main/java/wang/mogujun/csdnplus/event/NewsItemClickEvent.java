package wang.mogujun.csdnplus.event;

import wang.mogujun.csdnplus.domain.model.geeknews.NewsLatestListInfo;

/**
 * Created by WangJun on 2016/7/2.
 */
public class NewsItemClickEvent {

    public static final int EVENT_CONTENT_CLICK = 1;
    public int type;
    public NewsLatestListInfo item;

    public NewsItemClickEvent(int type, NewsLatestListInfo item){
        this.type = type;
        this.item = item;
    }



}
