package book.t229.test1;

public class Run {
    public static void main(String[] args) {
        ThreadA threadA=new ThreadA();
        threadA.setName("a");
        ThreadB threadB=new ThreadB();
        threadB.setName("b");
        threadA.start();
        threadB.start();
    }

}
