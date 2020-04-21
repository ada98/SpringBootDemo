package book.t229.test1;

public class ThreadB extends Thread {
    @Override
    public void run(){
        Service.printB();
    }

}
