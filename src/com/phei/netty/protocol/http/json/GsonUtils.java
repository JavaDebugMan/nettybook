package com.phei.netty.protocol.http.json;

import com.google.gson.Gson;
import com.phei.netty.protocol.http.json.pojo.Order;
import com.phei.netty.protocol.http.json.pojo.OrderFactory;

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

    public static void main(String[] args) {
        Order order = OrderFactory.create(100L);
        String json = GsonUtils.toJson(order);
        System.out.println(json);
        Order order1 = (Order)GsonUtils.toObject(json, Order.class);
        System.out.println(order1);
    }
}

