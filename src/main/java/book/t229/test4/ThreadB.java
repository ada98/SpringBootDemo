package book.t229.test4;

public class ThreadB extends Thread {
    private book.t229.test4.Service service;

    public ThreadB(book.t229.test4.Service service){
        this.service=service;
    }
    @Override
    public void run(){
        service.printB();
    }

}
