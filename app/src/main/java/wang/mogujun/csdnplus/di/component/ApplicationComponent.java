package wang.mogujun.csdnplus.di.component;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Component;
import wang.mogujun.csdnplus.di.module.ApiModule;
import wang.mogujun.csdnplus.di.module.ApplicationModule;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.domain.repository.UserRepository;
import wang.mogujun.csdnplus.view.BaseActivity;
import wang.mogujun.csdnplus.view.BaseFragment;
import wang.mogujun.csdnplus.view.CSDNNavigator;

/**
 * Created by WangJun on 2016/6/7.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    Context context();

    EventBus eventBus();

    PostExecutionThread postExecutionThread();

    ThreadExecutor threadExecutor();

    UserRepository userRepository();

    CSDNNavigator navigator();

    void inject(BaseActivity activity);

    void inject(BaseFragment fragment);


}
