package wang.mogujun.csdnplus.view.geeknews;


import java.util.List;

import javax.inject.Inject;

import wang.mogujun.csdnplus.di.PerFragment;
import wang.mogujun.csdnplus.domain.interactor.geeknews.GetNewsColumnUseCase;
import wang.mogujun.csdnplus.domain.model.geeknews.NewsColumn;
import wang.mogujun.csdnplus.view.CSDNNavigator;
import wang.mogujun.csdnplus.view.CSDNSubscriber;


/**
 * Created by WangJun on 2016/6/25.
 */
@PerFragment
public class NewsMainPresenter extends NewsMainContract.Presenter {

    @Inject
    GetNewsColumnUseCase mGetNewsColumnUseCase;
    @Inject
    CSDNNavigator mNavigator;

    @Inject
    public NewsMainPresenter(GetNewsColumnUseCase useCase,CSDNNavigator navigator){
        mGetNewsColumnUseCase = useCase;
        mNavigator = navigator;
    }

    @Override
    public void getNewsColumns() {
        getView().showLoading();
        mGetNewsColumnUseCase.execute(new CSDNSubscriber<List<NewsColumn>>(getView().getContext(),mNavigator){

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
            }
        });
    }

    @Override
    public void detachView(boolean retainInstance) {
        mGetNewsColumnUseCase.unsubscribe();
        super.detachView(retainInstance);
    }
}
