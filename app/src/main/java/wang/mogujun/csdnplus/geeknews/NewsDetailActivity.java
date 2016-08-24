package wang.mogujun.csdnplus.geeknews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.event.DetailMenuClickEvent;
import wang.mogujun.csdnplus.event.DetailMenuToggleEvent;
import wang.mogujun.csdnplus.view.BaseActivity;
import wang.mogujun.uikit.SwipeBackLayout;

public class NewsDetailActivity extends BaseActivity {

    @BindView(R.id.swipeBackLayout)
    SwipeBackLayout mSwipeBackLayout;
    @BindView(R.id.drawerLayout)
    DrawerLayout mDrawerLayout;

    public static final String EXTRA_USERNAME = "username";
    public static final String EXTRA_ARTICLEID = "articleId";
    public static final String EXTRA_URL = "url";
    public static final String EXTRA_TYPE = "type";

    public static void showDetail(Context context, String username, int articleId, String url, String type) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(EXTRA_USERNAME, username);
        intent.putExtra(EXTRA_ARTICLEID, articleId);
        intent.putExtra(EXTRA_URL, url);
        intent.putExtra(EXTRA_TYPE, type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO 可以将swipeBack这个功能抽取到它的类里，使用attach来绑定activity
        mSwipeBackLayout.setCallBack(this::finish);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.news_detail_act;
    }


    @Override
    protected void initViews() {
        super.initViews();
        //StatusBarUtil.setTranslucentForDrawerLayout(this,mDrawerLayout);
        String username = getIntent().getStringExtra(EXTRA_USERNAME);
        int articleId = getIntent().getIntExtra(EXTRA_ARTICLEID, -1);
        String url = getIntent().getStringExtra(EXTRA_URL);
        String type = getIntent().getStringExtra(EXTRA_TYPE);
        NewsDetailFragment detailFragment = NewsDetailFragment
                .newInstance(username,articleId,url,type);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentContainer, detailFragment)
                .commit();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.menuContainer, new DetailMenuFragment())
                .commit();
    }

    @Subscribe
    void closeDetailMenu(DetailMenuClickEvent event) {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            mDrawerLayout.closeDrawer(GravityCompat.END);
        }
    }

    @Subscribe
    public void toggleMenu(DetailMenuToggleEvent event) {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            mDrawerLayout.closeDrawer(GravityCompat.END);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.END);
        }
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.END)) {
            mDrawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }
}
