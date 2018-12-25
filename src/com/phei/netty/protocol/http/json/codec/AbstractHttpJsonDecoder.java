package com.phei.netty.protocol.http.json.codec;

import com.phei.netty.protocol.http.json.GsonUtils;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;

import java.nio.charset.Charset;

/**
 * @author pengzhe
 * @date 2018/4/28 23:15
 * @description 封装Json的反序列化方法
 */

public abstract class AbstractHttpJsonDecoder<T> extends MessageToMessageDecoder<T> {
    private Class<?> clazz;
    private boolean isPrint;
    private final static Charset UTF_8 = Charset.forName("UTF-8");

    protected AbstractHttpJsonDecoder(Class<?> clazz, boolean isPrint) {
        this.clazz = clazz;
        this.isPrint = isPrint;
    }

    protected Object decode0(ChannelHandlerContext ctx, ByteBuf body) {
        String content = body.toString(UTF_8);
        if (isPrint)
            System.out.println("The body is : " + content);
        Object result = GsonUtils.toObject(content, clazz);
        return result;
    }
}
