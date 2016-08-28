package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogCommentAddInfo {


    /**
     * error :
     * status : true
     * data : {"content":"ssss","blogger":"hp0773","id":6019994,"username":"yisizhu520","article_title":"MTP in Android详解",
     * "article_id":51289621,"nickname":"yisizhu520","create_at":"2016-05-01 15:38:55",
     * "avatar":"http://avatar.csdn.net/D/F/5/1_yisizhu520.jpg","parent_id":0}
     */

    private String error;
    private boolean status;
    private BlogCommentInfo data;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BlogCommentInfo getData() {
        return data;
    }

    public BlogCommentAddInfo setData(BlogCommentInfo data) {
        this.data = data;
        return this;
    }
}
