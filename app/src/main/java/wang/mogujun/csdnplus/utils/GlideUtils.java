package wang.mogujun.csdnplus.utils;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.orhanobut.logger.Logger;

import jp.wasabeef.glide.transformations.CropCircleTransformation;
import wang.mogujun.csdnplus.R;


/**
 * Created by WangJun on 2016/4/14.
 */
public class GlideUtils {

    //TODO 需要重构

    public static void displayImage(ImageView view, String url) {
        displayImage(view, url, R.drawable.default_news_img);
    }

    public static void displayImage(ImageView view, String url, @DrawableRes int defaultImage) {
        if (view == null) {
            Logger.e("GlideUtil -> display -> imageView is null");
            return;
        }

        try {
            Glide.with(view.getContext())
                    .load(url)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(defaultImage)
                    .error(defaultImage)
                    .crossFade()
                    .centerCrop()
                    .into(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void displayCircleAvatar(ImageView view, String url) {
        if (view == null) {
            Logger.e("GlideUtil -> display -> imageView is null");
            return;
        }

        try {
            Glide.with(view.getContext())
                    .load(url)
                    .bitmapTransform(new CropCircleTransformation(view.getContext()))
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .placeholder(R.drawable.default_avatar_img)
                    .error(R.drawable.default_avatar_img)
                    .crossFade()
                    .into(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
