package wang.mogujun.csdnplus.geeknews.domain.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by WangJun on 2016/5/3.
 */
public class HeadlineCommentReqBean {

    /*
    body	bucuo
    Content-Type	application/x-www-form-urlencoded
    title	今日话题：程序员用自己的技术做过哪些趣事？
    url	http://geek.csdn.net/news/detail/70909
     */

    String body;
    @SerializedName("Content-Type")
    String contentType = "application/x-www-form-urlencoded";//TODO 是不是在header里传的？
    String title;
    String url;

    public String getBody() {
        return body;
    }

    public HeadlineCommentReqBean setBody(String body) {
        this.body = body;
        return this;
    }

    public String getContentType() {
        return contentType;
    }

    public HeadlineCommentReqBean setContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public HeadlineCommentReqBean setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public HeadlineCommentReqBean setUrl(String url) {
        this.url = url;
        return this;
    }
}
