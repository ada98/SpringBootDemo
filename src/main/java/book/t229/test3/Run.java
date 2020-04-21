package book.t229.test3;

public class Run {
    public static void main(String[] args) {
        Service service1=new Service();
        Service service2=new Service();
        ThreadA threadA=new ThreadA(service1);
        threadA.setName("a");
        ThreadB threadB=new ThreadB(service2);
        threadB.setName("b");
        threadA.start();
        threadB.start();
    }

}
