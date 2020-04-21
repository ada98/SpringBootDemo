package book.t229.test3;

public class ThreadB extends Thread {
    private book.t229.test3.Service service;

    public ThreadB(book.t229.test3.Service service){
        this.service=service;
    }
    @Override
    public void run(){
        service.printB();
    }

}
