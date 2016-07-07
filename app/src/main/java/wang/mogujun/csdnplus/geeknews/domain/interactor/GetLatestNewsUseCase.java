package wang.mogujun.csdnplus.geeknews.domain.interactor.geeknews;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import wang.mogujun.csdnplus.domain.DomainConstants;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.domain.interactor.UseCase;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsListInfo;
import wang.mogujun.csdnplus.geeknews.domain.repository.NewsRepository;

/**
 * Created by WangJun on 2016/6/25.
 */
public class GetLatestNewsUseCase extends UseCase<List<NewsListInfo>> {

    private final NewsRepository mNewsRepository;

    private String lastId;
    private String direction;
    private int size = DomainConstants.DEFAULT_PAGE_SIZE;
    private int activities_count = 0;

    @Inject
    public GetLatestNewsUseCase(NewsRepository newsRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mNewsRepository = newsRepository;
    }

    @Override
    protected Observable<List<NewsListInfo>> buildUseCaseObservable() {
        return mNewsRepository.getLatestNews(lastId,direction,size,activities_count);
    }


    public GetLatestNewsUseCase setLastId(String lastId) {
        this.lastId = lastId;
        return this;
    }


    public GetLatestNewsUseCase setDirection(String direction) {
        this.direction = direction;
        return this;
    }


    public GetLatestNewsUseCase setSize(int size) {
        this.size = size;
        return this;
    }


    public GetLatestNewsUseCase setActivities_count(int activities_count) {
        this.activities_count = activities_count;
        return this;
    }
}
