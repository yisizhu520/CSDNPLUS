package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogCategoryInfo {


    /**
     * id : 1860361
     * article_count : 4
     * hide : false
     * name : Android疑难解答
     */

    private int id;
    private int article_count;
    private boolean hide;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getArticle_count() {
        return article_count;
    }

    public void setArticle_count(int article_count) {
        this.article_count = article_count;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
