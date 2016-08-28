package wang.mogujun.csdnplus.blog.domain.model;


import wang.mogujun.csdnplus.domain.DomainConstants;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogRecommendListReqBean {

    /*
    lastId	-
    direction	down
    size	20

     */

    private String lastId;
    private String direction;
    private int size = DomainConstants.DEFAULT_PAGE_SIZE;

    public String getLastId() {
        return lastId;
    }

    public BlogRecommendListReqBean setLastId(String lastId) {
        this.lastId = lastId;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public BlogRecommendListReqBean setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public int getSize() {
        return size;
    }

    public BlogRecommendListReqBean setSize(int size) {
        this.size = size;
        return this;
    }
}
