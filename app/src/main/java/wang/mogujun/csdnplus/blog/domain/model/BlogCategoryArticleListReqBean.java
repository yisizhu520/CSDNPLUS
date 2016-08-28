package wang.mogujun.csdnplus.blog.domain.model;

import com.stevenmoon.csdnplus.app.Constants;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogCategoryArticleListReqBean {

    /*
    id	1405419（博客分类id）
    page	1
    username	singwhatiwanna
    size	20

     */

    private int id;
    private int page;
    private String username;
    private int size = Constants.CONFIG.DEFAULT_PAGE_SIZE;

    public int getId() {
        return id;
    }

    public BlogCategoryArticleListReqBean setId(int id) {
        this.id = id;
        return this;
    }

    public int getSize() {
        return size;
    }

    public BlogCategoryArticleListReqBean setSize(int size) {
        this.size = size;
        return this;
    }

    public int getPage() {
        return page;
    }

    public BlogCategoryArticleListReqBean setPage(int page) {
        this.page = page;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public BlogCategoryArticleListReqBean setUsername(String username) {
        this.username = username;
        return this;
    }
}
