package book.t2211.test1;

/**
 * 验证同步synchronized无限等待
 */
public class Run {
    public static void main(String[] args) {
        Service service=new Service();
        ThreadA threadA=new ThreadA(service);
        ThreadB threadB=new ThreadB(service);
        threadA.start();
        threadB.start();
    }

}
