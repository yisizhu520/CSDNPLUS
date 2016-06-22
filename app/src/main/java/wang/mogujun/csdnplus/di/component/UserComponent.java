package wang.mogujun.csdnplus.di.component;

/**
 * Created by WangJun on 2016/6/7.
 */

import dagger.Component;
import wang.mogujun.csdnplus.di.PerActivity;
import wang.mogujun.csdnplus.di.module.ActivityModule;
import wang.mogujun.csdnplus.di.module.UserModule;
import wang.mogujun.csdnplus.view.SplashActivity;
import wang.mogujun.csdnplus.view.user.LoginFragment;

@PerActivity
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class,UserModule.class})
public interface UserComponent extends ActivityComponent{

    void inject(SplashActivity activity);

    void inject(LoginFragment fragment);

}
