package java8.test;

import lombok.extern.slf4j.Slf4j;

import static java8.n2.util.Sleeper.sleep;

@Slf4j(topic = "c.Test32")
public class Test32 {
    // 易变
    static boolean run = true;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while(run){

            }
        });
        t.start();

        sleep(1);
        log.debug("stop");
            run = false; // 线程t不会如预想的停下来
    }
}
