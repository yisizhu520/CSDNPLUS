package wang.mogujun.csdnplus.view.geeknews;

import android.content.Context;
import android.text.TextUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsListInfo;
import wang.mogujun.csdnplus.event.NewsItemClickEvent;
import wang.mogujun.csdnplus.view.adapter.BaseRecyclerAdapter;
import wang.mogujun.csdnplus.view.adapter.RecyclerViewHolder;
import wang.mogujun.ext.utils.DateUtils;

public class NewsListAdapter extends BaseRecyclerAdapter<NewsListInfo> {


    @Inject
    EventBus eventBus;

    public NewsListAdapter(Context ctx, List<NewsListInfo> list) {
        super(ctx, list);
        CSDNApplication.getInstance().getApplicationComponent().inject(this);
    }


    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.news_common_list_item;
    }

    @Override
    public void bindData(RecyclerViewHolder holder, int position, final NewsListInfo item) {
        if(TextUtils.isEmpty(item.getPic())){
            holder.setVisible(R.id.news_title_iv,false);
        }else{
            holder.setVisible(R.id.news_title_iv,true);
            holder.setImageUrl(R.id.news_title_iv, item.getPic());
        }
        holder.setText(R.id.news_title_tv, item.getTitle())
                .setText(R.id.news_source_tv, "来自：" + item.getSource_name())
                .setText(R.id.news_author_tv, item.getNick_name())
                .setText(R.id.news_date_tv, "分享于 " + DateUtils.getFlexibleDate(item.getCreated_at()))
                .setText(R.id.news_comment_num_tv, item.getComments()+"")
                .setText(R.id.news_zan_num_tv, item.getUps()+"");
        holder.setOnClickListener(v -> eventBus.post(new NewsItemClickEvent(NewsItemClickEvent.EVENT_CONTENT_CLICK,item)));
    }

}