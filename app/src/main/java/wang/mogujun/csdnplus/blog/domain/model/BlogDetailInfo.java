package wang.mogujun.csdnplus.blog.domain.model;

/**
 * Created by WangJun on 2016/5/7.
 */
public class BlogDetailInfo {


    /**
     * type : original
     * id : 51194108
     * title : 简单算法汇总
     * username : woliuyunyicai
     * is_digged : false
     * level : 0
     * description : 零、全排列问题
     * can_dig : true
     * markdowncontent : 一、全排列问题（Permutation）
     * is_buryed : false
     * categories : 简单算法
     * markdowndirectory : ""
     * view_count : 1345
     * channel : 16
     */

    //TODO 根据博客的类型（原创，翻译，转载）做点区分
    private String type;
    private int id;
    private String title;
    private String username;
    private boolean is_digged;
    private int level;
    private String description;
    private boolean can_dig;
    private String markdowncontent;
    private boolean is_buryed;
    private String categories;
    private String markdowndirectory;
    private int view_count;
    private int channel;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isIs_digged() {
        return is_digged;
    }

    public void setIs_digged(boolean is_digged) {
        this.is_digged = is_digged;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCan_dig() {
        return can_dig;
    }

    public void setCan_dig(boolean can_dig) {
        this.can_dig = can_dig;
    }

    public String getMarkdowncontent() {
        return markdowncontent;
    }

    public void setMarkdowncontent(String markdowncontent) {
        this.markdowncontent = markdowncontent;
    }

    public boolean isIs_buryed() {
        return is_buryed;
    }

    public void setIs_buryed(boolean is_buryed) {
        this.is_buryed = is_buryed;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getMarkdowndirectory() {
        return markdowndirectory;
    }

    public void setMarkdowndirectory(String markdowndirectory) {
        this.markdowndirectory = markdowndirectory;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}
