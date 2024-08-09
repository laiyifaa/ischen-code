package algorithm;

import javax.swing.*;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AutoTyping {

    private static boolean autoTypingActive = false;

    public static void main(String[] args) {
        System.out.println("按下 ctrl+f1 键启动自动按键功能...");
        System.out.println("按下 ctrl+f2 键停止自动按键功能...");
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 添加键盘事件监听器
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_F1 && e.isControlDown()) {
                    handleHotkeyEvent();
                } else if (e.getKeyCode() == KeyEvent.VK_F2 && e.isControlDown()) {
                    handleHotkeyEvent2();
                }
            }
        });

        // 显示窗口
        frame.setVisible(true);
    }

    private static void handleHotkeyEvent() {
        if (!autoTypingActive) {
            autoTypingActive = true;
            System.out.println("自动按键功能已启动");

            // 启动自动按键线程
            Thread autoTypingThread = new Thread(() -> {
                try {
                    Robot robot = new Robot();
                    while (autoTypingActive) {
                        // 模拟按下 'a' 键位
                        robot.keyPress(KeyEvent.VK_A);
                        Thread.sleep(randomInterval(2000, 4000));
                        robot.keyRelease(KeyEvent.VK_A);
                    }
                } catch (AWTException | InterruptedException e) {
                    e.printStackTrace();
                }
            });
            autoTypingThread.start();
        }
    }

    private static void handleHotkeyEvent2() {
        autoTypingActive = false;
        System.out.println("自动按键功能已停止");
    }

    private static int randomInterval(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }
}
