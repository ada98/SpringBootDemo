package book.t230;

public class Service {
    public  void print(Object str){
        try {
            synchronized (str){
                while (true){
                    System.out.println("threadName:"+Thread.currentThread().getName()+" str:"+str);
                    Thread.sleep(200);
                }
            }
        }catch (Exception e){

        }
    }
}
