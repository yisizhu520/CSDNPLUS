package wang.mogujun.csdnplus.blog.domain.model;


import wang.mogujun.csdnplus.domain.DomainConstants;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogColumnListReqBean {

    /*
    username	singwhatiwanna
    page	1
    size	20

     */
    private String username;
    private int page;
    private int size = DomainConstants.DEFAULT_PAGE_SIZE;


    public String getUsername() {
        return username;
    }

    public BlogColumnListReqBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getPage() {
        return page;
    }

    public BlogColumnListReqBean setPage(int page) {
        this.page = page;
        return this;
    }

    public int getSize() {
        return size;
    }

    public BlogColumnListReqBean setSize(int size) {
        this.size = size;
        return this;
    }
}
