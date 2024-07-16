package nio.practice;

import lombok.extern.slf4j.Slf4j;
import nio.ByteBufferUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;


@Slf4j
public class TestServer {
    public static  void main(String[] args) throws IOException {// 使用 nio 来理解阻塞模式, 单线程
// 0. ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
// 1. 创建了服务器
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);
// 2. 绑定监听端口
        ssc.bind(new InetSocketAddress(8081));

// 3. 连接集合
        ArrayList<SocketChannel> channels = new ArrayList<>();
        while (true) {
            SocketChannel sc = ssc.accept(); // 非阻塞，线程还会继续运行，如果没有连接建立，但sc是null
            if (sc != null) {
                log.debug("connected... {}", sc);
                sc.configureBlocking(false); // 非阻塞模式
                channels.add(sc);
            }
            for (SocketChannel channel : channels) {
                // 5. 接收客户端发送的数据
                int read = channel.read(buffer);// 非阻塞，线程仍然会继续运行，如果没有读到数据，read 返回 0
                if (read > 0) {
                    buffer.flip();
                    ByteBufferUtil.debugRead(buffer);
                    buffer.clear();
                    log.debug("after read...{}", channel);
                }
            }
        }
    }
}
