package book.t224;

public class Run {
    public static void main(String[] args) {
        int num=0;
        System.out.println(num>0);
        Task task=new Task();
        Mythread1 mythread1=new Mythread1(task);
        mythread1.start();
        Mythread2 mythread2=new Mythread2(task);
        mythread2.start();
    }

}
