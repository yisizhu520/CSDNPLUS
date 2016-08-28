package wang.mogujun.csdnplus.geeknews;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsListInfo;
import wang.mogujun.csdnplus.utils.GlideUtils;
import wang.mogujun.ext.utils.DateUtils;

/**
 * Created by WangJun on 2016/7/5.
 */
public class NewsRecyclerAdapter extends BaseQuickAdapter<NewsListInfo> {

    private NewsItemClickListener mNewsItemClickListener;

    public interface NewsItemClickListener {

        void onContentClick(View view, NewsListInfo item);

        void onAvatarClick(View v, NewsListInfo item);
    }

    public NewsRecyclerAdapter(List<NewsListInfo> data, @NonNull NewsItemClickListener listener) {
        super(R.layout.news_common_list_item, data);
        mNewsItemClickListener = listener;
        //TODO 绑定到每一个条目岂不是更统一？
        setOnRecyclerViewItemClickListener((view, i) -> mNewsItemClickListener.onContentClick(view, mData.get(i)));
        this.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
    }

    @Override
    protected void convert(BaseViewHolder holder, NewsListInfo item) {
        holder.setText(R.id.news_title_tv, item.getTitle())
                .setText(R.id.news_source_tv, "来自：" + item.getSource_name())
                .setText(R.id.news_author_tv, item.getNick_name())
                .setText(R.id.news_date_tv, "分享于 " + DateUtils.getFlexibleDate(item.getCreated_at()))
                .setText(R.id.news_comment_num_tv, item.getComments() + "")
                .setText(R.id.news_zan_num_tv, item.getUps() + "")
                .setOnClickListener(R.id.news_title_iv, v -> mNewsItemClickListener.onAvatarClick(v, item));
        if (TextUtils.isEmpty(item.getPic())) {
            holder.setVisible(R.id.news_title_iv, false);
        } else {
            holder.setVisible(R.id.news_title_iv, true);
        }
        GlideUtils.displayImage(holder.getView(R.id.news_title_iv), item.getPic());
    }
}
