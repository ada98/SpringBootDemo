package book.t229.test4;

public class ThreadA extends Thread {
    private book.t229.test4.Service service;

    public ThreadA(book.t229.test4.Service service){
        this.service=service;
    }

    @Override
    public void run(){
        service.printA();
    }

}
