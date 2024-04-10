package javase.juc.thread.demo01;
/*
    测试类:
        1: 创建线程池类对象;
        2: 提交多个任务
 */
public class MyTest {
    public static void main(String[] args) {
        //1:创建线程池类对象;
        javase.juc.demo.demo01.MyThreadPool pool = new javase.juc.demo.demo01.MyThreadPool(2,4,20);
        //2: 提交多个任务
        for (int i = 0; i <30 ; i++) {
            //3:创建任务对象,并提交给线程池
            javase.juc.demo.demo01.MyTask my = new javase.juc.demo.demo01.MyTask(i);
            pool.submit(my);
        }
    }
}
