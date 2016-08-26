package wang.mogujun.csdnplus.geeknews.data.repository;

import com.google.gson.reflect.TypeToken;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import wang.mogujun.csdnplus.data.repository.RepositoryUtils;
import wang.mogujun.csdnplus.geeknews.data.net.NewsApi;
import wang.mogujun.csdnplus.geeknews.domain.model.CommentInfoBean;
import wang.mogujun.csdnplus.geeknews.domain.model.CommunityDetailBean;
import wang.mogujun.csdnplus.geeknews.domain.model.DetailUpDownInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.HeadlineCommentInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.HeadlineCommentReqBean;
import wang.mogujun.csdnplus.geeknews.domain.model.HeadlineCommentUpDownInfo;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsColumn;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsDetail;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsListInfo;
import wang.mogujun.csdnplus.geeknews.domain.repository.NewsRepository;
import wang.mogujun.ext.utils.JsonUtils;

/**
 * Created by WangJun on 2016/6/25.
 */
@Singleton
public class NewsDataRepository implements NewsRepository {

    @Inject
    protected NewsApi mNewsApi;

    @Inject
    public NewsDataRepository() {
    }

    @Override
    public Observable<List<NewsColumn>> getNewsColumns() {
        return RepositoryUtils.extractData(mNewsApi.getNewsColumns(),
                new TypeToken<List<NewsColumn>>() {}.getType()
        );
    }

    @Override
    public Observable<List<NewsListInfo>> getLatestNews(String lastId, String direction, int size, int activities_count) {
        return RepositoryUtils.extractData(
                mNewsApi.getLatestNews(lastId, direction, size, activities_count),
                new TypeToken<List<NewsListInfo>>() {}.getType()
        );
    }

    @Override
    public Observable<List<NewsListInfo>> getColumnNews(int page, int comid) {
        return RepositoryUtils.extractData(
                mNewsApi.getColumnNews(page, comid),
                new TypeToken<List<NewsListInfo>>() {}.getType()
        );
    }

    @Override
    public Observable<NewsDetail> getNewsDetail(int id) {
        return RepositoryUtils.extractData(
                mNewsApi.getHeadlineDetail(id), NewsDetail.class
        );
    }

    @Override
    public Observable<CommunityDetailBean> getCommunityDetail(String childcommunityid) {
        return RepositoryUtils.extractData(
                mNewsApi.getCommunityDetail(childcommunityid), CommunityDetailBean.class
        );
    }

    @Override
    public Observable<CommentInfoBean> getCommentList(String url, int pageno, int pagesize) {
        return RepositoryUtils.extractData(
                mNewsApi.getCommentList(url,pageno,pagesize), CommentInfoBean.class
        );
    }

    @Override
    public Observable<DetailUpDownInfo> doDetailUpDown(String url_type, int article_id, int status) {
        return RepositoryUtils.extractData(
                mNewsApi.doDetailUpDown(url_type,article_id,status), DetailUpDownInfo.class
        );
    }

    @Override
    public Observable<HeadlineCommentUpDownInfo> doCommentUp(String username, String commentId) {
        return RepositoryUtils.extractData(
                mNewsApi.doCommentUp(username,commentId), HeadlineCommentUpDownInfo.class
        );
    }

    @Override
    public Observable<HeadlineCommentUpDownInfo> doCommentDown(String username, String commentId) {
        return RepositoryUtils.extractData(
                mNewsApi.doCommentDown(username,commentId), HeadlineCommentUpDownInfo.class
        );
    }

    @Override
    public Observable<HeadlineCommentInfo> addComment(HeadlineCommentReqBean reqBean) {
        return RepositoryUtils.extractData(
                mNewsApi.addComment(JsonUtils.convertBean2Map(reqBean)), HeadlineCommentInfo.class
        );
    }


}
