package wang.mogujun.csdnplus.blog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.view.BaseFragment;

/**
 * Created by WangJun on 2016/8/28.
 */
public class BlogMainFragment extends BaseFragment {

    @BindView(R.id.viewpager)
    ViewPager mViewPager;
    @BindView(R.id.tablayout)
    TabLayout mTabLayout;

    BlogPagerAdapter mBlogPagerAdapter;

    //TODO 定义常量字符串到xml文件里
    public static final String[] BLOG_TITLES = {"推荐","订阅","专家"};

    @Override
    protected int getContentViewId() {
        return R.layout.blog_main_frag;
    }


    public static Fragment newInstance() {
        return new BlogMainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBlogPagerAdapter = new BlogPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mBlogPagerAdapter);
        mViewPager.setOffscreenPageLimit(BLOG_TITLES.length);
        mTabLayout.setupWithViewPager(mViewPager);
        //google这样设置不太合适，会覆盖掉自己的回调
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Logger.i("blog list onTabReselected--%s ", tab.getText());
                //TODO 点击标题应该回到列表头部，或者用个floatActionButton
//                getEventBus().post(new HeadlineTabReselectedEvent(commid));
            }
        });
    }

    static class BlogPagerAdapter extends FragmentPagerAdapter {


        public BlogPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            switch (position){
                case 0:
                    f = new BlogRecommendListFragment();
                    break;
                case 1:
                    //TODO 记得修改
                    f = new BlogRecommendListFragment();
                    break;
                case 2:
                    f = new BlogRecommendListFragment();
                    break;
            }
            return f;
        }

        @Override
        public int getCount() {
            return BLOG_TITLES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return BLOG_TITLES[position];
        }
    }







}
