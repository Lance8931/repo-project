package com.siping.web.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {

    /**
     * 将单个Object对象转换成json字符串，如bean对象、Map等
     * @param obj
     * @return
     */
    public static String objectToJson(Object obj){
        return JSONObject.fromObject(obj).toString();
    }

    /**
     * 将数组、集合转换成json字符串，如String[]、List等
     * @param obj
     * @return
     */
    public static String arrayToJson(Object obj){
        return JSONArray.fromObject(obj).toString();
    }
}
