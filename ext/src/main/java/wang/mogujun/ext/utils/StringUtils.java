package wang.mogujun.ext.utils;

import android.text.TextUtils;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;

public final class StringUtils {
    private static final int CACHE_SIZE = 4096;
    public static final String EMPTY = "";
    public static final String NOT_AVAILABLE = "N/A";

    public static SimpleDateFormat createDataFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    public static String join(String delimiter, Collection<?> segments) {
        StringBuilder stringBuilder = new StringBuilder();
        if (segments != null) {
            appendCollectionObjectToStringBuilder(stringBuilder, delimiter, segments);
        }
        String outString = stringBuilder.toString();
        if (outString.endsWith(delimiter)) {
            return outString.substring(0, outString.length() - delimiter.length());
        }
        return outString;
    }

    public static String join(String delimiter, Object... segments) {
        StringBuilder stringBuilder = new StringBuilder();
        if (segments != null && segments.length > 0) {
            for (Object segment : segments) {
                appendObjectToStringBuilder(stringBuilder, delimiter, segment);
            }
        }
        String outString = stringBuilder.toString();
        if (outString.endsWith(delimiter)) {
            return outString.substring(0, outString.length() - delimiter.length());
        }
        return outString;
    }

    private static void appendArrayObjectToStringBuilder(StringBuilder stringBuilder, String delimiter, Object array) {
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            appendObjectToStringBuilder(stringBuilder, delimiter, Array.get(array, i));
        }
    }

    private static void appendCollectionObjectToStringBuilder(StringBuilder stringBuilder, String delimiter, Collection<?> collection) {
        for (Object appendObjectToStringBuilder : collection) {
            appendObjectToStringBuilder(stringBuilder, delimiter, appendObjectToStringBuilder);
        }
    }

    private static void appendObjectToStringBuilder(StringBuilder stringBuilder, String delimiter, Object object) {
        if (object != null) {
            if (object.getClass().isArray()) {
                appendArrayObjectToStringBuilder(stringBuilder, delimiter, object);
            } else if (object instanceof Collection) {
                appendCollectionObjectToStringBuilder(stringBuilder, delimiter, (Collection) object);
            } else {
                String objectString = object.toString();
                stringBuilder.append(objectString);
                if (!isEmpty(objectString) && !objectString.endsWith(delimiter)) {
                    stringBuilder.append(delimiter);
                }
            }
        }
    }

    public static boolean isEmpty(String string) {
        return string == null || string.trim().length() == 0;
    }

    public static boolean isNotEmpty(String string) {
        return string != null && string.trim().length() > 0;
    }

    public static boolean equal(String a, String b) {
        return a == b || (a != null && b != null && a.length() == b.length() && a.equals(b));
    }

    public static long[] splitToLongArray(String string, String delimiter) {
        List<String> stringList = splitToStringList(string, delimiter);
        long[] longArray = new long[stringList.size()];
        int i = 0;
        for (String str : stringList) {
            int i2 = i + 1;
            longArray[i] = Long.parseLong(str);
            i = i2;
        }
        return longArray;
    }

    public static List<Long> splitToLongList(String string, String delimiter) {
        List<String> stringList = splitToStringList(string, delimiter);
        List<Long> longList = new ArrayList(stringList.size());
        for (String str : stringList) {
            longList.add(Long.valueOf(Long.parseLong(str)));
        }
        return longList;
    }

    public static String[] splitToStringArray(String string, String delimiter) {
        List<String> stringList = splitToStringList(string, delimiter);
        return (String[]) stringList.toArray(new String[stringList.size()]);
    }

    public static List<String> splitToStringList(String string, String delimiter) {
        List<String> stringList = new ArrayList();
        if (!isEmpty(string)) {
            int length = string.length();
            int pos = 0;
            do {
                int end = string.indexOf(delimiter, pos);
                if (end == -1) {
                    end = length;
                }
                stringList.add(string.substring(pos, end));
                pos = end + 1;
            } while (pos < length);
        }
        return stringList;
    }


    public static boolean isEmailFormat(String string) {
        if (isEmpty(string)) {
            return false;
        }
        return Pattern.matches("^([a-zA-Z0-9_\\.-]+)@([\\da-zA-Z\\.-]+)\\.([a-zA-Z\\.]{1,16})$", string);
    }

    public static boolean isLoginEmailFormat(String string) {
        if (isEmpty(string)) {
            return false;
        }
        return Pattern.matches("^\\s*\\w+(?:\\.?[\\w-]+\\.?)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$", string);
    }

    public static boolean lengthInRange(String string, int begin, int end) {
        return string != null && string.length() >= begin && string.length() <= end;
    }

    public static String validateFilePath(String srcStr) {
        return isEmpty(srcStr) ? srcStr : srcStr.replaceAll("[\\\\/:\"*?<>|]+", "_");
    }

    public static int getCharsLength(String str) {
        int length = 0;
        if (str == null) {
            return 0;
        }
        try {
            length = 0 + str.replaceAll("[^\\x00-\\xff]", "**").length();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return length;
    }

    public static int getWordCount(String str) {
        int length = getCharsLength(str);
        return (length % 2) + (length / 2);
    }


    public static boolean startsWithIgnoreCase(String source, String prefix) {
        if (source == prefix) {
            return true;
        }
        if (source == null || prefix == null) {
            return false;
        }
        return source.regionMatches(true, 0, prefix, 0, prefix.length());
    }

    public static boolean endsWithIgnoreCase(String source, String suffix) {
        if (source == suffix) {
            return true;
        }
        if (source == null || suffix == null) {
            return false;
        }
        int startIndex = source.length() - suffix.length();
        if (startIndex < 0) {
            return false;
        }
        return source.regionMatches(true, startIndex, suffix, 0, suffix.length());
    }

    public static String replaceWith(String source, Object... keyValueArray) {
        if (TextUtils.isEmpty(source)) {
            return source;
        }
        if (keyValueArray.length % 2 != 0) {
            throw new IllegalArgumentException("key value array not valid");
        }
        StringBuilder sb = null;
        for (int i = 0; i < keyValueArray.length; i += 2) {
            String key = String.valueOf(keyValueArray[i]);
            String value = String.valueOf(keyValueArray[i + 1]);
            int index = sb != null ? sb.indexOf(key) : source.indexOf(key);
            while (index >= 0) {
                if (sb == null) {
                    sb = new StringBuilder(source);
                }
                sb.replace(index, key.length() + index, value);
                index = sb.indexOf(key, value.length() + index);
            }
        }
        return sb != null ? sb.toString() : source;
    }

    public static StringBuilder replaceWith(StringBuilder source, Object... keyValueArray) {
        if (!TextUtils.isEmpty(source)) {
            if (keyValueArray.length % 2 != 0) {
                throw new IllegalArgumentException("key value array not valid");
            }
            for (int i = 0; i < keyValueArray.length; i += 2) {
                String key = String.valueOf(keyValueArray[i]);
                String value = String.valueOf(keyValueArray[i + 1]);
                int index = source.indexOf(key);
                while (index >= 0) {
                    source.replace(index, key.length() + index, value);
                    index = source.indexOf(key, value.length() + index);
                }
            }
        }
        return source;
    }
}