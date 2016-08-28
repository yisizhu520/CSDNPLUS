package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogColumnInfo {


    /**
     * article_count : 17
     * logo : http://img.blog.csdn.net/20151123175454833
     * title : Android开发小栈
     * alias : android-stage
     * description :
     * view_count : 339187
     * channel : 1
     * url : http://blog.csdn.net/column/details/android-stage.html
     */

    private int article_count;
    private String logo;
    private String title;
    private String alias;
    private String description;
    private int view_count;
    private int channel;
    private String url;

    public int getArticle_count() {
        return article_count;
    }

    public void setArticle_count(int article_count) {
        this.article_count = article_count;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
