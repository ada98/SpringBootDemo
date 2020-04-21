package book.t229.test2;

public class ThreadC extends Thread {
    private book.t229.test2.Service service;

    public ThreadC(book.t229.test2.Service service){
        this.service=service;
    }

    @Override
    public void run(){
        service.printC();
    }

}
