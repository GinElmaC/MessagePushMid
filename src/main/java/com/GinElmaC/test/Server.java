package com.GinElmaC.test;

import io.netty.bootstrap.ServerBootstrap;

public class Server {
    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        //boss线程组
        ServerBootstrap boss = new ServerBootstrap();
        //worker线程组
        ServerBootstrap worker = new ServerBootstrap();
        //配置线程组
        bootstrap.group()
    }
}
