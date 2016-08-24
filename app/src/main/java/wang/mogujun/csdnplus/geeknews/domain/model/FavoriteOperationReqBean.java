package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/4/30.
 */
public class FavoriteOperationReqBean {

    /*
    url	http://geek.csdn.net/news/detail/70909
    username	yisizhu520
    title	今日话题：程序员用自己的技术做过哪些趣事？
     */

    private String url;
    private String username;
    private String title;
    private String id;

    public String getId() {
        return id;
    }

    public FavoriteOperationReqBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public FavoriteOperationReqBean setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public FavoriteOperationReqBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public FavoriteOperationReqBean setTitle(String title) {
        this.title = title;
        return this;
    }
}
