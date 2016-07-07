package wang.mogujun.csdnplus.data.cache;

import android.app.Application;
import android.content.SharedPreferences;

public class UserDetailPrefs {


    private static SharedPreferences userDetailPref = null;

    static {
        //initialize(GlobalContext.getInstance());
    }

    public static String getAvatar() {
        return userDetailPref.getString("avatar", "");
    }

    public static String getCurjob() {
        return userDetailPref.getString("curjob", "");
    }

    public static String getEduexp() {
        return userDetailPref.getString("eduexp", "");
    }

    public static String getIndustry() {
        return userDetailPref.getString("industry", "");
    }

    public static String getInterest() {
        return userDetailPref.getString("interest", "");
    }

    public static String getRealname() {
        return userDetailPref.getString("realname", "");
    }

//  public static boolean getSaveFlowStatus()
//  {
//    CSDNApp.isSaveFlow = userDetailPref.getBoolean("save_flow_status", false);
//    return CSDNApp.isSaveFlow;
//  }

    public static String getSkills() {
        return userDetailPref.getString("skills", "");
    }

    public static UserDetails getUserDetail() {
        if (!isValid()) {
            return null;
        }
        UserDetails localUserDetails = new UserDetails();
        localUserDetails.avatar = getAvatar();
        localUserDetails.curjob = getCurjob();
        localUserDetails.eduexp = getEduexp();
        localUserDetails.industry = getIndustry();
        localUserDetails.interest = getInterest();
        localUserDetails.realname = getRealname();
        localUserDetails.skills = getSkills();
        localUserDetails.work = getWork();
        return localUserDetails;
    }

    public static String getWork() {
        return userDetailPref.getString("work", "");
    }

    public static void init(Application paramApplication) {
        if (userDetailPref == null) {
            userDetailPref = paramApplication.getSharedPreferences("userDetailPref", 0);
        }
    }

    public static boolean isValid() {
        return userDetailPref.getBoolean("valid", false);
    }

    public static void setAvatar(String paramString) {
        userDetailPref.edit().putString("avatar", paramString).apply();
    }

    public static void setCurjob(String paramString) {
        userDetailPref.edit().putString("curjob", paramString).apply();
    }

    public static void setEduexp(String paramString) {
        userDetailPref.edit().putString("eduexp", paramString).apply();
    }

    public static void setIndustry(String paramString) {
        userDetailPref.edit().putString("industry", paramString).apply();
    }

    public static void setInterest(String paramString) {
        userDetailPref.edit().putString("interest", paramString).apply();
    }

    public static void setRealname(String paramString) {
        userDetailPref.edit().putString("realname", paramString).apply();
    }

//  public static void setSaveFlowStatus(boolean paramBoolean)
//  {
//    CSDNApp.isSaveFlow = paramBoolean;
//    userDetailPref.edit().putBoolean("save_flow_status", paramBoolean).apply();
//  }

    public static void setSkills(String paramString) {
        userDetailPref.edit().putString("skills", paramString).apply();
    }

    public static void setUserDetail(UserDetails paramUserDetails) {
        setAvatar(paramUserDetails.avatar);
        setCurjob(paramUserDetails.curjob);
        setEduexp(paramUserDetails.eduexp);
        setIndustry(paramUserDetails.industry);
        setInterest(paramUserDetails.interest);
        setRealname(paramUserDetails.realname);
        setSkills(paramUserDetails.skills);
        setWork(paramUserDetails.work);
        setValid(true);
    }

    public static void setValid(boolean paramBoolean) {
        userDetailPref.edit().putBoolean("valid", paramBoolean).apply();
    }

    public static void setWork(String paramString) {
        userDetailPref.edit().putString("work", paramString).apply();
    }
}
