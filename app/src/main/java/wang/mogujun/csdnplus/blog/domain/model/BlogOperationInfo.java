package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogOperationInfo {


    /**
     * error :
     * status : true
     * data : {"digg":3,"bury":0}
     */

    private String error;
    private boolean status;
    /**
     * digg : 3
     * bury : 0
     */

    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private int digg;
        private int bury;

        public int getDigg() {
            return digg;
        }

        public void setDigg(int digg) {
            this.digg = digg;
        }

        public int getBury() {
            return bury;
        }

        public void setBury(int bury) {
            this.bury = bury;
        }
    }
}
