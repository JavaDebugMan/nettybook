package com.phei.netty.protocol.http.jsonprotocol;

import com.alibaba.fastjson.JSONObject;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.util.CharsetUtil;

import static io.netty.handler.codec.http.HttpHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;


/**
 * @author pengzhe
 * @date 2018-12-01 23:25
 * @description
 */

public class MyServerHandler extends SimpleChannelInboundHandler<FullHttpRequest> {

    @Override    //获取http请求
    protected void messageReceived(ChannelHandlerContext ctx, FullHttpRequest msg) {

/*		下面是返回html
  		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK);
	    response.headers().set(CONTENT_TYPE, "text/html; charset=UTF-8");
	    StringBuilder buf = new StringBuilder();
	    buf.append("<!DOCTYPE html>\r\n");
	    buf.append("<html><head><title>");
	    buf.append(" 返回html页面");
	    buf.append("</title></head><body>\r\n");
	    buf.append("下面是页面内容</body></html>\r\n");
	    ByteBuf buffer = Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
	    response.content().writeBytes(buffer);
	    buffer.release();
	    ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);*/


        //返回json
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK);
        response.headers().set(CONTENT_TYPE, "text/json; charset=UTF-8");

        //获取请求uri,业务上根据uri创建json对象
        String uriString = msg.getUri();
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("name", "name");
        jsonObj.put("age", 1);
        //json转string
        String buf = jsonObj.toString();

        //返回
        ByteBuf buffer = Unpooled.copiedBuffer(buf, CharsetUtil.UTF_8);
        response.content().writeBytes(buffer);
        buffer.release();
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);


    }
}
