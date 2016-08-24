package wang.mogujun.csdnplus.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.apache.commons.io.IOUtils;

public class CSDNWebView extends WebView {

    private GestureDetector mGestureDetector;

    public CSDNWebView(Context paramContext) {
        super(paramContext);
        init();
    }

    public CSDNWebView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        init();
    }

    public CSDNWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt) {
        super(paramContext, paramAttributeSet, paramInt);
        init();
    }


    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return super.onInterceptTouchEvent(ev) && mGestureDetector.onTouchEvent(ev);
    }

    // Return false if we're scrolling in the x direction
    class YScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (Math.abs(distanceY) > Math.abs(distanceX)) {
                return true;
            }
            return false;
        }
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private void init() {
        mGestureDetector = new GestureDetector(getContext(), new YScrollDetector());
        setFadingEdgeLength(0);

        WebSettings localWebSettings = this.getSettings();
        localWebSettings.setJavaScriptEnabled(true);
        //localWebSettings.setUseWideViewPort(true);
        //localWebSettings.setLoadWithOverviewMode(true);
        setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        addJavascriptInterface(new JsObject(), "csdnwebview");

        setWebViewClient(new CSDNWebViewClient());
    }


    /**
     * 用本地的css与html来包装详情内容
     *
     * @param paramString 内容数据或评论数据
     * @param paramInt    0：内容   1：评论
     */
    public void loadDataWithWrap(String paramString, int paramInt) {
        String localObject = "";
        try {
            //TODO 夜间模式的处理
//            if (!CSDNApp.isDayFlag) {
//                if (paramInt == 0) {
//                    setBackgroundColor(getContext().getResources().getColor(R.color.webview_bg));
//                    String str1 = IOUtils.toString(getContext().getAssets().open("htmlwrap_night.html"));
//                    localObject = str1;
//                }
//                if (paramInt == 1) {
//                    setBackgroundColor(getContext().getResources().getColor(R.color.webview_bg));
//                    localObject = IOUtils.toString(getContext().getAssets().open("htmlwrap_comment_night.html"));
//                }
//            } else

            if (paramInt == 0) {
                localObject = IOUtils.toString(getContext().getAssets().open("htmlwrap.html"));
            } else if (paramInt == 1) {
                String str2 = IOUtils.toString(getContext().getAssets().open("htmlwrap_comment.html"));
                localObject = str2;
            }
            if (!TextUtils.isEmpty(localObject))
                paramString = localObject.replace("replace", paramString);
            loadDataWithBaseURL("", paramString, "text/html", "utf-8", "");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class JsObject {
        JsObject() {
        }

        @JavascriptInterface
        public void onClickCode(String paramString) {
//            Intent localIntent = new Intent(CSDNWebView.this.getContext(), CodeViewActivity_.class);
//            localIntent.putExtra("code", paramString);
//            CSDNWebView.this.getContext().startActivity(localIntent);
        }

        @JavascriptInterface
        public void onClickImg(String paramString) {
            Bundle localBundle = new Bundle();
            Intent localIntent = new Intent();
            localBundle.putString("imageUrl", paramString);
            localIntent.putExtras(localBundle);
//            localIntent.setClass(CSDNWebView.this.getContext(), PhotoViewActivity_.class);
//            CSDNWebView.this.getContext().startActivity(localIntent);
        }

//        @JavascriptInterface
//        public void preventParentTouchEvent()
//        {
//            CSDNWebView.this.mPreventParentTouch = true;
//        }
//
//        @JavascriptInterface
//        public void toast(String paramString)
//        {
//            Toast.makeText(CSDNWebView.this.getContext(), paramString, 0).show();
//        }
//
//        @JavascriptInterface
//        public void touchCode(int paramInt)
//        {
//            CSDNWebView.this.codeIndex = paramInt;
//        }
//    }
    }

    private WebViewLoadListener mWebViewLoadListener;

    public void setWebViewLoadListener(WebViewLoadListener webViewLoadListener) {
        mWebViewLoadListener = webViewLoadListener;
    }

    public  class WebViewLoadListener {

        public void shouldOverrideUrlLoading(WebView view, String url) {
        }

        public void onPageStarted(WebView view, String url, Bitmap favicon) {
        }

        public void onPageFinished(WebView view, String url) {
        }

        public void onLoadResource(WebView view, String url) {
        }

        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
        }

    }

    private class CSDNWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (mWebViewLoadListener != null)
                mWebViewLoadListener.shouldOverrideUrlLoading(view, url);
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            if (mWebViewLoadListener != null)
                mWebViewLoadListener.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (mWebViewLoadListener != null)
                mWebViewLoadListener.onPageFinished(view, url);
        }

        @Override
        public void onLoadResource(WebView view, String url) {
            super.onLoadResource(view, url);
            if (mWebViewLoadListener != null)
                mWebViewLoadListener.onLoadResource(view, url);
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            if (mWebViewLoadListener != null)
                mWebViewLoadListener.onReceivedError(view, request, error);
        }
    }
}