package book.t224;

public class Mythread1 extends Thread {
    private Task task;

    public Mythread1(Task task) {
        this.task = task;
    }

    public void run(){
        super.run();
        task.doLongTimeTask();
    }

}
