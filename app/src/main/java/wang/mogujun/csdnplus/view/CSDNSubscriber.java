package wang.mogujun.csdnplus.view;

import android.content.Context;

import com.orhanobut.logger.Logger;

import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.data.exception.ResponseException;
import wang.mogujun.csdnplus.domain.interactor.DefaultSubscriber;
import wang.mogujun.csdnplus.exception.ErrorMessageFactory;

/**
 * Created by WangJun on 2016/6/22.
 */
public class CSDNSubscriber<T> extends DefaultSubscriber<T>{

    Context mContext;
    CSDNNavigator mNavigator;

    public CSDNSubscriber(){
        mContext = CSDNApplication.getInstance().getApplicationComponent().context();
        mNavigator = CSDNApplication.getInstance().getApplicationComponent().navigator();
    }

    @Override
    public void onError(Exception e) {
        super.onError(e);
        e.printStackTrace();
        if (!handleCSDNResponseError(e)) {
            if (e != null && e.getMessage() != null) {
                Logger.e(e.getMessage());
            }
            onErrorMsg(ErrorMessageFactory.create(mContext,e));
        }
    }

    protected void onErrorMsg(String errorMsg){}

    protected boolean handleCSDNResponseError(Exception e) {
        if (e instanceof ResponseException) {
            ResponseException responseException = (ResponseException) e;
            switch (responseException.getStatusCode()) {
                case ResponseException.CODE_UNAUTHORIZED:
                    mNavigator.navigateToLogin(mContext);
                    return true;
            }
        }
        return false;
    }


}
