package book.t229.test4;

public class Service {
      public static void printA(){
          synchronized(Service.class){
              try{
                  System.out.println("线程名称："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"进入printA");
                  Thread.sleep(2000);
                  System.out.println(" 线程名称："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"离开printA");
              }catch (Exception e){

              }
          }
    }

    synchronized  public static void printB(){
        synchronized (Service.class){
            try{
                System.out.println("线程名称："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"进入printB");
                Thread.sleep(2000);
                System.out.println(" 线程名称："+Thread.currentThread().getName()+"在"+System.currentTimeMillis()+"离开printB");
            }catch (Exception e){

            }
        }
    }
}
