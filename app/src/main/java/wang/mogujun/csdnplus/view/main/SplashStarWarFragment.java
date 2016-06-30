package wang.mogujun.csdnplus.view.main;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

import butterknife.BindString;
import butterknife.BindView;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.event.SplashFinishedEvent;
import wang.mogujun.csdnplus.view.BaseFragment;
import wang.mogujun.uikit.particle.ParticleSystemRenderer;
import wang.mogujun.uikit.trendtextview.TrendTextView;
import wang.mogujun.uikit.trendtextview.TrendTextViewListener;

/**
 * Created by WangJun on 2016/3/29.
 */
public class SplashStarWarFragment extends BaseFragment implements TrendTextViewListener {

    @BindView(R.id.splash_starwar_bg)
    GLSurfaceView mStarWarView;
    @BindView(R.id.splash_starwar_bg_black)
    View mBlackView;
    @BindView(R.id.splash_starwar_title)
    HTextView mTitleTV;
    @BindView(R.id.splash_starwar_slogan)
    TrendTextView mSloganTV;

    @BindString(R.string.csdn)
    String mCSDNStr;
    @BindString(R.string.slogan)
    String mSloganStr;

    public static SplashStarWarFragment newInstance() {
        SplashStarWarFragment sf = new SplashStarWarFragment();
        return sf;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getEventBus().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //getEventBus().unregister(this);
    }

    @Override
    protected void initViews() {
        initBG();
        mSloganTV.animateText(mSloganStr);
        //FIXME 会出现内存泄漏的情况
        mSloganTV.setOnTrendTextFinishListener(this);
    }

    @Override
    public void onFinished() {
        mTitleTV.setAnimateType(HTextViewType.LINE);
        mTitleTV.animateText(mCSDNStr); // animate
        getEventBus().post(new SplashFinishedEvent());
    }

    @Override
    public void onResume() {
        super.onResume();
        mStarWarView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mStarWarView.onPause();
    }

    private void initBG() {
        // Check if the system supports OpenGL ES 2.0.
        final ActivityManager activityManager = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
        final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

        if (supportsEs2) {
            // Request an OpenGL ES 2.0 compatible context.
            mStarWarView.setEGLContextClientVersion(2);

            // Set the renderer to our demo renderer, defined below.
            ParticleSystemRenderer mRenderer = new ParticleSystemRenderer(mStarWarView);
            mStarWarView.setRenderer(mRenderer);
            mStarWarView.setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
        } else {
            mBlackView.setVisibility(View.VISIBLE);
            mStarWarView.setVisibility(View.GONE);
            //throw new UnsupportedOperationException();
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.splash_starwar_frag;
    }

}
