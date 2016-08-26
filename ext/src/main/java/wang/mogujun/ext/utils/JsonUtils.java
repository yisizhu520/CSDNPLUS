package wang.mogujun.ext.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;

public class JsonUtils {
    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final boolean DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE = false;
    public static final String EMPTY_JSON = "{}";
    public static final String EMPTY_JSON_ARRAY = "[]";

    private static final Gson mGson = new Gson();

    public static String toJson(Object target) {
        return toJson(target, null, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE, null, null, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE);
    }

    public static String toJson(Object target, Type targetType) {
        return toJson(target, targetType, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE, null, null, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE);
    }

    public static String toJson(Object target, Type targetType, Double version) {
        return toJson(target, targetType, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE, version, null, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE);
    }

    public static String toJson(Object target, Type targetType, boolean excludesFieldsWithoutExpose) {
        return toJson(target, targetType, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE, null, null, excludesFieldsWithoutExpose);
    }

    public static String toJson(Object target, Type targetType, Double version, boolean excludesFieldsWithoutExpose) {
        return toJson(target, targetType, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE, version, null, excludesFieldsWithoutExpose);
    }

    public static String toJson(Object target, boolean excludesFieldsWithoutExpose) {
        return toJson(target, null, DEFAULT_EXCLUDES_FIELDS_WITHOUT_EXPOSE, null, null, excludesFieldsWithoutExpose);
    }

    public static String toJson(Object target, Type targetType, boolean isSerializeNulls, Double version, String datePattern, boolean excludesFieldsWithoutExpose) {
        if (target == null) {
            return EMPTY_JSON;
        }
        GsonBuilder builder = new GsonBuilder();
        if (isSerializeNulls) {
            builder.serializeNulls();
        }
        if (version != null) {
            builder.setVersion(version.doubleValue());
        }
        if (StringUtils.isEmpty(datePattern)) {
            datePattern = DEFAULT_DATE_PATTERN;
        }
        builder.setDateFormat(datePattern);
        if (excludesFieldsWithoutExpose) {
            builder.excludeFieldsWithoutExposeAnnotation();
        }
        return toJson(target, targetType, builder);
    }

    public static String toJson(Object target, Type targetType, GsonBuilder builder) {
        if (target == null) {
            return EMPTY_JSON;
        }
        Gson gson;
        if (builder == null) {
            gson = new Gson();
        } else {
            gson = builder.create();
        }
        String result = EMPTY_JSON;
        if (targetType != null) {
            return gson.toJson(target, targetType);
        }
        try {
            return gson.toJson(target);
        } catch (Exception e) {
            e.printStackTrace();
            if ((target instanceof Collection) || (target instanceof Iterator) || (target instanceof Enumeration) || target.getClass().isArray()) {
                return EMPTY_JSON_ARRAY;
            }
            return result;
        }
    }

    public static <T> T fromJson(Object json, Class<T> cls) {
        return fromJson(toJson(json), cls, null);
    }

    public static <T> T fromJson(String json, Class<T> cls) {
        return fromJson(json, cls, null);
    }

    public static <T> T fromJson(String json, Type type) {
        return fromJson(json, type, null);
    }

    public static <T> T fromJson(String json, TypeToken<T> token) {
        return fromJson(json, token, null);
    }

    public static <T> T fromJson(String json, Class<T> cls, String datePattern) {
        T t = null;
        if (!StringUtils.isEmpty(json)) {
            GsonBuilder builder = new GsonBuilder();
            if (StringUtils.isEmpty(datePattern)) {
                datePattern = DEFAULT_DATE_PATTERN;
            }
            Gson gson = builder.create();
            builder.setDateFormat(datePattern);
            try {
                t = gson.fromJson(json, cls);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    public static <T> T fromJson(String json, Type type, String datePattern) {
        T t = null;
        if (!StringUtils.isEmpty(json)) {
            GsonBuilder builder = new GsonBuilder();
            if (StringUtils.isEmpty(datePattern)) {
                datePattern = DEFAULT_DATE_PATTERN;
            }
            builder.setDateFormat(datePattern);
            try {
                t = builder.create().fromJson(json, type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return t;
    }

    public static <T> T fromJson(String json, TypeToken<T> token, String datePattern) {
        return fromJson(json, token.getType(), datePattern);
    }

    public static Map<String,String> convertBean2Map(Object reqBean){
        String json = mGson.toJson(reqBean);
        return  mGson.fromJson(
                json,new TypeToken<Map<String,String>>(){}.getType());
    }
}