package wang.mogujun.csdnplus.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.di.component.ApplicationComponent;
import wang.mogujun.uiframework.CommonFragment;

/**
 * Created by WangJun on 2016/6/7.
 */
public abstract class BaseFragment extends CommonFragment {

    protected View rootView;

    private Unbinder unbinder;

    protected abstract void initViews() ;

    protected abstract int getContentViewId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((CSDNApplication) getActivity().getApplication()).getApplicationComponent();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getContentViewId(),container,false);
        unbinder = ButterKnife.bind(this, rootView);
        initViews();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public EventBus getEventBus() {
        return getApplicationComponent().eventBus();
    }


}
