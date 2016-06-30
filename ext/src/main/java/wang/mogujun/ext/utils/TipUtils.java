package wang.mogujun.ext.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

/**
 * Created by WangJun on 2016/6/21.
 */
public class TipUtils {

    private TipUtils(){}

    public static void showSnack(Activity activity, String msg){
        showSnack(activity.getWindow().getDecorView(),msg);
    }

    /**
     * 显示snackbar提示
     *
     * @param anchorView
     * @param msg
     */
    public static void showSnack(final View anchorView, String msg) {
        Snackbar.make(anchorView, msg, Snackbar.LENGTH_LONG).show();
    }


    /**
     * 显示snackbar提示，并带action操作
     *
     * @param anchorView
     * @param msg
     * @param action
     * @param listener
     */
    public static void showSnack(final View anchorView, String msg, String action, View.OnClickListener listener) {
        Snackbar.make(anchorView, msg, Snackbar.LENGTH_LONG)
                .setAction(action, listener).show();
    }



    /**
     * 显示toast提示
     *
     * @param context
     * @param msg
     */
    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }


    public static void showToast(Context context, @StringRes int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_SHORT).show();
    }

}
