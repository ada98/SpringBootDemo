package book.t2211.test2;

public class Service {
    Object objectA=new Object();
    Object objectB=new Object();
    public void methodA(){
        synchronized(objectA){
            System.out.println(" A begin");
            boolean flag=true;
            while (flag){

            }
            System.out.println(" A end");
        }
    }

    public void methodB(){
        synchronized(objectB){
            System.out.println(" B begin");
            System.out.println(" B end");
        }
    }

}
