package wang.mogujun.csdnplus.geeknews.domain.model;

import java.util.List;

/**
 * Created by WangJun on 2016/4/30.
 */
public class FavoriteListInfo {


    /**
     * data : [{"id":"10340804","share":"0","title":"Android studio 多渠道打包(超简洁版)","username":"yisizhu520","description":"","domain":"geek.csdn.net","dateline":"1462000195","url":"http://geek.csdn.net/news/detail/70544"}]
     * success : 1
     */

    private int success;
    /**
     * id : 10340804
     * share : 0
     * title : Android studio 多渠道打包(超简洁版)
     * username : yisizhu520
     * description :
     * domain : geek.csdn.net
     * dateline : 1462000195
     * url : http://geek.csdn.net/news/detail/70544
     */

    private List<FavoriteInfo> data;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public List<FavoriteInfo> getData() {
        return data;
    }

    public void setData(List<FavoriteInfo> data) {
        this.data = data;
    }

    public static class FavoriteInfo {
        private String id;
        private String share;
        private String title;
        private String username;
        private String description;
        private String domain;
        private String dateline;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getShare() {
            return share;
        }

        public void setShare(String share) {
            this.share = share;
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

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getDateline() {
            return dateline;
        }

        public void setDateline(String dateline) {
            this.dateline = dateline;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
