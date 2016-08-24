package wang.mogujun.csdnplus.geeknews;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.event.DetailChangeEvent;
import wang.mogujun.csdnplus.event.DetailMenuClickEvent;
import wang.mogujun.csdnplus.view.BaseFragment;
import wang.mogujun.csdnplus.view.adapter.BaseRecyclerAdapter;
import wang.mogujun.csdnplus.view.adapter.RecyclerViewHolder;

/**
 * Created by WangJun on 2016/4/29.
 */
public class DetailMenuFragment extends BaseFragment {


    public static final int MENU_POSITION_TYPEFONT = 0;
    public static final int MENU_POSITION_NIGHTMODE = 1;
    public static final int MENU_POSITION_READSRC = 2;
    public static final int MENU_POSITION_MORETOPIC = 3;
    public static final int MENU_POSITION_SHARE = 4;
    public static final int MENU_POSITION_COLLECT = 5;

    @BindView(R.id.menuRV)
    RecyclerView mMenuRV;

    DetailMenuAdapter mDetailMenuAdapter;

    @Override
    protected void initViews() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setAutoMeasureEnabled(true);
        mMenuRV.setLayoutManager(llm);
        //TODO 加上分割线
//        mMenuRV.addItemDecoration(new HorizontalDividerItemDecoration
//                .Builder(getActivity())
//                .marginResId(R.dimen.spacing_normal)
//                .colorResId(R.color.white_light)
//                .build());

        List<DetailMenuItem> items = new ArrayList<>(5);

        items.add(new DetailMenuItem("字体大小", MaterialDesignIconic.Icon.gmi_bookmark));
        items.add(new DetailMenuItem("夜间模式", MaterialDesignIconic.Icon.gmi_brightness_2));
        items.add(new DetailMenuItem("阅读原文", MaterialDesignIconic.Icon.gmi_reader));
        items.add(new DetailMenuItem("相关专题", MaterialDesignIconic.Icon.gmi_label));
        items.add(new DetailMenuItem("分享一下", MaterialDesignIconic.Icon.gmi_share));
        items.add(new DetailMenuItem("收藏一个", MaterialDesignIconic.Icon.gmi_bookmark));
        mDetailMenuAdapter = new DetailMenuAdapter(getActivity(), items);
        mMenuRV.setAdapter(mDetailMenuAdapter);
    }

    @Subscribe
    void changeMenuState(DetailChangeEvent event) {

        switch (event.getEventType()) {
            case DetailChangeEvent.EVENT_NIGHT_MODE:
                if (event.getEventValue() == 0) {
                    DetailMenuItem item = mDetailMenuAdapter.getData().get(MENU_POSITION_NIGHTMODE);
                    item.title = "日间模式";
                    item.drawable = getDrawerIcon(MaterialDesignIconic.Icon.gmi_brightness_5);
                } else if (event.getEventValue() == 1) {
                    DetailMenuItem item = mDetailMenuAdapter.getData().get(MENU_POSITION_NIGHTMODE);
                    item.title = "夜间模式";
                    item.drawable = getDrawerIcon(MaterialDesignIconic.Icon.gmi_brightness_2);
                }
                mDetailMenuAdapter.notifyItemChanged(MENU_POSITION_NIGHTMODE);
                break;
            case DetailChangeEvent.EVENT_COLLECT:
                if (event.getEventValue() == 0) {
                    DetailMenuItem item = mDetailMenuAdapter.getData().get(MENU_POSITION_COLLECT);
                    item.title = "收藏一个";
                    item.drawable = getDrawerIcon(MaterialDesignIconic.Icon.gmi_bookmark_outline);
                } else if (event.getEventValue() == 1) {
                    DetailMenuItem item = mDetailMenuAdapter.getData().get(MENU_POSITION_COLLECT);
                    item.title = "取消收藏";
                    item.drawable = getDrawerIcon(MaterialDesignIconic.Icon.gmi_bookmark);
                }
                mDetailMenuAdapter.notifyItemChanged(MENU_POSITION_COLLECT);
                break;
        }
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_detail_menu;
    }

    class DetailMenuItem {

        public String title;
        public IIcon icon;
        public Drawable drawable;

        public DetailMenuItem(String title, IIcon icon) {
            this.title = title;
            this.icon = icon;
            this.drawable = getDrawerIcon(icon);
        }

    }

    private Drawable getDrawerIcon(IIcon icon) {
        return new IconicsDrawable(getActivity())
                .icon(icon)
                .color(ContextCompat.getColor(CSDNApplication.getInstance(), R.color.colorPrimary))
                .sizeDp(R.dimen.drawer_icon_size);
    }


    class DetailMenuAdapter extends BaseRecyclerAdapter<DetailMenuItem> {

        public DetailMenuAdapter(Context ctx, List<DetailMenuItem> list) {
            super(ctx, list);
        }

        @Override
        public int getItemLayoutId(int viewType) {
            return R.layout.item_detail_menu;
        }

        @Override
        public void bindData(RecyclerViewHolder holder, final int position, final DetailMenuItem item) {
            holder.setText(R.id.titleTV, item.title);
            holder.setImageDrawable(R.id.iconIV, item.drawable);
            holder.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CSDNApplication.getInstance().getApplicationComponent().eventBus().post(new DetailMenuClickEvent(position));
                    }
            });
        }
    }

}
