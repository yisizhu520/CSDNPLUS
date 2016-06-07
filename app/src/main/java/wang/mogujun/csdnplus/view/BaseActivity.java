package wang.mogujun.csdnplus.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.di.component.ApplicationComponent;
import wang.mogujun.csdnplus.di.module.ActivityModule;
import wang.mogujun.uiframework.CommonActivity;

/**
 * Created by WangJun on 2016/6/7.
 */
public abstract class BaseActivity extends CommonActivity{

    private ActivityModule mActivityModule;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        //LayoutInflaterCompat.setFactory(getLayoutInflater(), new IconicsLayoutInflater(getDelegate()));
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



}
