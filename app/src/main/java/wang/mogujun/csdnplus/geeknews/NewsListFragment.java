package wang.mogujun.csdnplus.geeknews;

import android.os.Bundle;
import android.support.annotation.Nullable;
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
import wang.mogujun.csdnplus.domain.DomainConstants;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsListInfo;
import wang.mogujun.csdnplus.event.NewsItemClickEvent;
import wang.mogujun.csdnplus.view.LazyBaseFragment;
import wang.mogujun.ext.utils.TipUtils;
import wang.mogujun.uikit.BorderDividerItemDecoration;
import wang.mogujun.uikit.loadmore.LoadMoreViewFactory;

/**
 * Created by WangJun on 2016/6/25.
 */
public class NewsListFragment extends
        LazyBaseFragment<NewsListContract.View, NewsListContract.Presenter>
        implements NewsListContract.View {

    private static final String EXTRA_COMID = "comid";

    @BindView(R.id.data_rv)
    RecyclerView mDataRv;
    @BindView(R.id.empty_layout)
    FrameLayout mEmptyLayout;
    @BindView(R.id.ptr_frame)
    PtrFrameLayout mPtrFrame;

    @BindDimen(R.dimen.spacing_small)
    int mDividerBorderWidth;

    private int mComid;

    protected NewsRecyclerAdapter mAdapter;

    public static NewsListFragment newInstance(int comid) {
        NewsListFragment fragment = new NewsListFragment();
        Bundle b = new Bundle();
        b.putInt(EXTRA_COMID, comid);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getEventBus().register(this);
        if (getArguments() != null) {
            mComid = getArguments().getInt(EXTRA_COMID);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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
        mAdapter = new NewsRecyclerAdapter(null);
        mDataRv.setAdapter(mAdapter);
        View loadMoreView = LoadMoreViewFactory.createLoadMoreView(getActivity(),1);
        mAdapter.setLoadingView(loadMoreView);
        mAdapter.openLoadMore(DomainConstants.DEFAULT_PAGE_SIZE, true);
        mAdapter.setOnLoadMoreListener(() -> presenter.loadMoreData());
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
    public NewsListContract.Presenter createPresenter() {
        return new NewsListPresenter(mComid);
    }

    @Subscribe
    public void onNewsItemClickEvent(NewsItemClickEvent event) {
        NewsListInfo item = event.item;
        switch (event.type) {
            case NewsItemClickEvent.EVENT_CONTENT_CLICK:
                showToast("点击了:" + item.getTitle());
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
    public void showNewData(List<NewsListInfo> data) {
        mAdapter.setNewData(data);
        mAdapter.openLoadMore(data.size(),true);
    }

    @Override
    public void showNewDataError(String msg) {
        TipUtils.showSnack(getActivity(), msg);
    }

    @Override
    public void showMoreData(List<NewsListInfo> data) {
        mAdapter.notifyDataChangedAfterLoadMore(data, true);
    }

    @Override
    public void showMoreDataError(String msg) {
        TipUtils.showSnack(getActivity(), msg);
//        TextView tv = new TextView(getActivity());
//        tv.setTextColor(Color.BLACK);
//        tv.setText("加载更多失败了");
//        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT, DimenUtils.dp2px(getActivity(),48));
//        tv.setLayoutParams(lp);
//        mAdapter.addFooterView(tv);
        mAdapter.notifyDataChangedAfterLoadMore(true);
    }

    @Override
    public void showNoMoreData() {
        TipUtils.showToast(getActivity(), "厉害厉害，都被你看光了，满足了吧o(*￣︶￣*)o");
        mAdapter.notifyDataChangedAfterLoadMore(false);
    }

    @Override
    public void showEmptyView() {
        mEmptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyView() {
        mEmptyLayout.setVisibility(View.GONE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getEventBus().register(this);
    }
}
