package book.test1;

public class Thread2 extends Thread{
    private MyObject object;
    private Service service;

    public Thread2(MyObject object, Service service){
        this.service=service;
        this.object=object;
    }

    @Override
    public void run(){
        super.run();
        service.testMethod1(object);
    }
}
