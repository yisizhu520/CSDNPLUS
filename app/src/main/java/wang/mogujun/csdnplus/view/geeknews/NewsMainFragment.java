package wang.mogujun.csdnplus.view.geeknews;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;
import com.orhanobut.logger.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsColumn;
import wang.mogujun.csdnplus.event.HeadlineTabReselectedEvent;
import wang.mogujun.csdnplus.view.MvpBaseFragment;
import wang.mogujun.csdnplus.view.main.MainActivity;
import wang.mogujun.ext.utils.TipUtils;

/**
 * Created by WangJun on 2016/4/10.
 */
public class NewsMainFragment extends
        MvpBaseFragment<NewsMainContract.View, NewsMainContract.Presenter>
        implements NewsMainContract.View {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tablayout)
    TabLayout mTabLayout;
    @BindView(R.id.loading_view)
    View mLoadingView;

    NewsPagerAdapter mPagerAdapter;

    private Map<Integer, Fragment> mFragmentMap = new HashMap<>();


    private Fragment getFragment(int position) {
        Fragment f = mFragmentMap.get(position);
        if (f == null) {
            if (position == 0) {
                f = NewsLatestListFragment.newInstance();
            } else {
                int comid = mPagerAdapter.getColumns().get(position).getId();
                f = NewsListFragment.newInstance(comid);
            }
            mFragmentMap.put(position, f);
        }
        return f;

    }

    public static Fragment newInstance() {
        return new NewsMainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mToolbar.setTitle(R.string.geeknews);
        Drawable menuDra = new IconicsDrawable(getActivity())
                //TODO 主题相关
                .color(Color.WHITE)
                .icon(MaterialDesignIconic.Icon.gmi_menu)
                .sizeRes(R.dimen.nav_icon_size);
        mToolbar.setNavigationIcon(menuDra);
        mToolbar.setNavigationOnClickListener(v -> {
            //FIXME 改成eventbus传输
            ((MainActivity) getActivity()).toggleMenu();
        });
        presenter.getNewsColumns();
    }


    @Override
    protected int getContentViewId() {
        return R.layout.news_main_frag;
    }

    @NonNull
    @Override
    public NewsMainPresenter createPresenter() {
        return new NewsMainPresenter();
    }

    public void showLoading() {
        mLoadingView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingView.setVisibility(View.GONE);
    }

    public void showError(String msg) {
//        mLoadingView.setVisibility(View.GONE);
        TipUtils.showSnack(getActivity(), msg);
    }

    public void showNewsColumns(List<NewsColumn> columns) {
        //TODO 引导视图：告诉别人可以点击头部返回顶部
        mLoadingView.setVisibility(View.GONE);
        mPagerAdapter = new NewsPagerAdapter(getChildFragmentManager(), columns);
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOffscreenPageLimit(columns.size());
        mTabLayout.setupWithViewPager(mViewPager);
        //google这样设置不太合适，会覆盖掉自己的回调
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                Logger.i("onTabSelected--%s ", tab.getText());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Logger.i("onTabUnselected--%s ", tab.getText());
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Logger.i("onTabReselected--%s ", tab.getText());
                //最新头条 将id设为0
                int commid = tab.getPosition() == 0 ? 0 : mPagerAdapter.getColumns().get(tab.getPosition()).getId();
                getEventBus().post(new HeadlineTabReselectedEvent(commid));
            }
        });
    }


    class NewsPagerAdapter extends FragmentPagerAdapter {

        List<NewsColumn> columns;

        public List<NewsColumn> getColumns() {
            return columns;
        }

        public NewsPagerAdapter(FragmentManager fm, List<NewsColumn> columns) {
            super(fm);
            this.columns = columns;
        }

        @Override
        public Fragment getItem(int position) {
            return getFragment(position);
        }

        @Override
        public int getCount() {
            return columns.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return columns.get(position).getName();
        }
    }

}
