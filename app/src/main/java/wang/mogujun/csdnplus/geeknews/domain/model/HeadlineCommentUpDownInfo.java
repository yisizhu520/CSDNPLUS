package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/5/3.
 */
public class HeadlineCommentUpDownInfo {


    /**
     * like_people : yisizhu520,qq_25646921,qq_33873723,qq_34649893,sinat_34781461,leo_liang_jie,qq_34344719,sky15732625340,u012494359,faraway_12121,run_the_youth,fll199358,ecm7324
     * status : 500
     * like_count : 13
     * dislike_people : sinat_34429896,x_i_y_u_e,qq_16832923,love_in2009,qq_31630303
     * dislike_count : 5
     * type : 1
     */

    private String like_people;
    private int status;
    private String like_count;
    private String dislike_people;
    private String dislike_count;
    private int type;

    public String getLike_people() {
        return like_people;
    }

    public void setLike_people(String like_people) {
        this.like_people = like_people;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getLike_count() {
        return like_count;
    }

    public void setLike_count(String like_count) {
        this.like_count = like_count;
    }

    public String getDislike_people() {
        return dislike_people;
    }

    public void setDislike_people(String dislike_people) {
        this.dislike_people = dislike_people;
    }

    public String getDislike_count() {
        return dislike_count;
    }

    public void setDislike_count(String dislike_count) {
        this.dislike_count = dislike_count;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
