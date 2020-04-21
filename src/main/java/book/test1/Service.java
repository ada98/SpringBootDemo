package book.test1;

public class Service {
    public void testMethod1(MyObject object)  {
        synchronized (object){
            try {
                System.out.println("testMethod1_lockTime:"+System.currentTimeMillis()+" runName:"+Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod1_releaseTime:"+System.currentTimeMillis()+" runName:"+Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
