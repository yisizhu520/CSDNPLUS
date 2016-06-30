package wang.mogujun.ext.utils;

import java.util.Collection;
import java.util.List;

/**
 * Created by WangJun on 2016/6/30.
 */
public class CollectionUtils {

    public static boolean isEmpty(Collection c) {
        if (c == null || c.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将参数集合转换成"name1,name2,name3"的字符串格式
     * @param params
     * @return
     */
    public static String convertParamList2String(List<? extends Object> params) {
        if (isEmpty(params)) throw new IllegalArgumentException("params is null");
        StringBuilder paramsSB = new StringBuilder(params.get(0).toString());
        for (int i = 1; i < params.size(); i++) {
            paramsSB.append(",").append(params.get(i));
        }
        return paramsSB.toString();

    }

}
