package wang.mogujun.csdnplus.geeknews.domain.model;

import java.util.List;

/**
 * Created by WangJun on 2016/4/22.
 */
public class CommunityDetailBean {


    /**
     * id : 67
     * name : Nodejs
     * logo : http://img.my.csdn.net/avR5Ks1uLc143762009993.jpg
     * geekCount : 62
     * desc : 收集Nodejs开发经验、技巧、推荐优秀的开源库
     * operators : ["baisnsf","conslee"]
     */

    private int id;
    private String name;
    private String logo;
    private int geekCount;
    private String desc;
    private List<String> operators;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public int getGeekCount() {
        return geekCount;
    }

    public void setGeekCount(int geekCount) {
        this.geekCount = geekCount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<String> getOperators() {
        return operators;
    }

    public void setOperators(List<String> operators) {
        this.operators = operators;
    }
}
