package wang.mogujun.csdnplus.domain.model.geeknews;

import java.util.List;

public class NewsColumn {

    private Integer id;
    private String name;
    private Integer older;
    private List<NewsChildColumn> childCommunities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOlder() {
        return older;
    }

    public void setOlder(Integer older) {
        this.older = older;
    }

    public List<NewsChildColumn> getChildCommunities() {
        return childCommunities;
    }

    public void setChildCommunities(List<NewsChildColumn> childCommunities) {
        this.childCommunities = childCommunities;
    }
}