package wang.mogujun.csdnplus.view.user;

import wang.mogujun.uiframework.mvp.MvpBasePresenter;
import wang.mogujun.uiframework.mvp.MvpView;

/**
 * Created by WangJun on 2016/6/22.
 */
public interface LoginContract {

    interface View extends MvpView {

        void showLoading();

        void showLoginSuccess();

        void showLoginError(String msg);

    }

    abstract class Presenter extends MvpBasePresenter<View>{

        abstract void doLogin(String account,String pwd);

    }


}
