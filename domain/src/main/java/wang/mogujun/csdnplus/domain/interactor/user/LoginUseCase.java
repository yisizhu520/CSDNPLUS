package wang.mogujun.csdnplus.domain.interactor.user;

import javax.inject.Inject;

import rx.Observable;
import wang.mogujun.csdnplus.domain.executor.PostExecutionThread;
import wang.mogujun.csdnplus.domain.executor.ThreadExecutor;
import wang.mogujun.csdnplus.domain.interactor.UseCase;
import wang.mogujun.csdnplus.domain.model.CSDNResponse;
import wang.mogujun.csdnplus.domain.repository.UserRepository;

public class LoginUseCase extends UseCase<CSDNResponse> {
    private String password;
    private final UserRepository userRepository;
    private String username;

    @Inject
    public LoginUseCase(UserRepository userRepository, ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        this.userRepository = userRepository;
    }

    public void setParam(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Observable<CSDNResponse> buildUseCaseObservable() {
        return this.userRepository.login(this.username, this.password);
    }
}