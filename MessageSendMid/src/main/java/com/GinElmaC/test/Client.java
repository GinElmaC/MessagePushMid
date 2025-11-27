package com.GinElmaC.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
        Message message = new Message();

        final ObjectMapper mapper = new ObjectMapper();
        User user = new User("aa",12,"this");
        Message message1 = new Message();
        try {
            message1.setDate(mapper.writeValueAsString(user));
        } catch (JsonProcessingException e) {
            System.out.println("json转化失败");
        }

        connect.addListener(f->{
            if(f.isSuccess()){
                System.out.println("客户端连接8080成功");
                connect.channel().writeAndFlush(message1);
            }else{
                System.out.println("connect fail");
            }
        });
    }
}
