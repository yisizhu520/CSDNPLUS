package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogOperationReqBean {

    /*
    articleId	51194108
    type	0：点赞  1：点踩

     */

    public static final int COMMENT_UP = 0;
    public static final int COMMENT_DOWN = 1;

    private int articleId;
    private int type;

    public int getArticleId() {
        return articleId;
    }

    public BlogOperationReqBean setArticleId(int articleId) {
        this.articleId = articleId;
        return this;
    }

    public int getType() {
        return type;
    }

    public BlogOperationReqBean setType(int type) {
        this.type = type;
        return this;
    }
}
