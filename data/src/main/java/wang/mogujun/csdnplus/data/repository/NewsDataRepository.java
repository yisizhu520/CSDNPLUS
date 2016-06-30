package wang.mogujun.csdnplus.data.repository;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;
import wang.mogujun.csdnplus.data.net.api.NewsApi;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsColumn;
import wang.mogujun.csdnplus.domain.repository.NewsRepository;

/**
 * Created by WangJun on 2016/6/25.
 */
@Singleton
public class NewsDataRepository implements NewsRepository {

    @Inject
    protected NewsApi mNewsApi;

    @Inject
    public NewsDataRepository(){}

    @Override
    public Observable<List<NewsColumn>> getNewsColumns() {
        return mNewsApi.getNewsColumns();
    }

}
