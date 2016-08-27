package wang.mogujun.csdnplus.data.cache;

import android.app.Application;
import android.content.SharedPreferences;

import wang.mogujun.csdnplus.CSDNApplication;

public class UserDetailPrefs {


    private static SharedPreferences userDetailPref = null;

    public static final String LARGE_TEXT_FONT_SIZE = "large";
    public static final String MIDDLE_TEXT_FONT_SIZE = "middle";
    public static final String SMALL_TEXT_FONT_SIZE = "small";


    static {
        init(CSDNApplication.getInstance());
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

    public static String getTextFontSizeSet() {
        return userDetailPref.getString("text_font_size", "middle,14").split(",")[0];
    }

    public static int[] getTextFontSize() {
        String[] textFontSize = userDetailPref.getString("text_font_size", "middle,14").split(",");
        int length = textFontSize.length - 1;
        int[] fontSize = new int[length];
        for (int i = 0; i < length; i++) {
            fontSize[i] = Integer.parseInt(textFontSize[i + 1]);
        }
        return fontSize;
    }

    public static void setTextFontSize(String textFontSize) {
        if (SMALL_TEXT_FONT_SIZE.equals(textFontSize)) {
            userDetailPref.edit().putString("text_font_size", "small,12").apply();
        } else if (MIDDLE_TEXT_FONT_SIZE.equals(textFontSize)) {
            userDetailPref.edit().putString("text_font_size", "middle,14").apply();
        } else if (LARGE_TEXT_FONT_SIZE.equals(textFontSize)) {
            userDetailPref.edit().putString("text_font_size", "large,16").apply();
        }
    }


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
