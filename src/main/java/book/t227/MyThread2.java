package book.t227;

public class MyThread2 extends Thread {
    private MyOneList list;
    public MyThread2(MyOneList list){
        super();
        this.list=list;
    }
    @Override
    public void run(){
        MySerice msRef=new MySerice();
        msRef.addServiceMethod(list,"B");
    }
}
