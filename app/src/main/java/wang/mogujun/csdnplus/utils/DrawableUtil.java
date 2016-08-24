package wang.mogujun.csdnplus.utils;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.annotation.ColorInt;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;

import wang.mogujun.csdnplus.CSDNApplication;

/**
 * Created by WangJun on 2016/4/29.
 */
public class DrawableUtil {

    /** 设置Selector。 */
    public static StateListDrawable newSelector(Drawable normal, Drawable selected) {
        StateListDrawable bg = new StateListDrawable();
//        bg.addState(new int[] { android.R.attr.state_pressed}, selected);
        bg.addState(new int[] { android.R.attr.state_selected}, selected);
//        // View.ENABLED_STATE_SET
//        bg.addState(new int[] { android.R.attr.state_enabled }, normal);
//        // View.FOCUSED_STATE_SET
//        bg.addState(new int[] { android.R.attr.state_focused }, focused);
//        // View.WINDOW_FOCUSED_STATE_SET
//        bg.addState(new int[] { android.R.attr.state_window_focused }, unable);
        // View.EMPTY_STATE_SET
        bg.addState(new int[] {}, normal);
        return bg;
    }

    public static Drawable getIconDrawable(IIcon icon, @ColorInt int colorRes, int dimenRes) {
        return new IconicsDrawable(CSDNApplication.getInstance())
                .icon(icon)
                .color(colorRes)
                .sizeDp(dimenRes);
    }



}
