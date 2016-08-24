package wang.mogujun.csdnplus.geeknews;

import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.geeknews.domain.model.CommentInfoBean;
import wang.mogujun.csdnplus.utils.GlideUtils;
import wang.mogujun.csdnplus.view.adapter.BaseRecyclerAdapter;
import wang.mogujun.csdnplus.view.adapter.RecyclerViewHolder;
import wang.mogujun.csdnplus.widget.CSDNWebView;
import wang.mogujun.ext.utils.DateUtils;

/**
 * Created by WangJun on 2016/4/27.
 */
public class HeadlineCommentAdapter extends BaseRecyclerAdapter<CommentInfoBean.Comment> {

    public HeadlineCommentAdapter(Context ctx, List<CommentInfoBean.Comment> list) {
        super(ctx, list);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item_headline_comment;
    }

    @Override
    public void bindData(RecyclerViewHolder holder, int position, CommentInfoBean.Comment item) {
        GlideUtils.displayCircleAvatar((ImageView) holder.getView(R.id.avatarIV), item.getAvatar());
        holder.setText(R.id.nameTV, item.getUsername())
                .setText(R.id.timeTV, DateUtils.getFlexibleDate(item.getTimestamp()));
        CSDNWebView contentWV = holder.getView(R.id.contentWV);
        TextView contentTV = holder.getView(R.id.contentTV);
        //对评论内容显示布局做优化
        if(item.getBody().contains("<img") || item.getBody().contains("<p")){
            contentTV.setVisibility(View.GONE);
            contentWV.setVisibility(View.VISIBLE);
            contentWV.loadDataWithWrap(item.getBody(),1);
        }else{
            contentTV.setVisibility(View.VISIBLE);
            contentWV.setVisibility(View.GONE);
            //如果有<p>标签的，会额外空一行
            contentTV.setText(Html.fromHtml(item.getBody()));
            //contentTV.setText(item.getBody());
        }

    }
}
