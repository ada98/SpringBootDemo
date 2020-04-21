package book.t224;

/**
 * 测试一半同步，一半不同步;
 * 写了synchronized关键字的代码块会同步排队执行，没有的按线程特性随机执行
 */
public class Task {
    public void doLongTimeTask(){
        for(int i=0;i<20;i++){
            System.out.println("nosynchronized threadName="+Thread.currentThread().getName()+" i="+(i+1) );
        }
        System.out.println("");
        synchronized (this){
            for(int i=0;i<10;i++){
                System.out.println("synchronized threadName="+Thread.currentThread().getName()+" i="+(i+1) );
            }
        }
    }
}
