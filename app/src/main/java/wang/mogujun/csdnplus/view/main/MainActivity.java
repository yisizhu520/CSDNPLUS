package wang.mogujun.csdnplus.view.main;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.FrameLayout;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.blog.BlogMainFragment;
import wang.mogujun.csdnplus.di.HasNewsComponent;
import wang.mogujun.csdnplus.di.component.NewsComponent;
import wang.mogujun.csdnplus.event.DrawerItemClickEvent;
import wang.mogujun.csdnplus.view.BaseActivity;
import wang.mogujun.csdnplus.geeknews.NewsMainFragment;

public class MainActivity extends BaseActivity implements HasNewsComponent{

    @BindView(R.id.main_content_container)
    FrameLayout mMainContentContainer;
    @BindView(R.id.main_menu_container)
    FrameLayout mMainMenuContainer;
    @BindView(R.id.main_drawerLayout)
    DrawerLayout mMainDrawerLayout;

    ActionBarDrawerToggle mDrawerToggle;

    Fragment mHeadlineFrag;
    Fragment mBlogFrag;
    Fragment mAskFrag;
    Fragment mForumFrag;
    Fragment mProfileFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getEventBus().register(this);
    }

    @Override
    protected void initViews() {
        //TODO 无法实现透明状态栏，toolbar会被遮盖住
        //StatusBarUtil.setTranslucentForDrawerLayout(MainActivity.this, mDrawerLayout, 127);
        //StatusBarUtil.setTranslucentForDrawerLayout(this,mDrawerLayout);
        //这个类可以方便的将 DrawerLayout，appbar绑定在一起，自动添加一个汉堡按钮，并且打开关闭时带有动画显示
        mDrawerToggle = new ActionBarDrawerToggle(
                this, mMainDrawerLayout, R.string.app_name, R.string.app_name);
        //设置监听器为toggle
        mMainDrawerLayout.addDrawerListener(mDrawerToggle);
        //启动绑定！
        mDrawerToggle.syncState();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_menu_container, MainMenuFragment.newInstance())
                .commit();
        //TODO 根据配置或者上一次关闭的位置打开
        replaceFragment(0);
    }

    public void toggleMenu() {
        if (mMainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mMainDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mMainDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Subscribe
    public void OnDrawerItemClick(DrawerItemClickEvent event) {
        int selectedIndex = event.getSelectedIndex();
        replaceFragment(selectedIndex);
        toggleMenu();

    }

    private void replaceFragment(int selectedIndex) {
        //TODO 这样写肯定不合适，需要重构
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (mHeadlineFrag != null) {
            ft.hide(mHeadlineFrag);
        }
        if (mBlogFrag != null) {
            ft.hide(mBlogFrag);
        }
        if (mAskFrag != null) {
            ft.hide(mAskFrag);
        }
        if (mForumFrag != null) {
            ft.hide(mForumFrag);
        }
        if (mProfileFrag != null) {
            ft.hide(mProfileFrag);
        }
        switch (selectedIndex) {
            case 0:
                if (mHeadlineFrag == null) {
                    mHeadlineFrag = NewsMainFragment.newInstance();
                    ft.add(R.id.main_content_container, mHeadlineFrag);
                } else {
                    ft.show(mHeadlineFrag);
                }
                break;
            case 1:
                if (mBlogFrag == null) {
                    mBlogFrag = BlogMainFragment.newInstance();
                    ft.add(R.id.main_content_container, mBlogFrag);
                } else {
                    ft.show(mBlogFrag);
                }
                break;
            case 2:
                if (mAskFrag == null) {
                    mAskFrag = NewsMainFragment.newInstance();
                    ft.add(R.id.main_content_container, mAskFrag);
                } else {
                    ft.show(mAskFrag);
                }
                break;
            case 3:
                if (mForumFrag == null) {
                    mForumFrag = NewsMainFragment.newInstance();
                    ft.add(R.id.main_content_container, mForumFrag);
                } else {
                    ft.show(mForumFrag);
                }
                break;
            case 4:
                if (mProfileFrag == null) {
                    mProfileFrag = NewsMainFragment.newInstance();
                    ft.add(R.id.main_content_container, mProfileFrag);
                } else {
                    ft.show(mProfileFrag);
                }
                break;
        }
        ft.commit();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.main_act;
    }

    @Override
    public void onBackPressed() {
        if (mMainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mMainDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }


    @Override
    public NewsComponent getNewsComponent() {
        return null;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        getEventBus().unregister(this);
    }
}
