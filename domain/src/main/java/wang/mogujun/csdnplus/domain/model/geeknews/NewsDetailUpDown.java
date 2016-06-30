package wang.mogujun.csdnplus.domain.model.geeknews;

/**
 * Created by WangJun on 2016/4/30.
 */
public class NewsDetailUpDown {


    /**
     * succ : 620967
     * origin_status : 0
     * status : 1
     * msg : success
     * info : {"ding":"2","comment":10,"cai":"1"}
     */

    private int succ;
    private int origin_status;
    private int status;
    private String msg;
    /**
     * ding : 2
     * comment : 10
     * cai : 1
     */

    private InfoBean info;

    public int getSucc() {
        return succ;
    }

    public void setSucc(int succ) {
        this.succ = succ;
    }

    public int getOrigin_status() {
        return origin_status;
    }

    public void setOrigin_status(int origin_status) {
        this.origin_status = origin_status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public static class InfoBean {
        private int ding;
        private int comment;
        private String cai;

        public int getDing() {
            return ding;
        }

        public void setDing(int ding) {
            this.ding = ding;
        }

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public String getCai() {
            return cai;
        }

        public void setCai(String cai) {
            this.cai = cai;
        }
    }
}
