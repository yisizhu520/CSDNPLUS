package wang.mogujun.csdnplus.geeknews.domain.repository;

import java.util.List;

import rx.Observable;
import wang.mogujun.csdnplus.geeknews.domain.model.CommentInfoBean;
import wang.mogujun.csdnplus.geeknews.domain.model.CommunityDetailBean;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsColumn;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsDetail;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsListInfo;

/**
 * Created by WangJun on 2016/6/25.
 */
public interface NewsRepository {

    Observable<List<NewsColumn>> getNewsColumns();

    Observable<List<NewsListInfo>> getLatestNews(String lastId, String direction, int size, int activities_count);

    Observable<List<NewsListInfo>> getColumnNews(int page, int comid);

    Observable<NewsDetail> getNewsDetail(int id);

    Observable<CommunityDetailBean> getCommunityDetail(String childcommunityid);

    Observable<CommentInfoBean> getCommentList(String url, int pageno, int pagesize);


}
