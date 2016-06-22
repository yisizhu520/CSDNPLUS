package wang.mogujun.csdnplus.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.Subscribe;

import javax.inject.Inject;

import butterknife.BindView;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.data.cache.LoginPrefs;
import wang.mogujun.csdnplus.domain.interactor.user.LoginUseCase;
import wang.mogujun.csdnplus.event.SplashFinishedEvent;

public class SplashActivity extends BaseActivity {

    @Inject
    LoginUseCase loginUseCase;
    @BindView(R.id.splash_container)
    FrameLayout splashContainer;


    @Override
    protected int getContentViewId() {
        return R.layout.splash_act;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getEventBus().register(this);
        //getApplicationComponent().inject(this);
//        UserComponent userComponent = DaggerUserComponent.builder()
//                .applicationComponent(getApplicationComponent())
//                .activityModule(getActivityModule())
//                .userModule(new UserModule())
//                .build();
//        userComponent.inject(this);
//        loginUseCase.setParam("yisizhu520","alusa2406");
//        loginUseCase.execute(new DefaultSubscriber<CSDNResponse>(){
//            @Override
//            public void onError(Throwable e) {
//                Logger.e(e.getMessage());
//                e.printStackTrace();
//                super.onError(e);
//            }
//
//            @Override
//            public void onNext(CSDNResponse response) {
//                Logger.json(JsonUtils.toJson(response));
//                UserInfo info = JsonUtils.fromJson(response.getData(),UserInfo.class);
//                Logger.json(JsonUtils.toJson(info));
//            }
//        });
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.splash_container,
                        SplashStarWarFragment.newInstance())
                .commit();
    }


    @Subscribe
    public void processTransition(SplashFinishedEvent event) {
        if(TextUtils.isEmpty(LoginPrefs.getSessionId())){//如果未登录
            goLogin();
        }else{
            try {
                //如果过期了，则去自动登录
                long expire = Long.parseLong(LoginPrefs.getSessionExpired());
                if(expire < System.currentTimeMillis()){
                    showToast(R.string.expired_auto_login);
                    //TODO auto login
                    goLogin();
                }else{
                    //goLogin();
                    goMain();
                }
            }catch (NumberFormatException e){
                goLogin();
            }

        }


    }

    void goLogin(){
        finish();
        mNavigator.navigateToLogin(this);
    }

    void goMain(){
        finish();
        mNavigator.navigateToMain(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getEventBus().unregister(this);
    }
}
