package com.phei.netty.protocol.http.json.codec;

import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author pengzhe
 * @date 2018/4/28 23:00
 * @description
 */

public class HttpJsonRequest {
    private FullHttpRequest request;
    private Object body;

    public HttpJsonRequest(FullHttpRequest request, Object body) {
        this.request = request;
        this.body = body;
    }

    /**
     * @return the request
     */
    public final FullHttpRequest getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public final void setRequest(FullHttpRequest request) {
        this.request = request;
    }

    /**
     * @return the object
     */
    public final Object getBody() {
        return body;
    }


    public final void setBody(Object body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "HttpJsonRequest [request=" + request + ", body =" + body + "]";
    }
}
