package com.phei.netty.protocol.http.json.pojo;

/**
 * Supported shipment methods. The "INTERNATIONAL" shipment methods can only be
 * used for orders with shipping addresses outside the U.S., and one of these
 * methods is required in this case.
 */
public enum Shipping {
    //普通邮递
    STANDARD_MAIL,
    //宅急送
    PRIORITY_MAIL,
    //国际邮递
    INTERNATIONAL_MAIL,
    //国内快递
    DOMESTIC_EXPRESS,
    //国际快递
    INTERNATIONAL_EXPRESS
}