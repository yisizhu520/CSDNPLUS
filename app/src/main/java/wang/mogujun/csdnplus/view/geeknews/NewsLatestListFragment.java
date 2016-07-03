package wang.mogujun.csdnplus.view.geeknews;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindDimen;
import butterknife.BindView;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.StoreHouseHeader;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsLatestListInfo;
import wang.mogujun.csdnplus.event.NewsItemClickEvent;
import wang.mogujun.csdnplus.view.LazyBaseFragment;
import wang.mogujun.ext.utils.TipUtils;
import wang.mogujun.uikit.BorderDividerItemDecoration;

/**
 * Created by WangJun on 2016/6/25.
 */
public class NewsLatestListFragment extends
        LazyBaseFragment<NewsLatestListContract.View, NewsLatestListContract.Presenter>
        implements NewsLatestListContract.View {

    @BindView(R.id.data_rv)
    RecyclerView mDataRv;
    @BindView(R.id.empty_layout)
    FrameLayout mEmptyLayout;
    @BindView(R.id.ptr_frame)
    PtrFrameLayout mPtrFrame;

    @BindDimen(R.dimen.spacing_small)
    int mDividerBorderWidth;

    NewsLatestAdapter mAdapter;

    public static NewsLatestListFragment newInstance() {
        return new NewsLatestListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews() {

        initRefreshView();
        initListView();
    }

    private void initRefreshView() {
        final StoreHouseHeader header = new StoreHouseHeader(getActivity());
        //header.setBackgroundColor(Color.BLACK);
        header.setPadding(0, mDividerBorderWidth, 0, mDividerBorderWidth);
        header.initWithString(getString(R.string.app_name));
        mPtrFrame.setHeaderView(header);
        mPtrFrame.addPtrUIHandler(header);
        mPtrFrame.setPtrHandler(new PtrHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                presenter.loadNewData();
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, mDataRv, header);
            }
        });
    }

    private void initListView() {
        mDataRv.addItemDecoration(
                new BorderDividerItemDecoration(mDividerBorderWidth,
                        mDividerBorderWidth));
        mDataRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new NewsLatestAdapter(getActivity(),null);
        mDataRv.setAdapter(mAdapter);
        mDataRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        //TODO 需要抽取到GlideUtil类的方法里么
                        Glide.with(getActivity()).resumeRequests();
                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        Glide.with(getActivity()).pauseRequests();
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        Glide.with(getActivity()).pauseRequests();
                        break;

                }
            }
        });
    }


    @Override
    public void onFirstUserVisible() {
        super.onFirstUserVisible();
        mPtrFrame.post(() -> mPtrFrame.autoRefresh());
    }

    @Override
    protected int getContentViewId() {
        return R.layout.layout_common_refresh_list;
    }

    @Override
    public NewsLatestListContract.Presenter createPresenter() {
        return new NewsLatestPresenter();
    }

    @Subscribe
    public void onNewsItemClickEvent(NewsItemClickEvent event){
        NewsLatestListInfo item = event.item;
        switch (event.type){
            case NewsItemClickEvent.EVENT_CONTENT_CLICK:
                showToast("点击了:"+item.getTitle());
                break;
        }

    }

    @Override
    public void showLoading() {
        //TODO 需要区分自动下拉刷新与加载loadingView的情况么
    }

    @Override
    public void hideLoading() {
        mPtrFrame.refreshComplete();
    }

    @Override
    public void showNewData(List<NewsLatestListInfo> data) {
        mAdapter.setData(data);
    }

    @Override
    public void showNewDataError(String msg) {
        TipUtils.showSnack(getActivity(), msg);
    }

    @Override
    public void showMoreData(List<NewsLatestListInfo> data) {
        mAdapter.addAll(data);
    }

    @Override
    public void showMoreDataError(String msg) {
        TipUtils.showSnack(getActivity(), msg);
    }

    @Override
    public void showNoMoreData() {
        TipUtils.showToast(getActivity(),"厉害厉害，都被你看光了，满足了吧o(*￣︶￣*)o");
    }

    @Override
    public void showEmptyView() {
        mEmptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyView() {
        mEmptyLayout.setVisibility(View.GONE);
    }

}
