package wang.mogujun.csdnplus.geeknews.domain.interactor;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.domain.interactor.UseCase;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsColumn;
import wang.mogujun.csdnplus.geeknews.domain.repository.NewsRepository;

/**
 * Created by WangJun on 2016/6/25.
 */
public class GetNewsColumnUseCase extends UseCase<List<NewsColumn>> {

    private final NewsRepository mNewsRepository;

    @Inject
    public GetNewsColumnUseCase(NewsRepository newsRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.mNewsRepository = newsRepository;
    }

    @Override
    protected Observable<List<NewsColumn>> buildUseCaseObservable() {
        return mNewsRepository.getNewsColumns();
    }

}
