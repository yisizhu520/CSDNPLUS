package wang.mogujun.csdnplus.data.cache;

import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class SecurityV2Util
{
  public static String DESDecrypt(String paramString1, String paramString2)
  {
    try
    {
      while (true)
      {
        if (paramString1.length() >= 24)
        {
          String str2 = paramString1.substring(0, 24);
          byte[] arrayOfByte = Base64.decode(paramString2.getBytes("UTF-8"), 2);
          SecretKeySpec localSecretKeySpec = new SecretKeySpec(str2.getBytes(), "DESede");
          Cipher localCipher = Cipher.getInstance("DESede");
          localCipher.init(2, localSecretKeySpec);
          return new String(localCipher.doFinal(arrayOfByte), "UTF-8");
        }
        String str1 = paramString1 + "0";
        paramString1 = str1;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      return "";
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      while (true)
        localNoSuchPaddingException.printStackTrace();
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      while (true)
        localInvalidKeyException.printStackTrace();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localUnsupportedEncodingException.printStackTrace();
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      while (true)
        localIllegalBlockSizeException.printStackTrace();
    }
    catch (BadPaddingException localBadPaddingException)
    {
      while (true)
        localBadPaddingException.printStackTrace();
    }
  }

  public static String DESEncrypt(String paramString1, String paramString2)
  {
    try
    {
      while (true)
      {
        if (paramString1.length() >= 24)
        {
          SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramString1.substring(0, 24).getBytes(), "DESede");
          Cipher localCipher = Cipher.getInstance("DESede");
          localCipher.init(1, localSecretKeySpec);
          return new String(Base64.encode(localCipher.doFinal(paramString2.getBytes("UTF-8")), 2), "UTF-8");
        }
        String str = paramString1 + "0";
        paramString1 = str;
      }
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      localNoSuchAlgorithmException.printStackTrace();
      return "";
    }
    catch (NoSuchPaddingException localNoSuchPaddingException)
    {
      while (true)
        localNoSuchPaddingException.printStackTrace();
    }
    catch (InvalidKeyException localInvalidKeyException)
    {
      while (true)
        localInvalidKeyException.printStackTrace();
    }
    catch (IllegalBlockSizeException localIllegalBlockSizeException)
    {
      while (true)
        localIllegalBlockSizeException.printStackTrace();
    }
    catch (BadPaddingException localBadPaddingException)
    {
      while (true)
        localBadPaddingException.printStackTrace();
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        localUnsupportedEncodingException.printStackTrace();
    }
  }

  public static String getSignatureByMD5(String paramString)
  {
    try
    {
      char[] arrayOfChar1 = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes("UTF-8"));
      byte[] arrayOfByte = localMessageDigest.digest();
      int i = arrayOfByte.length;
      char[] arrayOfChar2 = new char[i * 2];
      int j = 0;
      int k = 0;
      while (true)
      {
        if (j >= i)
          return new String(arrayOfChar2);
        int m = arrayOfByte[j];
        int n = k + 1;
        arrayOfChar2[k] = arrayOfChar1[(0xF & m >>> 4)];
        k = n + 1;
        arrayOfChar2[n] = arrayOfChar1[(m & 0xF)];
        j++;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}