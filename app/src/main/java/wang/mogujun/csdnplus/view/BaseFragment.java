package wang.mogujun.csdnplus.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import wang.mogujun.uiframework.CommonFragment;

/**
 * Created by WangJun on 2016/6/7.
 */
public abstract class BaseFragment extends CommonFragment {

    protected View rootView;

    protected abstract void initViews() ;

    protected abstract int getContentViewId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mTaskId=getActivity().getTaskId();


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(getContentViewId(),container,false);
        ButterKnife.bind(this, rootView);
        initViews();
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
