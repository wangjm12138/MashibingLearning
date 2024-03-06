package com.jackiewang.RPC.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

public class RPCNettyServer {

    public static void main(String[] args) {

        MyCar car = new MyCar();
        MyFly fly = new MyFly();

        Dispather dis = new Dispatcher();

        NioEventLoopGroup boss = new NioEventLoopGroup(20);
        NioEventLoopGroup worker = boss;

        ServerBootstrap sbs =  new ServerBootstrap();
        ChannelFuture bind = sbs.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                        System.out.println("server accept client port: " + nioSocketChannel.remoteAddress().getPort());
                        ChannelPipeline p = nioSocketChannel.pipeline();
                        p.addLast(new ServerDecode());
                        p.addLast(new ServerRequestHandler(dis));
                    }
                }).bind(new InetSocketAddress("127.0.0.1",9090));

        try {
            bind.sync().channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
