package wang.mogujun.csdnplus.di.module;

import dagger.Module;
import dagger.Provides;
import wang.mogujun.csdnplus.di.PerActivity;
import wang.mogujun.csdnplus.domain.interactor.user.LoginUseCase;

/**
 * Created by WangJun on 2016/6/7.
 */
@Module
public class UserModule {

    @PerActivity
    @Provides
    LoginUseCase provideLoginUseCase(LoginUseCase login) {
        return login;
    }



}
