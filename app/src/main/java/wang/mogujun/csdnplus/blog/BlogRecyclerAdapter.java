package wang.mogujun.csdnplus.blog;

import android.support.annotation.NonNull;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.blog.domain.model.BlogRecommendListInfo;
import wang.mogujun.csdnplus.utils.GlideUtils;
import wang.mogujun.ext.utils.DateUtils;

/**
 * Created by WangJun on 2016/8/28.
 */
public class BlogRecyclerAdapter extends BaseQuickAdapter<BlogRecommendListInfo> {

    private BlogItemClickListener mBlogItemClickListener;

    public interface BlogItemClickListener {

        void onContentClick(View view, BlogRecommendListInfo item);

        void onAvatarClick(View v, BlogRecommendListInfo item);
    }

    public BlogRecyclerAdapter(List<BlogRecommendListInfo> data, @NonNull BlogItemClickListener listener) {
        super(R.layout.news_common_list_item, data);
        mBlogItemClickListener = listener;
        //TODO 绑定到每一个条目岂不是更统一？
        setOnRecyclerViewItemClickListener((view, i) -> mBlogItemClickListener.onContentClick(view, mData.get(i)));
        this.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
    }

    @Override
    protected void convert(BaseViewHolder holder, BlogRecommendListInfo item) {
        //TODO 可以改成新闻时间轴的形式
        holder.setText(R.id.blog_title_tv, item.getTitle())
                .setText(R.id.blog_author_tv, item.getNick_name())
                .setText(R.id.blog_date_tv, DateUtils.getFlexibleDate(item.getCreated_at()))
                .setText(R.id.blog_comment_num_tv, "评 "+item.getComments())
                .setText(R.id.blog_zan_num_tv, "赞 "+item.getUps() + "")
                .setText(R.id.blog_look_num_tv, "看 "+item.getViews() + "")
                .setOnClickListener(R.id.blog_avatar_iv, v -> mBlogItemClickListener.onAvatarClick(v, item));
        GlideUtils.displayImage(holder.getView(R.id.blog_avatar_iv), item.getPic());
    }
    
}
