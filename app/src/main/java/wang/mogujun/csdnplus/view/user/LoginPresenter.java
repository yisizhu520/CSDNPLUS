package wang.mogujun.csdnplus.view.user;

import javax.inject.Inject;

import wang.mogujun.csdnplus.data.cache.LoginPrefs;
import wang.mogujun.csdnplus.di.PerFragment;
import wang.mogujun.csdnplus.domain.interactor.user.LoginUseCase;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;
import wang.mogujun.csdnplus.domain.model.UserInfo;
import wang.mogujun.csdnplus.view.CSDNSubscriber;
import wang.mogujun.ext.utils.JsonUtils;

/**
 * Created by WangJun on 2016/6/22.
 */
@PerFragment
public class LoginPresenter extends LoginContract.Presenter {

    @Inject
    LoginUseCase mLoginUseCase;

    @Inject
    public LoginPresenter(LoginUseCase loginUseCase){
        mLoginUseCase = loginUseCase;
    }

    @Override
    void doLogin(String account, String pwd) {
        mLoginUseCase.setParam(account,pwd);
        mLoginUseCase.execute(new CSDNSubscriber<CSDNResponse>(){

            @Override
            protected void onErrorMsg(String errorMsg) {
                super.onErrorMsg(errorMsg);
                getView().showLoginError(errorMsg);
            }

            @Override
            public void onNext(CSDNResponse response) {
                super.onNext(response);
                LoginPrefs.setSessionId(response.getSessionId());
                LoginPrefs.setSessionExpired(response.getSessionExpired());
                UserInfo accountBean = JsonUtils.fromJson(response.getData(),UserInfo.class);
                LoginPrefs.setTGC(accountBean.getTgc());
                LoginPrefs.setUserInfo(accountBean.getUserInfo());
                LoginPrefs.setMobile(accountBean.getMobile());
                LoginPrefs.setEmail(accountBean.getEmail());
                LoginPrefs.setUser_id(accountBean.getId());
                LoginPrefs.setUser_userId(accountBean.getUserId());
                LoginPrefs.setNickname(accountBean.getNickname());
                LoginPrefs.setUserName(accountBean.getUserName());
            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                getView().showLoginSuccess();
            }
        });
    }

    @Override
    public void detachView(boolean retainInstance) {
        mLoginUseCase.unsubscribe();
        super.detachView(retainInstance);
    }
}
