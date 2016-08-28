package wang.mogujun.csdnplus.blog.domain.model;


import wang.mogujun.csdnplus.domain.DomainConstants;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogNormalListReqBean {

    /*
    tagId	29
    page	1
    pagesize	20

     */

    private int tagId;
    private int page;
    private int pagesize = DomainConstants.DEFAULT_PAGE_SIZE;

    public int getTagId() {
        return tagId;
    }

    public BlogNormalListReqBean setTagId(int tagId) {
        this.tagId = tagId;
        return this;
    }

    public int getPage() {
        return page;
    }

    public BlogNormalListReqBean setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPagesize() {
        return pagesize;
    }

    public BlogNormalListReqBean setPagesize(int pagesize) {
        this.pagesize = pagesize;
        return this;
    }
}
