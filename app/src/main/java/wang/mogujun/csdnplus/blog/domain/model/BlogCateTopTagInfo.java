package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogCateTopTagInfo {

    /**
     * id : 1
     * name : 移动开发
     * alias : mobile
     * createAt : 1445509697000
     * updateAt : 1445938570000
     * orderColumn : 0
     * scope : 3
     */

    private int id;
    private String name;
    private String alias;
    private long createAt;
    private long updateAt;
    private int orderColumn;
    private int scope;

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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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

    public int getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(int orderColumn) {
        this.orderColumn = orderColumn;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

}
