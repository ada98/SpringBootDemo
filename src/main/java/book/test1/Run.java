package book.test1;

/**
 * 验证（1） 当多个线程同时执行synchronized(x){}同步代码块时呈同步效果
 */
public class Run {
    public static void main(String[] args) {
        MyObject object=new MyObject();
        Service service=new Service();
        Thread1 thread1=new Thread1(object,service);
        thread1.setName("a");
        Thread2 thread2=new Thread2(object,service);
        thread2.setName("b");
        thread1.start();
        thread2.start();
    }

}
