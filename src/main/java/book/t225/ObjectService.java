package book.t225;

/**
 * 测试同步代码块间的同步性
 */
public class ObjectService {
    public void ObjectMethodA(){
        try {
            synchronized (this){
                System.out.println("A begin time="+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("A end time="+System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void ObjectMethodB(){
        try {
            synchronized (this){
                System.out.println("B begin time="+System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("B end time="+System.currentTimeMillis());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
