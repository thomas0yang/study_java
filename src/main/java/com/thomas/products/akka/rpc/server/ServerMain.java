package com.thomas.products.akka.rpc.server;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.thomas.products.akka.rpc.example.ExampleInterface;
import com.thomas.products.akka.rpc.example.ExampleInterfaceImpl;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * https://my.oschina.net/fengj/blog/268387
 *
 * 目前的工作在基于akka实现数据服务总线，Akka 2.3中提供了 Cluster Sharing(分片集群)和Persistence功能
 * 可以很简单的写出一个大型的分布式集群的架构。里面的一块功能就是RPC（远程过程调用），这篇文章将会介绍一种实现方式。
 * akka rpc java
 * 目录[-]
 * akka-rpc（基于akka的rpc的实现）
 * RPC
 * 实现原理
 * Server端核心代码
 * Client端核心代码
 * Demo
 * akka-rpc（基于akka的rpc的实现）
 * <p>
 * 代码：http://git.oschina.net/for-1988/Simples
 * <p>
 * 目前的工作在基于akka（java）实现数据服务总线，
 * Akka 2.3中提供了 Cluster Sharing(分片集群)和Persistence功能可以很简单的写出一个大型的分布式集群的架构。
 * 里面的一块功能就是RPC（远程过程调用）。
 * <p>
 * RPC
 * <p>
 * 远程过程调用（Remote Procedure Call，RPC）是一个计算机通信协议。
 * 该协议允许运行于一台计算机的程序调用另一台计算机的子程序，而程序员无需额外地为这个交互作用编程。
 * 如果涉及的软件采用面向对象编程，那么远程过程调用亦可称作远程调用或远程方法调用，例：Java RMI。
 * <p>
 * 实现原理
 * <p>
 * 整个RPC的调用过程完全基于akka来传递对象，因为需要进行网络通信，
 * 所以我们的接口实现类、调用参数以及返回值都需要实现java序列化接口。
 * 客户端跟服务端其实都是在一个Akka 集群关系中，Client跟Server都是集群中的一个节点。
 * 首先Client需要初始化RpcClient对象，在初始化的过程中，我们启动了AkkaSystem，加入到整个集群中，并创建了负责与Server进行通信的Actor。
 * 然后通过RpcClient中的getBean(Class<T> clz)方法获取Server端的接口实现类的实例对象，然后通过动态代理拦截这个对象的所有方法。
 * 最后，在执行方法的时候，在RpcBeanProxy中向Server发送CallMethod事件，执行远程实现类的方法，获取返回值给Client。
 * <p>
 * Server端核心代码
 */
public class ServerMain {

    public static void main(String[] args) {
        final Config config = ConfigFactory
                .parseString("akka.remote.netty.tcp.port=" + 2551)
                .withFallback(
                        ConfigFactory
                                .parseString("akka.cluster.roles = [RpcServer]"))
                .withFallback(ConfigFactory.load());

        ActorSystem system = ActorSystem.create("EsbSystem", config);

        // Server 加入发布的服务
        Map<Class<?>, Object> beans = new HashMap<Class<?>, Object>();
        beans.put(ExampleInterface.class, new ExampleInterfaceImpl());
        system.actorOf(Props.create(RpcServerActor.class, beans), "rpcServer");
    }
}