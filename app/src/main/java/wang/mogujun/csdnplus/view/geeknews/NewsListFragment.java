package wang.mogujun.csdnplus.view.geeknews;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.List;

import wang.mogujun.csdnplus.domain.model.geeknews.NewsListInfo;
import wang.mogujun.csdnplus.view.LazyBaseFragment;

/**
 * Created by WangJun on 2016/6/25.
 */
public class NewsListFragment extends
        LazyBaseFragment<NewsListContract.View, NewsListContract.Presenter>
        implements NewsListContract.View {

    private static final String EXTRA_COMID = "comid";

    private int mComid;

    public static NewsListFragment newInstance(int comid) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle b = new Bundle();
        b.putInt(EXTRA_COMID, comid);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public NewsListContract.Presenter createPresenter() {
        return null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mComid = getArguments().getInt(EXTRA_COMID);
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentViewId() {
        return 0;
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showNewData(List<NewsListInfo> data) {

    }

    @Override
    public void showNewDataError(String msg) {

    }

    @Override
    public void showMoreData(List<NewsListInfo> data) {

    }

    @Override
    public void showMoreDataError(String msg) {

    }

    @Override
    public void showNoMoreData() {

    }
}