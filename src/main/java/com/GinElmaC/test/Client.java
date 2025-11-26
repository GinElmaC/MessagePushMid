package com.GinElmaC.test;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

public class Client {
    public static void main(String[] args) {
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup());
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.handler(new  ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringEncoder());
            }
        });
        ChannelFuture connect = bootstrap.connect("localhost", 8080);
        connect.addListener(f->{
            if(f.isSuccess()){
                System.out.println("客户端连接8080成功");
                connect.channel().writeAndFlush("connect success");
            }else{
                System.out.println("connect fail");
            }
        });
    }
}
