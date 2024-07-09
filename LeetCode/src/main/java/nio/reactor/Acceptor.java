package nio.reactor;

import nio.SubReactor;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Acceptor主要用于处理连接操作
 */
public class Acceptor implements Runnable{

    private final ServerSocketChannel serverChannel;   //只需要一个ServerSocketChannel就行了

    public Acceptor(ServerSocketChannel serverChannel) {
        this.serverChannel = serverChannel;
    }

    @Override
    public void run() {
        try{
            SocketChannel channel = serverChannel.accept();   //还是正常进行Accept操作，得到SocketChannel
            System.out.println(Thread.currentThread().getName()+" >> 客户端已连接，IP地址为："+channel.getRemoteAddress());
            channel.configureBlocking(false);
            Selector selector = SubReactor.nextSelector();   //选取下一个从Reactor的Selector
            selector.wakeup();    //在注册之前唤醒一下防止卡死
            channel.register(selector, SelectionKey.OP_READ, new Handler(channel));  //注意现在注册的是从Reactor的Selector
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}