package algorithm;

//静态内部类
public class Singleton {
    private Singleton(){

    }
    private static class Holder{
        private static final Singleton instance = new Singleton();
    }
    public static Singleton getInstance(){
        return Holder.instance;
    }

}
//双重检查
class Singleton_1{
    //防止指令重排
    private static  volatile Singleton_1 instance = null;
    private Singleton_1(){

    }
    public static Singleton_1 getInstance(){
        if(null == instance){
            //同步代码块只在第一次获取对象时执行，后续就是非null了
            synchronized (Singleton_1.class){
                if(null == instance){
                    instance = new Singleton_1();
                }
            }
        }
        return instance;
    }
}
