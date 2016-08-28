package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogTagInfo {


    /**
     * id : 79971
     * username : yisizhu520
     * labelId : 29
     * label : 测试
     * desc : null
     * createAt : 1447594315000
     * updateAt : 1447594315000
     */

    private int id;
    private String username;
    private int labelId;
    private String label;
    private String desc;
    private long createAt;
    private long updateAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }
}
