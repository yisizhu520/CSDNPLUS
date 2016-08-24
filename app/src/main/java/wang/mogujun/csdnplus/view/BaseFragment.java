package wang.mogujun.csdnplus.view;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.di.component.ApplicationComponent;
import wang.mogujun.csdnplus.exception.ErrorMessageFactory;
import wang.mogujun.ext.utils.TipUtils;
import wang.mogujun.uiframework.CommonFragment;

/**
 * Created by WangJun on 2016/6/7.
 */
public abstract class BaseFragment extends CommonFragment {

    protected View rootView;


    private Unbinder unbinder;

    @Inject
    protected CSDNNavigator mNavigator;

    protected void initViews(){}

    protected abstract @LayoutRes int getContentViewId();

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
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();

    }

    @Override
    public void onDestroyView() {
        unbinder.unbind();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public EventBus getEventBus() {
        return getApplicationComponent().eventBus();
    }

    public String getErrorMessage(Exception e){
        return ErrorMessageFactory.create(getActivity(),e);
    }

    protected void showToast(String msg){
        TipUtils.showToast(getActivity(), msg);
    }

    protected void showToast(@StringRes int resId){
        TipUtils.showToast(getActivity(), resId);
    }

    protected void showSnack(String msg){
        TipUtils.showSnack(getActivity(), msg);
    }

    protected void showSnack(@StringRes int resId){
        TipUtils.showSnack(getActivity(), getString(resId));
    }


}
