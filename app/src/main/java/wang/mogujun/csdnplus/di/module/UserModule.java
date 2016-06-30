package wang.mogujun.csdnplus.di.module;

import dagger.Module;
import dagger.Provides;
import wang.mogujun.csdnplus.di.PerFragment;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.domain.interactor.user.LoginUseCase;
import wang.mogujun.csdnplus.domain.repository.UserRepository;

/**
 * Created by WangJun on 2016/6/7.
 */
@Module
public class UserModule {

    @PerFragment
    @Provides
    LoginUseCase provideLoginUseCase(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        return new LoginUseCase(userRepository,threadExecutor,postExecutionThread);
    }



}
