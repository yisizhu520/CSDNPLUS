package wang.mogujun.csdnplus.view.user;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.dd.processbutton.iml.ActionProcessButton;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.di.HasUserComponent;
import wang.mogujun.csdnplus.view.MvpBaseFragment;

/**
 * Created by WangJun on 2016/6/21.
 */
public class LoginFragment extends
        MvpBaseFragment<LoginContract.View, LoginContract.Presenter>
        implements LoginContract.View {

    @BindView(R.id.login_logo_iv)
    ImageView mLoginLogoIv;
    @BindView(R.id.login_account_et)
    MaterialEditText mLoginAccountEt;
    @BindView(R.id.login_pwd_et)
    MaterialEditText mLoginPwdEt;
    @BindView(R.id.login_btn)
    ActionProcessButton mLoginBtn;
    @BindViews({R.id.login_account_et,R.id.login_pwd_et,R.id.login_btn})
    List<View> actionViews;

    @Inject
    LoginPresenter loginPresenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    protected void initViews() {
        ((HasUserComponent)getActivity()).getUserComponent().inject(this);
    }

    @Override
    protected int getContentViewId() {
        return R.layout.login_frag;
    }

    @OnClick(R.id.login_btn)
    public void onClick() {
        if(checkInputValid()){
            mLoginBtn.setProgress(50);
            presenter.doLogin(
                    mLoginAccountEt.getText().toString(),mLoginPwdEt.getText().toString());
        }
    }

    private boolean checkInputValid(){
        //TODO 验证输入合法
        return true;
    }

    @Override
    public LoginContract.Presenter createPresenter() {
        return loginPresenter;
    }

    static final ButterKnife.Setter<View, Boolean> ENABLED = new ButterKnife.Setter<View, Boolean>() {
        @Override public void set(View view, Boolean value, int index) {
            view.setEnabled(value);
        }
    };

    @Override
    public Context getContext(){
        return getActivity();
    }

    @Override
    public void showLoading() {
        mLoginBtn.setProgress(50);
        ButterKnife.apply(actionViews,ENABLED,false);
        mLoginBtn.setEnabled(false);
    }

    @Override
    public void showLoginSuccess() {
        mLoginBtn.setProgress(100);
        ButterKnife.apply(actionViews,ENABLED,false);
        mNavigator.navigateToMain(getActivity());
        getActivity().finish();
    }

    @Override
    public void showLoginError(String msg) {
        mLoginBtn.setProgress(-1);
        mLoginBtn.setErrorText(msg);
        //TODO 需要时间来显示这个转换的过程
        mLoginBtn.setProgress(0);
        mLoginBtn.setEnabled(true);
    }
}
