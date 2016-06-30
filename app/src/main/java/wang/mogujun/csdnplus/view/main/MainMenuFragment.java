package wang.mogujun.csdnplus.view.main;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.iconics.typeface.IIcon;
import com.mikepenz.material_design_iconic_typeface_library.MaterialDesignIconic;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindView;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.data.cache.LoginPrefs;
import wang.mogujun.csdnplus.data.cache.UserDetailPrefs;
import wang.mogujun.csdnplus.event.DrawerItemClickEvent;
import wang.mogujun.csdnplus.utils.GlideUtils;
import wang.mogujun.csdnplus.view.BaseFragment;
import wang.mogujun.csdnplus.view.adapter.BaseRecyclerAdapter;
import wang.mogujun.csdnplus.view.adapter.RecyclerViewHolder;


public class MainMenuFragment extends BaseFragment {

    @BindView(R.id.menu_avatar_iv)
    ImageView mAvatarIV;
    @BindView(R.id.menu_name_tv)
    TextView mNameTV;
    @BindView(R.id.menu_desc_tv)
    TextView mDescTV;
    @BindView(R.id.menu_rv)
    RecyclerView mMenuRV;

    class DrawerItem {

        @ColorRes
        public int color;
        public String title;
        public IIcon icon;
        public Drawable drawable;

        public DrawerItem(String title, IIcon icon, int color) {
            this.color = color;
            this.title = title;
            this.icon = icon;
            this.drawable = getDrawerIcon(icon, color);
        }

        private Drawable getDrawerIcon(IIcon icon, @ColorRes int color) {
            return new IconicsDrawable(getActivity())
                    .icon(icon)
                    .color(ContextCompat.getColor(getActivity(), color))
                    .sizeDp(R.dimen.drawer_icon_size);
        }
    }


    @BindColor(R.color.gray_light)
    int itemSelectedColor;
    @BindColor(R.color.transparent)
    int itemNormalColor;

    @Override
    protected void initViews() {
        String nickname = LoginPrefs.getNickname();
        mNameTV.setText(nickname);
        //FIXME 设置用户描述信息，积分？
        mDescTV.setText(nickname);
        String avatarUrl = UserDetailPrefs.getAvatar();
        GlideUtils.displayCircleAvatar(mAvatarIV, avatarUrl);
        List<DrawerItem> drawerItems = new ArrayList<>();
        drawerItems.add(new DrawerItem("头条", MaterialDesignIconic.Icon.gmi_book, R.color.colorAccent));
        drawerItems.add(new DrawerItem("博客", MaterialDesignIconic.Icon.gmi_library, R.color.holo_orange_light));
        drawerItems.add(new DrawerItem("问答", MaterialDesignIconic.Icon.gmi_help, R.color.holo_green_light));
        drawerItems.add(new DrawerItem("论坛", MaterialDesignIconic.Icon.gmi_group_work, R.color.holo_blue_light));
        drawerItems.add(new DrawerItem("我的", MaterialDesignIconic.Icon.gmi_account, R.color.holo_red_light));
        //TODO 可以拖动调换位置
        mMenuRV.setLayoutManager(new LinearLayoutManager(getActivity()));
        mMenuRV.setAdapter(new DrawerRecyclerAdapter(getActivity(), drawerItems));
    }


    @Override
    protected int getContentViewId() {
        return R.layout.main_menu_frag;
    }

    public static Fragment newInstance() {
        return new MainMenuFragment();
    }

    class DrawerRecyclerAdapter extends BaseRecyclerAdapter<DrawerItem> {

        int selectedIndex = 0;

        public DrawerRecyclerAdapter(Context ctx, List<DrawerItem> list) {
            super(ctx, list);
        }

        @Override
        public int getItemLayoutId(int viewType) {
            return R.layout.main_menu_item;
        }

        @Override
        public void bindData(RecyclerViewHolder holder, final int position, DrawerItem item) {
            //TODO 设置未读消息提醒badge
            if(selectedIndex == position){//选中效果
                //TODO 为什么设置select没有效果呢？
//                itemLayout.setSelected(true);
//                name.setSelected(true);

                holder.getView().setBackgroundColor(itemSelectedColor);
            }else {
//                itemLayout.setSelected(false);
//                name.setSelected(false);
                holder.getView().setBackgroundColor(itemNormalColor);
            }
            holder.setText(R.id.menu_item_title_iv, item.title)
                    .setImageDrawable(R.id.menu_item_icon_iv, item.drawable)
                    .setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int oldIndex = selectedIndex;
                            selectedIndex = position;
                            if(oldIndex == selectedIndex) return;
                            getEventBus().post(new DrawerItemClickEvent(oldIndex,selectedIndex));
                            DrawerRecyclerAdapter.this.notifyDataSetChanged();
                        }
                    });
        }
    }

}
