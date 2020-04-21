package book.t225;

public class ThreadB extends Thread {
    private ObjectService objectService;

    public ThreadB(ObjectService objectService) {
        this.objectService = objectService;
    }

    public void run(){
        objectService.ObjectMethodB();
    }

}
