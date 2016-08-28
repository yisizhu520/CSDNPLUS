package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogColumnArticleListReqBean {

    /*
    alias	android-source-walk
    page	1
    size	20

     */

    private String alias;
    private int page;
    private int size;

    public String getAlias() {
        return alias;
    }

    public BlogColumnArticleListReqBean setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public int getPage() {
        return page;
    }

    public BlogColumnArticleListReqBean setPage(int page) {
        this.page = page;
        return this;
    }

    public int getSize() {
        return size;
    }

    public BlogColumnArticleListReqBean setSize(int size) {
        this.size = size;
        return this;
    }
}
