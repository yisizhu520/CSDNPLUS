package wang.mogujun.csdnplus.data.cache;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.text.TextUtils;

import java.net.URLEncoder;

public class LoginPrefs {
    private static SharedPreferences loginPref = null;

    static {
        //getSharedPreferences(GlobalContext.getInstance());
    }

    public static void exit() {
        loginPref.edit().putString("login", "").putString("TGC", "").putString("SessionId", "").putString("SessionId-v2", "").putString("SessionExpired", "").putString("mobile", "").putString("email", "").putString("User.id", "").putString("User.userId", "").putString("logintype", "").putString("third_party_openid", "").apply();
        UserDetailPrefs.setValid(false);
    }

    public static String getEmail() {
        return loginPref.getString("email", "");
    }

    public static String getKey() {
        return loginPref.getString("key", "");
    }

    public static String getLogin() {
        return loginPref.getString("login", "");
    }

    public static String getLoginPassWord() {
        String str1 = loginPref.getString("loginPassWord", "");
        try {
            return SecurityUtils.DESDecrypt(str1);
        } catch (Exception localException) {
        }
        return str1;
    }

    public static String getLoginType() {
        return loginPref.getString("logintype", "");
    }

    public static String getLoginUserName() {
        return loginPref.getString("loginUserName", "");
    }

    public static String getMobile() {
        return loginPref.getString("mobile", "");
    }

    public static String getNickname() {
        return loginPref.getString("nickname", "");
    }

    public static String getSessionExpired() {
        return loginPref.getString("SessionExpired", "");
    }

    public static String getSessionId() {
        String str1 = loginPref.getString("SessionId-encrypt", "");
        if (str1.equals("")) {
            str1 = loginPref.getString("SessionId-v2", "");
            if (TextUtils.isEmpty(str1)) {
                return "";
            }
            str1 = SecurityV2Util.DESEncrypt(getKey(), str1);
        }
//        try {
////            return URLEncoder.encode(str1, "UTF-8");
//            return str1;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        return str1;
    }

    public static void init(Application paramApplication){
        if (loginPref == null) {
            loginPref = paramApplication.getSharedPreferences("loginPref", 0);
        }
    }

    public static SharedPreferences getSharedPreferences(Application paramApplication) {
        if (loginPref == null) {
            loginPref = paramApplication.getSharedPreferences("loginPref", 0);
        }
        try {
            String str2 = paramApplication.getPackageManager().getPackageInfo(paramApplication.getPackageName(), 0).versionName;
            String str1 = str2;
            if (str2 != null) {
                if (str2.length() > 3) {
                    str1 = str2.substring(0, 3);
                }
            }
            str1 = SecurityV2Util.getSignatureByMD5("csdn-android-" + str2.substring(0, 3));
            loginPref.edit().putString("key", str1).putString("versionName", str2).putString("simpleVersionName", str1).apply();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return loginPref;
    }

    public static String getSimpleVersionName() {
        return loginPref.getString("simpleVersionName", "");
    }

    public static String getTGC() {
        return loginPref.getString("TGC", "");
    }

    public static String getThirdPartyOpenid() {
        return loginPref.getString("third_party_openid", "");
    }

    public static String getUserInfo() {
        return loginPref.getString("userInfo", "");
    }

    public static String getUserName() {
        return loginPref.getString("userName", "");
    }

    public static String getUser_id() {
        return loginPref.getString("User.id", "");
    }

    public static String getUser_userId() {
        return loginPref.getString("User.userId", "");
    }

    public static String getVersionName() {
        return loginPref.getString("versionName", "");
    }

    public static void setEmail(String paramString) {
        loginPref.edit().putString("email", paramString).apply();
    }

    public static void setLogin(String paramString) {
        loginPref.edit().putString("login", paramString).apply();
    }

    public static void setLoginPassWord(String paramString) {
        try {
            String str = SecurityUtils.DESEncrypt(paramString);
            paramString = str;
        } catch (Exception localException) {
        }
        loginPref.edit().putString("loginPassWord", paramString).apply();
    }

    public static void setLoginType(String paramString) {
        loginPref.edit().putString("logintype", paramString).apply();
    }

    public static void setLoginUserName(String paramString) {
        loginPref.edit().putString("loginUserName", paramString).apply();
    }

    public static void setMobile(String paramString) {
        loginPref.edit().putString("mobile", paramString).apply();
    }

    public static void setNickname(String paramString) {
        loginPref.edit().putString("nickname", paramString).apply();
    }

    public static void setSessionExpired(String paramString) {
        loginPref.edit().putString("SessionExpired", paramString).apply();
    }

    public static void setSessionId(String paramString) {
        loginPref.edit().putString("SessionId-v2", paramString).apply();
        paramString = SecurityV2Util.DESEncrypt(getKey(), paramString);
        try {
            paramString = URLEncoder.encode(paramString, "UTF-8");
        } catch (Exception localException) {
        }
        loginPref.edit().putString("SessionId-encrypt", paramString).apply();
    }

    public static void setTGC(String paramString) {
        loginPref.edit().putString("TGC", paramString).apply();
    }

    public static void setThirdPartyOpenid(String paramString) {
        loginPref.edit().putString("third_party_openid", paramString).apply();
    }

    public static void setUserInfo(String paramString) {
        loginPref.edit().putString("userInfo", paramString).apply();
    }

    public static void setUserName(String paramString) {
        loginPref.edit().putString("userName", paramString).apply();
    }

    public static void setUser_id(String paramString) {
        loginPref.edit().putString("User.id", paramString).apply();
    }

    public static void setUser_userId(String paramString) {
        loginPref.edit().putString("User.userId", paramString).apply();
    }
}
