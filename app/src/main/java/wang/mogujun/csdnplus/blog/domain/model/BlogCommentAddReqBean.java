package wang.mogujun.csdnplus.blog.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogCommentAddReqBean {

    /*
    content	不错<img src="http://forum.csdn.net/PointForum/ui/scripts/csdn/Plugin/001/face/13.gif" title="" />
    Content-Type	application/x-www-form-urlencoded
    articleId	51288039

     */

    private String content;
    @SerializedName("Content-Type")
    private String contentType;
    private int articleId;

    public String getContent() {
        return content;
    }

    public BlogCommentAddReqBean setContent(String content) {
        this.content = content;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public BlogCommentAddReqBean setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public int getArticleId() {
        return articleId;
    }

    public BlogCommentAddReqBean setArticleId(int articleId) {
        this.articleId = articleId;
        return this;
    }
}
