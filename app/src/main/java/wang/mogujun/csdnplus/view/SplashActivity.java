package wang.mogujun.csdnplus.view;

import android.os.Bundle;

import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.domain.interactor.DefaultSubscriber;
import wang.mogujun.csdnplus.domain.interactor.user.LoginUseCase;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;
import wang.mogujun.csdnplus.domain.model.UserInfo;
import wang.mogujun.csdnplus.domain.repository.UserRepository;
import wang.mogujun.ext.utils.JsonUtils;

public class SplashActivity extends BaseActivity {

    LoginUseCase loginUseCase;
    @Inject
    UserRepository userRepository;
    @Inject
    ThreadExecutor threadExecutor;
    @Inject
    PostExecutionThread postExecutionThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginUseCase = new LoginUseCase(userRepository,threadExecutor,postExecutionThread);
        loginUseCase.setParam("yisizhu520","alusa2406");
        loginUseCase.execute(new DefaultSubscriber<CSDNResponse>(){
            @Override
            public void onError(Throwable e) {
                Logger.e(e.getMessage());
                e.printStackTrace();
                super.onError(e);
            }

            @Override
            public void onNext(CSDNResponse response) {
                Logger.json(JsonUtils.toJson(response));
                UserInfo info = JsonUtils.fromJson(response.getData(),UserInfo.class);
                Logger.json(JsonUtils.toJson(info));
            }
        });
    }

    @Override
    protected int getContentViewId() {
        return R.layout.splash_act;
    }
}
