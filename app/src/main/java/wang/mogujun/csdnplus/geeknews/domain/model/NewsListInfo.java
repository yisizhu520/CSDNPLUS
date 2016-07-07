package wang.mogujun.csdnplus.geeknews.domain.model;

/**
 * Created by WangJun on 2016/4/14.
 */
public class NewsListInfo {


    /**
     * desc : React.createElement方法使用详解
     * tag : React,createElement
     * forum_name : 前端
     * source_url : http://www.onmpw.com/tm/xwzj/web_103.html
     * score : 12.611412
     * source_type : hackernewsv2
     * type : hackernewsv2
     * id : 66333
     * nick_name : lt_迹忆
     * rank : 0
     * title : React.createElement方法使用详解
     * created_at : 2016-04-08 12:27:36
     * source_name : 极客头条
     * is_markdown : 0
     * sub_source_name :
     * category_id : 0
     * pic :
     * avatar : http://avatar.csdn.net/5/4/F/1_fengqianlang.jpg
     * operator :
     * url : http://www.onmpw.com/tm/xwzj/web_103.html
     * ip : 0
     * is_expert : 0
     * user_name : fengqianlang
     * expert_username :
     * operate_time : 1970-01-01 08:30:00
     * category_name :
     * fav_num : 0
     * update_time : 2016-04-10 11:34:04
     * forum_id : 47
     * views : 2928
     * from_type : 1
     * downs : 0
     * ups : 1
     * in_white_list : 0
     * comments : 0
     */

    /*共有字段*/
    private String desc;
    private String type;
    private int id;
    private String nick_name;
    private String title;
    private String created_at;
    private String source_name;
    private String sub_source_name;
    private String pic;
    private String avatar;
    private String url;
    private String user_name;
    private int views;
    private int downs;
    private int ups;
    private int comments;

    /*栏目头条特有字段*/
    private String tag;
    private int in_white_list;
    private int from_type;
    private int forum_id;
    private String forum_name;
    private int fav_num;
    private String update_time;
    private String expert_username;
    private String operate_time;
    private String category_name;
    private int ip;
    private int is_expert;
    private String operator;
    private int category_id;
    private int is_markdown;
    private String rank;
    private String score;
    private String source_url;
    private String source_type;


    /*最新头条里特有字段*/
    private String _id;
    private String is_caught;
    private String catch_id;
    private String m_id;
    private String geek_id;

    /*数据库追加字段*/
    private int isRead;



    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIs_caught() {
        return is_caught;
    }

    public void setIs_caught(String is_caught) {
        this.is_caught = is_caught;
    }

    public String getCatch_id() {
        return catch_id;
    }

    public void setCatch_id(String catch_id) {
        this.catch_id = catch_id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getForum_name() {
        return forum_name;
    }

    public void setForum_name(String forum_name) {
        this.forum_name = forum_name;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getSource_type() {
        return source_type;
    }

    public void setSource_type(String source_type) {
        this.source_type = source_type;
    }

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

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getSource_name() {
        return source_name;
    }

    public void setSource_name(String source_name) {
        this.source_name = source_name;
    }

    public int getIs_markdown() {
        return is_markdown;
    }

    public void setIs_markdown(int is_markdown) {
        this.is_markdown = is_markdown;
    }

    public String getSub_source_name() {
        return sub_source_name;
    }

    public void setSub_source_name(String sub_source_name) {
        this.sub_source_name = sub_source_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIp() {
        return ip;
    }

    public void setIp(int ip) {
        this.ip = ip;
    }

    public int getIs_expert() {
        return is_expert;
    }

    public void setIs_expert(int is_expert) {
        this.is_expert = is_expert;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getExpert_username() {
        return expert_username;
    }

    public void setExpert_username(String expert_username) {
        this.expert_username = expert_username;
    }

    public String getOperate_time() {
        return operate_time;
    }

    public void setOperate_time(String operate_time) {
        this.operate_time = operate_time;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public int getFav_num() {
        return fav_num;
    }

    public void setFav_num(int fav_num) {
        this.fav_num = fav_num;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    public int getForum_id() {
        return forum_id;
    }

    public void setForum_id(int forum_id) {
        this.forum_id = forum_id;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getFrom_type() {
        return from_type;
    }

    public void setFrom_type(int from_type) {
        this.from_type = from_type;
    }

    public int getDowns() {
        return downs;
    }

    public void setDowns(int downs) {
        this.downs = downs;
    }

    public int getUps() {
        return ups;
    }

    public void setUps(int ups) {
        this.ups = ups;
    }

    public int getIn_white_list() {
        return in_white_list;
    }

    public void setIn_white_list(int in_white_list) {
        this.in_white_list = in_white_list;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getGeek_id() {
        return geek_id;
    }

    public void setGeek_id(String geek_id) {
        this.geek_id = geek_id;
    }

    public int getIsRead() {
        return isRead;
    }

    public void setIsRead(int isRead) {
        this.isRead = isRead;
    }
}
