package book.t225;

public class ThreadA extends Thread {
    private ObjectService objectService;

    public ThreadA(ObjectService objectService) {
        this.objectService = objectService;
    }

    public void run(){
        objectService.ObjectMethodA();
    }

}
