package book.t229.test2;

import book.t229.test1.Service;

public class ThreadB extends Thread {
    @Override
    public void run(){
        Service.printB();
    }

}
