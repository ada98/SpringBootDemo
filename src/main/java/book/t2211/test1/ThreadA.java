package book.t2211.test1;


public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service){
        super();
        this.service=service;
    }

    @Override
    public void run(){
        service.methodA();
    }

}
