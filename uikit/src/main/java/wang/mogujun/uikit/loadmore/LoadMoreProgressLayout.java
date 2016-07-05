package wang.mogujun.uikit.loadmore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by WangJun on 2016/7/5.
 */
public class LoadMoreProgressLayout extends FrameLayout {

    public static final int TYPE_NORMAL_CIRCLE = 1;
    public static final int TYPE_3D_CIRCLE = 2;
    public static final int TYPE_HORIZONTAL_SMOOTH = 3;

    private int mProgressType = TYPE_3D_CIRCLE;

    public LoadMoreProgressLayout(Context context) {
        this(context, null);
    }

    public LoadMoreProgressLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoadMoreProgressLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        View progressView = null;
        switch (mProgressType){
            case TYPE_NORMAL_CIRCLE:
                //progressView = new SmoothProgressBar
                break;
            case TYPE_3D_CIRCLE:

                break;
            case TYPE_HORIZONTAL_SMOOTH:

                break;
        }
        //addView();
    }


}
