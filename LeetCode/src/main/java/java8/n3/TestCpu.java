package java8.n3;

public class TestCpu {
    public static void main(String[] args) {
        new Thread(() -> {
            while(true) {
                /*try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }).start();
    }
}
