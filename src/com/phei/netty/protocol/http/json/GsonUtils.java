package com.phei.netty.protocol.http.json;

import com.google.gson.Gson;

/**
 * @author pengzhe
 * @date 2018/4/28 23:12
 * @description
 */

public class GsonUtils {

    public static String toJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static Object toObject(String jsonStr, Class<?> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonStr, clazz);

    }
}

