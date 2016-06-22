package wang.mogujun.csdnplus.view.user;

import android.os.Bundle;

import wang.mogujun.csdnplus.R;
import wang.mogujun.csdnplus.di.HasUserComponent;
import wang.mogujun.csdnplus.di.component.DaggerUserComponent;
import wang.mogujun.csdnplus.di.component.UserComponent;
import wang.mogujun.csdnplus.di.module.UserModule;
import wang.mogujun.csdnplus.view.BaseActivity;

public class LoginActivity extends BaseActivity implements HasUserComponent {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initViews() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.login_container, LoginFragment.newInstance())
                .commit();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.login_act;
    }

    @Override
    public UserComponent getUserComponent() {
        return DaggerUserComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .userModule(new UserModule())
                .build();
    }
}
