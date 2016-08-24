package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/4/30.
 */
public class DetailUpDownReqBean {

    public static final int STATUS_UP = 1;
    public static final int STATUS_DOWN = 2;

    public static final int TYPE_NEWS = 10;
    public static final int TYPE_GEEK = 11;
    public static final int TYPE_CONTENT_CENTER = 12;

    private int article_id;
    private int status;

    public int getArticle_id() {
        return article_id;
    }

    public DetailUpDownReqBean setArticle_id(int article_id) {
        this.article_id = article_id;
        return this;
    }


    public int getType() {
        return type;
    }

    public DetailUpDownReqBean setType(int type) {
        this.type = type;
        return this;
    }

    private int type;


    public int getStatus() {
        return status;
    }

    public DetailUpDownReqBean setStatus(int status) {
        this.status = status;
        return this;
    }
}
