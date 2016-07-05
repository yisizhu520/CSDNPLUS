package wang.mogujun.ext.utils;

import android.content.Context;
import android.content.pm.PackageManager;

/**
 * Created by WangJun on 2016/7/5.
 */
public class AppUtils {

    private AppUtils(){}

    public static String getVersiongName(Context context){
        String name;
        try {
            name = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            name = "未知";
        }
        return name;
    }

}
