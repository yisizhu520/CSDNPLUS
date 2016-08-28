package wang.mogujun.csdnplus.blog;


import java.util.List;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import wang.mogujun.csdnplus.CSDNApplication;
import wang.mogujun.csdnplus.blog.domain.model.BlogRecommendListInfo;
import wang.mogujun.csdnplus.blog.domain.model.BlogRecommendListReqBean;
import wang.mogujun.csdnplus.blog.domain.repository.BlogRepository;
import wang.mogujun.csdnplus.domain.DomainConstants;
import wang.mogujun.csdnplus.view.CSDNSubscriber;
import wang.mogujun.ext.utils.CollectionUtils;

/**
 * Created by WangJun on 2016/8/28.
 */
public class BlogRecommendListPresenter extends BlogRecommendListContract.Presenter {

    @Inject
    BlogRepository mBlogRepository;

    private int mPageIndex = 1;

    private String mLastId;

    public BlogRecommendListPresenter() {
        CSDNApplication.getInstance().getBlogComponent().inject(this);
    }

    @Override
    public void loadNewData() {
        getView().showLoading();
        getView().hideEmptyView();
        BlogRecommendListReqBean reqBean = new BlogRecommendListReqBean();
        reqBean.setLastId("-")
                .setDirection(DomainConstants.DIRECTION_UP)
                .setSize(DomainConstants.DEFAULT_PAGE_SIZE);
        Subscription s = mBlogRepository.getRecommendBlogList(reqBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CSDNSubscriber<List<BlogRecommendListInfo>>() {

                    @Override
                    protected void onErrorMsg(String errorMsg) {
                        super.onErrorMsg(errorMsg);
                        getView().hideLoading();
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                        getView().hideLoading();
                    }

                    @Override
                    public void onNext(List<BlogRecommendListInfo> infos) {
                        super.onNext(infos);
                        if (CollectionUtils.isEmpty(infos)) {
                            getView().showEmptyView();
                        } else {
                            //TODO 将新数据缓存到本地数据库,应该在repository层里做
                            getView().showNewData(infos);
                            mLastId = infos.get(infos.size() - 1).get_id();
                        }
                    }
                });
        add(s);

    }

    @Override
    public void loadMoreData() {
        getView().showLoading();
        getView().hideEmptyView();
        BlogRecommendListReqBean reqBean = new BlogRecommendListReqBean();
        reqBean.setLastId(mLastId)
                .setDirection(DomainConstants.DIRECTION_DOWN)
                .setSize(DomainConstants.DEFAULT_PAGE_SIZE);
        Subscription s = mBlogRepository.getRecommendBlogList(reqBean)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CSDNSubscriber<List<BlogRecommendListInfo>>() {

                    @Override
                    protected void onErrorMsg(String errorMsg) {
                        super.onErrorMsg(errorMsg);
                        getView().showMoreDataError(errorMsg);
                    }

                    @Override
                    public void onCompleted() {
                        super.onCompleted();
                    }

                    @Override
                    public void onNext(List<BlogRecommendListInfo> infos) {
                        super.onNext(infos);
                        if(CollectionUtils.isEmpty(infos)){
                            getView().showNoMoreData();
                        }else{
                            //TODO 将新数据缓存到本地数据库,应该在repository层里做
                            getView().showMoreData(infos);
                            mLastId = infos.get(infos.size()-1).get_id();
                        }
                    }
                });
        add(s);
    }


}
