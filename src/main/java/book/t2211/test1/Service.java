package book.t2211.test1;

public class Service {
    synchronized public void methodA(){
        System.out.println(" A begin");
        boolean flag=true;
        while (flag){

        }
        System.out.println(" A end");
    }

    synchronized public void methodB(){
        System.out.println(" B begin");
        System.out.println(" B end");
    }

}
