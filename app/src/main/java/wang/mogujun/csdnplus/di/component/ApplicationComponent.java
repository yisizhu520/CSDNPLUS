package wang.mogujun.csdnplus.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import wang.mogujun.csdnplus.di.module.ApiModule;
import wang.mogujun.csdnplus.di.module.ApplicationModule;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.domain.repository.UserRepository;
import wang.mogujun.csdnplus.view.BaseActivity;

/**
 * Created by WangJun on 2016/6/7.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    Context context();

    PostExecutionThread postExecutionThread();

    ThreadExecutor threadExecutor();

    UserRepository userRepository();

    void inject(BaseActivity activity);


}
