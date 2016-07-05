package wang.mogujun.csdnplus.domain.interactor.geeknews;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.domain.interactor.UseCase;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsListInfo;
import wang.mogujun.csdnplus.domain.repository.NewsRepository;

/**
 * Created by WangJun on 2016/6/25.
 */
public class GetColumnNewsUseCase extends UseCase<List<NewsListInfo>> {

    private final NewsRepository mNewsRepository;

    private int page;
    private int comid;

    @Inject
    public GetColumnNewsUseCase(NewsRepository newsRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mNewsRepository = newsRepository;
    }

    @Override
    protected Observable<List<NewsListInfo>> buildUseCaseObservable() {
        return mNewsRepository.getColumnNews(page,comid);
    }

    public GetColumnNewsUseCase setPage(int page) {
        this.page = page;
        return this;
    }

    public GetColumnNewsUseCase setComid(int comid) {
        this.comid = comid;
        return this;
    }
}
