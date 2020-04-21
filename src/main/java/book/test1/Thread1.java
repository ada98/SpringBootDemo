package book.test1;

public class Thread1 extends Thread{
    private MyObject object;
    private Service service;

    public Thread1(MyObject object,Service service){
        this.service=service;
        this.object=object;
    }

    @Override
    public void run(){
        super.run();
        service.testMethod1(object);
    }
}
