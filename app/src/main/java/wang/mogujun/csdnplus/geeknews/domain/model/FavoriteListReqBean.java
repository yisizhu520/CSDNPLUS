package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/4/30.
 */
public class FavoriteListReqBean {

    /*
    username	yisizhu520
    pagesize	10
    pageno	1
     */

    private String username;
    private int pagesize;
    private int pageno;

    public String getUsername() {
        return username;
    }

    public FavoriteListReqBean setUsername(String username) {
        this.username = username;
        return this;
    }

    public int getPagesize() {
        return pagesize;
    }

    public FavoriteListReqBean setPagesize(int pagesize) {
        this.pagesize = pagesize;
        return this;
    }

    public int getPageno() {
        return pageno;
    }

    public FavoriteListReqBean setPageno(int pageno) {
        this.pageno = pageno;
        return this;
    }
}
