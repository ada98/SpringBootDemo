package book.t225;

public class Run {
    public static void main(String[] args) {
        ObjectService objectService=new ObjectService();
        ThreadA threadA=new ThreadA(objectService);

        ThreadB threadB=new ThreadB(objectService);
        threadB.start();
        threadA.start();
    }
}
