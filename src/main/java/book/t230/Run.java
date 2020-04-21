package book.t230;

public class Run {
    public static void main(String[] args) {
        Service service=new Service();
        ThreadA threadA=new ThreadA(service);
        threadA.setName("a");
        threadA.start();
        ThreadB threadB=new ThreadB(service);
        threadB.setName("b");
        threadB.start();
    }

}
