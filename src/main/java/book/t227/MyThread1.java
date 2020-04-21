package book.t227;

public class MyThread1 extends Thread {
    private MyOneList list;
    public MyThread1(MyOneList list){
        super();
        this.list=list;
    }
    @Override
    public void run(){
        MySerice msRef=new MySerice();
        msRef.addServiceMethod(list,"A");
    }
}
