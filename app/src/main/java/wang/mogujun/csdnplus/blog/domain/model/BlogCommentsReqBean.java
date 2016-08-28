package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogCommentsReqBean {

    /*
    username	woliuyunyicai
    articleId	51194108
    page	1

     */

    private String username;
    private int articleId;
    private int page;

    public String getUsername() {
        return username;
    }

    public BlogCommentsReqBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getArticleId() {
        return articleId;
    }

    public BlogCommentsReqBean setArticleId(int articleId) {
        this.articleId = articleId;
        return this;
    }

    public int getPage() {
        return page;
    }

    public BlogCommentsReqBean setPage(int page) {
        this.page = page;
        return this;
    }
}
