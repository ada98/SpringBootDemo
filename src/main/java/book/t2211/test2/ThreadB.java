package book.t2211.test2;

public class ThreadB extends Thread {
    private Service service;

    public ThreadB(Service service){
        super();
        this.service=service;
    }

    @Override
    public void run(){
        service.methodB();
    }

}
