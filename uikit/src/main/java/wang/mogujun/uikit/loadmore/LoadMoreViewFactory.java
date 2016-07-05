package wang.mogujun.uikit.loadmore;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import wang.mogujun.uikit.R;

/**
 * Created by WangJun on 2016/7/5.
 */
public class LoadMoreViewFactory {

    public static final int TYPE_NORMAL_CIRCLE = 1;
    public static final int TYPE_3D_CIRCLE = 2;
    public static final int TYPE_HORIZONTAL_SMOOTH = 3;

    public static View createLoadMoreView(Context context) {
        return createLoadMoreView(context, TYPE_HORIZONTAL_SMOOTH);
    }

    public static View createLoadMoreView(Context context, int type) {
        View view;
        switch (type) {
            case TYPE_NORMAL_CIRCLE:
                view = View.inflate(context, R.layout.load_more_normal_circle, null);
                break;
            case TYPE_3D_CIRCLE:
                view = View.inflate(context, R.layout.load_more_3d_circle, null);
                break;
            default:
            case TYPE_HORIZONTAL_SMOOTH:
                view = View.inflate(context, R.layout.load_more_smooth, null);
                break;
        }
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return view;
    }


}
