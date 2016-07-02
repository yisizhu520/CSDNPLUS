package wang.mogujun.csdnplus.data.repository;

import com.google.gson.reflect.TypeToken;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import wang.mogujun.csdnplus.data.net.api.NewsApi;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsColumn;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsLatestListInfo;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsListInfo;
import wang.mogujun.csdnplus.domain.repository.NewsRepository;

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
    public Observable<List<NewsLatestListInfo>> getLatestNews(String lastId, String direction, int size, int activities_count) {
        return RepositoryUtils.extractData(
                mNewsApi.getLatestNews(lastId, direction, size, activities_count),
                new TypeToken<List<NewsLatestListInfo>>() {}.getType()
        );
    }

    @Override
    public Observable<List<NewsListInfo>> getColumnNews(int page, int comid) {
        return RepositoryUtils.extractData(
                mNewsApi.getColumnNews(page, comid),
                new TypeToken<List<NewsLatestListInfo>>() {}.getType()
        );
    }

}
