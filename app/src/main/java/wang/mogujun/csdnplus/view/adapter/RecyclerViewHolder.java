package wang.mogujun.csdnplus.view.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import wang.mogujun.csdnplus.utils.GlideUtils;


/**
 * Created by WangJun on 2016/3/5.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    /** Views indexed with their IDs */
    private final SparseArray<View> views;

    private final Context context;

    private View convertView;


    public RecyclerViewHolder(Context ctx, View itemView) {
        super(itemView);
        context = ctx;
        views = new SparseArray<View>();
        convertView = itemView;
    }

    /**
     * This method allows you to retrieve a view and perform custom
     * operations on it, not covered by the RecyclerViewHolder.<br/>
     * If you think it's a common use case, please consider creating
     * a new issue at https://github.com/JoanZapata/base-adapter-helper/issues.
     * @param viewId The id of the view you want to retrieve.
     */
    public <T extends View> T getView(int viewId) {
        return retrieveView(viewId);
    }

    /**
     * Will set the text of a TextView.
     * @param viewId The view id.
     * @param value  The text to put in the text view.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setText(int viewId, String value) {
        TextView view = retrieveView(viewId);
        view.setText(value);
        return this;
    }

    /**
     * Will set the image of an ImageView from a resource id.
     * @param viewId     The view id.
     * @param imageResId The image resource id.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setImageResource(int viewId, int imageResId) {
        ImageView view = retrieveView(viewId);
        view.setImageResource(imageResId);
        return this;
    }

    /**
     * Will set background color of a view.
     * @param viewId The view id.
     * @param color  A color, not a resource id.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setBackgroundColor(int viewId, int color) {
        View view = retrieveView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    /**
     * Will set background of a view.
     * @param viewId        The view id.
     * @param backgroundRes A resource to use as a background.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setBackgroundRes(int viewId, int backgroundRes) {
        View view = retrieveView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    /**
     * Will set text color of a TextView.
     * @param viewId    The view id.
     * @param textColor The text color (not a resource id).
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setTextColor(int viewId, int textColor) {
        TextView view = retrieveView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    /**
     * Will set text color of a TextView.
     * @param viewId       The view id.
     * @param textColorRes The text color resource id.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setTextColorRes(int viewId, int textColorRes) {
        TextView view = retrieveView(viewId);
        view.setTextColor(context.getResources().getColor(textColorRes));
        return this;
    }

    /**
     * Will set the image of an ImageView from a drawable.
     * @param viewId   The view id.
     * @param drawable The image drawable.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = retrieveView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    /**
     * Will download an image from a URL and put it in an ImageView.<br/>
     * It uses Square's Picasso library to download the image asynchronously and put the result into the ImageView.<br/>
     * Picasso manages recycling of views in a ListView.<br/>
     * If you need more control over the Picasso settings, use {RecyclerViewHolder#setImageBuilder}.
     * @param viewId   The view id.
     * @param imageUrl The image URL.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setImageUrl(int viewId, String imageUrl) {
        ImageView view = retrieveView(viewId);
        //TODO 定义自己的网络图片加载方式
        GlideUtils.displayImage(view,imageUrl);
        return this;
    }

    /**
     * Will download an image from a URL and put it in an ImageView.<br/>
     * @param viewId         The view id.
     * @param requestBuilder The Picasso request builder. (e.g. Picasso.with(context).load(imageUrl))
     * @return The RecyclerViewHolder for chaining.
     */
//    public RecyclerViewHolder setImageBuilder(int viewId, RequestCreator requestBuilder) {
//        ImageView view = retrieveView(viewId);
//        requestBuilder.into(view);
//        return this;
//    }

    /** Add an action to set the image of an image view. Can be called multiple times. */
    public RecyclerViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = retrieveView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    /**
     * Add an action to set the alpha of a view. Can be called multiple times.
     * Alpha between 0-1.
     */
    public RecyclerViewHolder setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            retrieveView(viewId).setAlpha(value);
        } else {
            // Pre-honeycomb hack to set Alpha value
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0);
            alpha.setFillAfter(true);
            retrieveView(viewId).startAnimation(alpha);
        }
        return this;
    }

    /**
     * Set a view visibility to VISIBLE (true) or GONE (false).
     * @param viewId  The view id.
     * @param visible True for VISIBLE, false for GONE.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setVisible(int viewId, boolean visible) {
        View view = retrieveView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    /**
     * Add links into a TextView.
     * @param viewId The id of the TextView to linkify.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder linkify(int viewId) {
        TextView view = retrieveView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    /** Apply the typeface to the given viewId, and enable subpixel rendering. */
    public RecyclerViewHolder setTypeface(int viewId, Typeface typeface) {
        TextView view = retrieveView(viewId);
        view.setTypeface(typeface);
        view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        return this;
    }

    /** Apply the typeface to all the given viewIds, and enable subpixel rendering. */
    public RecyclerViewHolder setTypeface(Typeface typeface, int... viewIds) {
        for (int viewId : viewIds) {
            TextView view = retrieveView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
        }
        return this;
    }

    /**
     * Sets the progress of a ProgressBar.
     * @param viewId   The view id.
     * @param progress The progress.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setProgress(int viewId, int progress) {
        ProgressBar view = retrieveView(viewId);
        view.setProgress(progress);
        return this;
    }

    /**
     * Sets the progress and max of a ProgressBar.
     * @param viewId   The view id.
     * @param progress The progress.
     * @param max      The max value of a ProgressBar.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setProgress(int viewId, int progress, int max) {
        ProgressBar view = retrieveView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    /**
     * Sets the range of a ProgressBar to 0...max.
     * @param viewId The view id.
     * @param max    The max value of a ProgressBar.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setMax(int viewId, int max) {
        ProgressBar view = retrieveView(viewId);
        view.setMax(max);
        return this;
    }

    /**
     * Sets the rating (the number of stars filled) of a RatingBar.
     * @param viewId The view id.
     * @param rating The rating.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setRating(int viewId, float rating) {
        RatingBar view = retrieveView(viewId);
        view.setRating(rating);
        return this;
    }

    /**
     * Sets the rating (the number of stars filled) and max of a RatingBar.
     * @param viewId The view id.
     * @param rating The rating.
     * @param max    The range of the RatingBar to 0...max.
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setRating(int viewId, float rating, int max) {
        RatingBar view = retrieveView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    /**
     * Sets the on click listener of the view.
     * @param viewId   The view id.
     * @param listener The on click listener;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = retrieveView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    /**
     * Sets the on click listener of the view.
     * @param listener The on click listener;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setOnClickListener(View.OnClickListener listener) {
        convertView.setOnClickListener(listener);
        return this;
    }

    /**
     * Sets the on touch listener of the view.
     * @param viewId   The view id.
     * @param listener The on touch listener;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View view = retrieveView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    /**
     * Sets the on long click listener of the view.
     * @param viewId   The view id.
     * @param listener The on long click listener;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = retrieveView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

    /**
     * Sets the listview or gridview's item click listener of the view
     * @param viewId  The view id.
     * @param listener The item on click listener;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setOnItemClickListener(int viewId, AdapterView.OnItemClickListener listener) {
        AdapterView view = retrieveView(viewId);
        view.setOnItemClickListener(listener);
        return this;
    }

    /**
     * Sets the listview or gridview's item long click listener of the view
     * @param viewId The view id.
     * @param listener   The item long click listener;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setOnItemLongClickListener(int viewId, AdapterView.OnItemLongClickListener listener) {
        AdapterView view = retrieveView(viewId);
        view.setOnItemLongClickListener(listener);
        return this;
    }
    /**
     * Sets the listview or gridview's item selected click listener of the view
     * @param viewId The view id.
     * @param listener The item selected click listener;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setOnItemSelectedClickListener(int viewId, AdapterView.OnItemSelectedListener listener) {
        AdapterView view = retrieveView(viewId);
        view.setOnItemSelectedListener(listener);
        return this;
    }
    /**
     * Sets the tag of the view.
     * @param viewId The view id.
     * @param tag    The tag;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setTag(int viewId, Object tag) {
        View view = retrieveView(viewId);
        view.setTag(tag);
        return this;
    }

    /**
     * Sets the tag of the view.
     * @param viewId The view id.
     * @param key    The key of tag;
     * @param tag    The tag;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setTag(int viewId, int key, Object tag) {
        View view = retrieveView(viewId);
        view.setTag(key, tag);
        return this;
    }

    /**
     * Sets the checked status of a checkable.
     * @param viewId  The view id.
     * @param checked The checked status;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setChecked(int viewId, boolean checked) {
        Checkable view = (Checkable) retrieveView(viewId);
        view.setChecked(checked);
        return this;
    }

    /**
     * Sets the adapter of a adapter view.
     * @param viewId  The view id.
     * @param adapter The adapter;
     * @return The RecyclerViewHolder for chaining.
     */
    public RecyclerViewHolder setAdapter(int viewId, Adapter adapter) {
        AdapterView view = retrieveView(viewId);
        view.setAdapter(adapter);
        return this;
    }

    /** Retrieve the convertView */
    public View getView() {
        return convertView;
    }


    @SuppressWarnings("unchecked")
    protected <T extends View> T retrieveView(int viewId) {
        View view = views.get(viewId);
        if (view == null) {
            view = convertView.findViewById(viewId);
            views.put(viewId, view);
        }
        return (T) view;
    }

}
