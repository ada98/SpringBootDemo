package book.t227;

import java.util.ArrayList;
import java.util.List;

/**
 * 重现逻辑错误
 */
public class MyOneList {
    private List list=new ArrayList<>();

    synchronized public void add(String data){
        list.add(data);
    }
    synchronized public int getSize(){
        return list.size();
    }

}
