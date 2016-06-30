package wang.mogujun.csdnplus.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.view.LayoutInflaterCompat;

import com.mikepenz.iconics.context.IconicsLayoutInflater;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.di.component.ApplicationComponent;
import wang.mogujun.csdnplus.di.module.ActivityModule;
import wang.mogujun.ext.utils.TipUtils;
import wang.mogujun.uiframework.CommonActivity;

/**
 * Created by WangJun on 2016/6/7.
 */
public abstract class BaseActivity extends CommonActivity{

    private ActivityModule mActivityModule;

    @Inject
    protected CSDNNavigator mNavigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //TODO 每个Activity都需要这么做么？会不会对性能有影响？
        LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        getApplicationComponent().inject(this);
        ButterKnife.bind(this);
        initViews();
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((CSDNApplication) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        if (this.mActivityModule == null) {
            this.mActivityModule = new ActivityModule(this);
        }
        return this.mActivityModule;
    }



    protected void initViews(){}

    @LayoutRes
    protected abstract int getContentViewId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected EventBus getEventBus(){
        return getApplicationComponent().eventBus();
    }

    protected void showToast(String msg){
        TipUtils.showToast(this, msg);
    }

    protected void showToast(@StringRes int resId){
        TipUtils.showToast(this, resId);
    }

    protected void showSnack(String msg){
        TipUtils.showSnack(this, msg);
    }

    protected void showSnack(@StringRes int resId){
        TipUtils.showSnack(this, getString(resId));
    }

}
