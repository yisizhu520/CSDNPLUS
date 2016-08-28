package wang.mogujun.csdnplus.blog.domain.model;


import wang.mogujun.csdnplus.domain.DomainConstants;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogUserArticleListReqBean {

    /*
    username	singwhatiwanna
    page	1
    pagesize	20

     */
    private String username;
    private int page;
    private int pagesize = DomainConstants.DEFAULT_PAGE_SIZE;

    public String getUsername() {
        return username;
    }

    public BlogUserArticleListReqBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getPage() {
        return page;
    }

    public BlogUserArticleListReqBean setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPagesize() {
        return pagesize;
    }

    public BlogUserArticleListReqBean setPagesize(int pagesize) {
        this.pagesize = pagesize;
        return this;
    }
}
