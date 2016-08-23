package wang.mogujun.csdnplus.geeknews;


import java.util.List;

import javax.inject.Inject;

import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.di.PerFragment;
import wang.mogujun.csdnplus.geeknews.domain.interactor.GetNewsColumnUseCase;
import wang.mogujun.csdnplus.geeknews.domain.model.NewsColumn;
import wang.mogujun.csdnplus.view.CSDNSubscriber;


/**
 * Created by WangJun on 2016/6/25.
 */
@PerFragment
public class NewsMainPresenter extends NewsMainContract.Presenter {

    @Inject
    GetNewsColumnUseCase mGetNewsColumnUseCase;

    @Inject
    public NewsMainPresenter(){
        CSDNApplication.getInstance().getNewsComponent().inject(this);
    }

    @Override
    public void getNewsColumns() {
        getView().showLoading();
        mGetNewsColumnUseCase.execute(new CSDNSubscriber<List<NewsColumn>>(){

            @Override
            public void onNext(List<NewsColumn> newsColumns) {
                super.onNext(newsColumns);
                getView().showNewsColumns(newsColumns);

            }

            @Override
            public void onCompleted() {
                super.onCompleted();
                getView().hideLoading();
            }

            @Override
            protected void onErrorMsg(String errorMsg) {
                super.onErrorMsg(errorMsg);
                getView().showError(errorMsg);
                getView().hideLoading();
            }
        });
    }

    @Override
    public void detachView(boolean retainInstance) {
        mGetNewsColumnUseCase.unsubscribe();
        super.detachView(retainInstance);
    }
}
