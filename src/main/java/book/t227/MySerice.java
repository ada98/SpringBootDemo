package book.t227;

public class MySerice {

    public MyOneList addServiceMethod(MyOneList list,String data){
        try{
            if(list.getSize()<1){
                Thread.sleep(2000);//模拟从远程取数据2s
                list.add(data);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return list;
    }

}
