package wang.mogujun.csdnplus.blog.domain.model;

import java.util.List;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogCateTagInfo {

    /**
     * id : 1
     * name : 移动开发
     * alias : mobile
     * tags : [{"id":1,"label":"Android","cateId":1,"keywords":"Android,android,ANDROID,安卓,app,listview,webview,textview,phonegap","desc":"","inUse":1,"createAt":1445510828000,"updateAt":1445925757000},{"id":2,"label":"iOS","cateId":1,"keywords":"iOS,ios,IOS,ios7,iOS8,ios9,iPhone,iphone,xcode,objective c,sqlite,phonegap,safari,macosx,React Native,ios9兼容","desc":"","inUse":1,"createAt":1445510839000,"updateAt":1445925773000}]
     * orderColumn : 0
     */

    private int id;
    private String name;
    private String alias;
    private int orderColumn;
    /**
     * id : 1
     * label : Android
     * cateId : 1
     * keywords : Android,android,ANDROID,安卓,app,listview,webview,textview,phonegap
     * desc :
     * inUse : 1
     * createAt : 1445510828000
     * updateAt : 1445925757000
     */

    private List<TagsBean> tags;

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

    public int getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(int orderColumn) {
        this.orderColumn = orderColumn;
    }

    public List<TagsBean> getTags() {
        return tags;
    }

    public void setTags(List<TagsBean> tags) {
        this.tags = tags;
    }

    public static class TagsBean {
        private int id;
        private String label;
        private int cateId;
        private String keywords;
        private String desc;
        private int inUse;
        private long createAt;
        private long updateAt;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getCateId() {
            return cateId;
        }

        public void setCateId(int cateId) {
            this.cateId = cateId;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getInUse() {
            return inUse;
        }

        public void setInUse(int inUse) {
            this.inUse = inUse;
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

}
