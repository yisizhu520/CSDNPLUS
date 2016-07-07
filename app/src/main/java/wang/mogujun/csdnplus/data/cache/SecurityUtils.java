package wang.mogujun.csdnplus.data.cache;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class SecurityUtils {
    private static byte[] aes_key = "123456789012.csdn.mobile".getBytes();

    public static String DESDecrypt(String paramString) {
        try {
            byte[] arrayOfByte = Base64.decode(paramString.getBytes("UTF-8"), 2);
            SecretKeySpec localSecretKeySpec = new SecretKeySpec(aes_key, "DESede");
            Cipher localCipher = Cipher.getInstance("DESede");
            localCipher.init(2, localSecretKeySpec);
            String str = new String(localCipher.doFinal(arrayOfByte), "UTF-8");
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String DESEncrypt(String paramString) {
        try {
            SecretKeySpec localSecretKeySpec = new SecretKeySpec(aes_key, "DESede");
            Cipher localCipher = Cipher.getInstance("DESede");
            localCipher.init(1, localSecretKeySpec);
            String str = new String(Base64.encode(localCipher.doFinal(paramString.getBytes("UTF-8")), 2), "UTF-8");
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String URLEncode(String content){
        try {
            return URLEncoder.encode(content, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }
}