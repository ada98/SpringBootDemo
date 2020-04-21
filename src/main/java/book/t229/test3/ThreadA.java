package book.t229.test3;

public class ThreadA extends Thread {
    private book.t229.test3.Service service;

    public ThreadA(book.t229.test3.Service service){
        this.service=service;
    }

    @Override
    public void run(){
        service.printA();
    }

}
