package wang.mogujun.csdnplus.view.geeknews;

/**
 * Created by WangJun on 2016/6/25.
 */
public class NewsLatestListFragment extends NewsListFragment {

    public static NewsLatestListFragment newInstance(){
        return new NewsLatestListFragment();
    }

    @Override
    public NewsListContract.Presenter createPresenter() {
        return new NewsLatestPresenter();
    }
}
