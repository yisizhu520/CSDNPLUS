package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogCategoryListReqBean {

    /*
    page	1
    username	singwhatiwanna

     */

    private int page;
    private String username;

    public int getPage() {
        return page;
    }

    public BlogCategoryListReqBean setPage(int page) {
        this.page = page;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public BlogCategoryListReqBean setUsername(String username) {
        this.username = username;
        return this;
    }
}
