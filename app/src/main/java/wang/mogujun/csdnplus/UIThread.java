package wang.mogujun.csdnplus;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;

@Singleton
public class UIThread implements PostExecutionThread {

    @Inject
    public UIThread(){}

    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}