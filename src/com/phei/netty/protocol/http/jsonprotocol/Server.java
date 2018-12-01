package com.phei.netty.protocol.http.jsonprotocol;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;


/**
 * @author pengzhe
 * @date 2018-12-01 23:30
 * @description
 */

public class Server {
    //创建起步程序
    public static void main(String[] argsStrings) throws Exception {


        //配置服务端NIO线程组(boss线程、worker线程)
        EventLoopGroup bGroup = new NioEventLoopGroup();
        EventLoopGroup wGroup = new NioEventLoopGroup();
        //创建启动辅助类
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bGroup, wGroup)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        //httpReq解码器
                        channel.pipeline().addLast(new HttpRequestDecoder());
                        //转换成fullhttp对象
                        channel.pipeline().addLast(new HttpObjectAggregator(2048));
                        //httpRes编码器
                        channel.pipeline().addLast(new HttpResponseEncoder());
                        channel.pipeline().addLast(new MyServerHandler());
                    }

                });

        try {
            //监听本地端口,同步等待监听结果
            ChannelFuture future = bootstrap.bind(8082).sync();
            //等待服务端监听端口关闭,优雅退出
            future.channel().closeFuture().sync();
        } finally {
            bGroup.shutdownGracefully();
            wGroup.shutdownGracefully();
        }


    }
}
