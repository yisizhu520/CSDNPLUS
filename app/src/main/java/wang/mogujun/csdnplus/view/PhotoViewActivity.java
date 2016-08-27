package wang.mogujun.csdnplus.view;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.utils.GlideUtils;
import wang.mogujun.uikit.TouchImageView;

public class PhotoViewActivity extends BaseActivity {

    @BindView(R.id.photoView)
    TouchImageView mPhotoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//实现半透明状态栏
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void initViews() {
        super.initViews();
        //TODO photoview的旋转功能还是有些问题待修复
//        mPhotoView.setOnViewTapListener((view, x, y) -> finish());
//        mPhotoView.setAutoFitLongImage(false);
        mPhotoView.setOnClickListener(v -> finish());
        String imageUrl = getIntent().getStringExtra("imageUrl");
        GlideUtils.displayImage(mPhotoView,imageUrl);
        Glide.with(this)
                .load(imageUrl)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.default_news_img)
                .error(R.drawable.default_news_img)
                .crossFade()
                .into(mPhotoView);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.photo_view_act;
    }
}
