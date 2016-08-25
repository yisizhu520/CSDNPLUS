package wang.mogujun.csdnplus.view.mvp;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import wang.mogujun.uiframework.mvp.MvpBasePresenter;
import wang.mogujun.uiframework.mvp.MvpView;

/**
 * Created by WangJun on 2016/8/25.
 */
public class MvpRxBasePresenter<V extends MvpView> extends MvpBasePresenter<V> {

    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();

    public MvpRxBasePresenter(){

    }

    protected Observable buildNetObservable(Observable o){
        return o.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    protected void add(Subscription subscription){
//        if (subscription != null && !subscription.isUnsubscribed()) {
//            subscription.unsubscribe();
//            mCompositeSubscription.add(subscription);
//        }
        mCompositeSubscription.add(subscription);
    }


    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if(mCompositeSubscription!=null){
            mCompositeSubscription.unsubscribe();
        }
    }
}
