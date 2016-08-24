package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/4/30.
 */
public class FavoriteOperationInfo {


    /**
     * id : 10342054
     */

    private DataBean data;
    /**
     * data : {"id":10342054}
     * msg : 收藏成功
     * success : 1
     */

    private String msg;
    private int success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public static class DataBean {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
