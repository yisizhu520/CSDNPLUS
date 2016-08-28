package wang.mogujun.csdnplus.blog.domain.model;

import java.util.List;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogRecentPostInfo {


    /**
     * username : u012702547
     * postrecently : true
     * blogTitles : ["Android自定义View之ProgressBar出场记","Android5.0之Activity的转场动画","Android5.0之CardView的使用"]
     * fansCount : 596
     */

    private String username;
    private String postrecently;
    private String fansCount;
    private List<String> blogTitles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostrecently() {
        return postrecently;
    }

    public void setPostrecently(String postrecently) {
        this.postrecently = postrecently;
    }

    public String getFansCount() {
        return fansCount;
    }

    public void setFansCount(String fansCount) {
        this.fansCount = fansCount;
    }

    public List<String> getBlogTitles() {
        return blogTitles;
    }

    public void setBlogTitles(List<String> blogTitles) {
        this.blogTitles = blogTitles;
    }
}
