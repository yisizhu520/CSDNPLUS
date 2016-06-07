package wang.mogujun.uiframework;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by WangJun on 2016/6/7.
 */
public class CommonFragment extends Fragment {

    public void hideInputMethod() {
        Activity activity = getActivity();
        if (activity != null) {
            View focusView = activity.getCurrentFocus();
            if (focusView != null) {
                ((InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(focusView.getWindowToken(), 0);
            }
        }
    }

    public void showInputMethod(EditText editText) {
        Activity activity = getActivity();
        if (activity != null && editText != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            editText.requestFocus();
            inputMethodManager.showSoftInput(editText, 2);
        }
    }


}
