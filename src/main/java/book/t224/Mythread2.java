package book.t224;

public class Mythread2 extends Thread{
    private Task task;

    public Mythread2(Task task) {
        this.task = task;
    }

    public void run(){
        super.run();
        task.doLongTimeTask();
    }

}
