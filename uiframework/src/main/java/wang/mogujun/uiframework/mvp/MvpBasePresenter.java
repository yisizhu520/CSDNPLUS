package wang.mogujun.uiframework.mvp;

/**
 * Created by WangJun on 2016/6/9.
 */
public class MvpBasePresenter <V extends MvpView> implements MvpPresenter<V> {

    protected V mvpView;

    @Override
    public void attachView(V view) {
        mvpView = view;
    }

    @Override
    public void detachView(boolean retainInstance) {
        mvpView = null;
    }
}
