package wang.mogujun.csdnplus.view;

import android.content.Context;
import android.content.Intent;

import javax.inject.Singleton;

import wang.mogujun.csdnplus.view.main.MainActivity;
import wang.mogujun.csdnplus.user.LoginActivity;

/**
 * Created by WangJun on 2016/6/20.
 */
@Singleton
public class CSDNNavigator {

    public void navigateToLogin(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }

    public void navigateToMain(Context context){
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }


}
