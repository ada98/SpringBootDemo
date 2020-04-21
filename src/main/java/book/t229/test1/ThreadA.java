package book.t229.test1;

public class ThreadA extends Thread {
    @Override
    public void run(){
        Service.printA();
    }

}
