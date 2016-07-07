package wang.mogujun.csdnplus.di.module;

import dagger.Module;
import dagger.Provides;
import wang.mogujun.csdnplus.di.PerFragment;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.geeknews.domain.interactor.geeknews.GetColumnNewsUseCase;
import wang.mogujun.csdnplus.geeknews.domain.interactor.geeknews.GetLatestNewsUseCase;
import wang.mogujun.csdnplus.geeknews.domain.interactor.geeknews.GetNewsColumnUseCase;
import wang.mogujun.csdnplus.geeknews.domain.repository.NewsRepository;

/**
 * Created by WangJun on 2016/7/2.
 */
@Module
public class NewsModule {

    @PerFragment
    @Provides
    GetLatestNewsUseCase provideGetLatestNewsUseCase(NewsRepository newsRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new GetLatestNewsUseCase(newsRepository,threadExecutor,postExecutionThread);
    }

    @PerFragment
    @Provides
    GetColumnNewsUseCase provideGetColumnNewsUseCase(NewsRepository newsRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new GetColumnNewsUseCase(newsRepository,threadExecutor,postExecutionThread);
    }

    @PerFragment
    @Provides
    GetNewsColumnUseCase provideGetNewsColumnUseCase(NewsRepository newsRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new GetNewsColumnUseCase(newsRepository,threadExecutor,postExecutionThread);
    }


}
