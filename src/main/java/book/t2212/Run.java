package book.t2212;

public class Run {
    public static void main(String[] args) {
        try{
            DealThread t1=new DealThread();
            Thread thread1=new Thread(t1);
            t1.setUsername("a");
            thread1.start();
            Thread.sleep(1000);
            t1.setUsername("b");
            Thread thread2=new Thread(t1);
            thread2.start();
        }catch (Exception e){

        }

    }
}
