package com.phei.netty.protocol.http.json.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.net.InetAddress;
import java.util.List;

import static io.netty.handler.codec.http.HttpHeaders.setContentLength;

/**
 * @author pengzhe
 * @date 2018-12-25 21:39
 * @description 请求消息编码器, 供HTTP客户端发送请求时, 消息自动编码使用
 */

public class HttpJsonRequestEncoder extends AbstractHttpJsonEncoder<HttpJsonRequest> {
    @Override
    protected void encode(ChannelHandlerContext ctx, HttpJsonRequest msg, List<Object> out) throws Exception {
        //(1)调用父类的encode0，将业务需要发送的对象转换为Json,随后将它封装成Netty的ByteBuf
        ByteBuf body = encode0(ctx, msg.getBody());
        //(2) 如果业务自定义了HTTP消息头，则使用业务的消息头，否则在这里构造HTTP消息头
        // 这里使用硬编码的方式来写消息头，实际中可以写入配置文件
        FullHttpRequest request = msg.getRequest();
        if (request == null) {
            request = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1,
                    HttpMethod.GET, "/do", body);
            HttpHeaders headers = request.headers();
            headers.set(HttpHeaders.Names.HOST, InetAddress.getLocalHost()
                    .getHostAddress());
            headers.set(HttpHeaders.Names.CONNECTION, HttpHeaders.Values.CLOSE);
            headers.set(HttpHeaders.Names.ACCEPT_ENCODING,
                    HttpHeaders.Values.GZIP.toString() + ','
                            + HttpHeaders.Values.DEFLATE.toString());
            headers.set(HttpHeaders.Names.ACCEPT_CHARSET,
                    "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
            headers.set(HttpHeaders.Names.ACCEPT_LANGUAGE, "zh");
            headers.set(HttpHeaders.Names.USER_AGENT,
                    "Netty json Http Client side");
            headers.set(HttpHeaders.Names.ACCEPT,
                    "text/html,application/json;q=0.9,*/*;q=0.8");
        }
        /**
         * 由于请求消息体不为空,也没有使用Chunk方式,所以在Http消息头中设置消息体的长度Content-Length
         * 完成消息体的JSON序列化以后将重新构造的HTTP请求消息接入到out中,
         * 由后续Netty的HTTP请求编码器继续对HTTP请求消息进行编码
         */
        setContentLength(request, body.readableBytes());
        // (3) 编码后的对象
        out.add(request);
    }

}
