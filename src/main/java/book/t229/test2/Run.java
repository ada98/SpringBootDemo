package book.t229.test2;

import book.t229.test1.ThreadA;
import book.t229.test1.ThreadB;

public class Run {
    public static void main(String[] args) {
        Service service=new Service();
        ThreadA threadA=new ThreadA();
        threadA.setName("a");
        ThreadB threadB=new ThreadB();
        threadB.setName("b");
        ThreadC threadC=new ThreadC(service);
        threadA.start();
        threadB.start();
        threadC.start();
    }

}
