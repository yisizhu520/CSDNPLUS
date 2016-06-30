package wang.mogujun.csdnplus.domain.model.geeknews;

/**
 * Created by WangJun on 2016/4/9.
 */
public class NewsChildColumn {


    /**
     * id : 47
     * name : 前端
     * createAt : 1447741832000
     * updateAt : 1453183806000
     * communityId : 1
     * inUse : 1
     */

    private int id;
    private String name;
    private long createAt;
    private long updateAt;
    private int communityId;
    private int inUse;

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

    public int getCommunityId() {
        return communityId;
    }

    public void setCommunityId(int communityId) {
        this.communityId = communityId;
    }

    public int getInUse() {
        return inUse;
    }

    public void setInUse(int inUse) {
        this.inUse = inUse;
    }
}
