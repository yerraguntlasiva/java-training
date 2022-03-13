package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public  static void  main(String arg[]){
        ExecutorService executorService= Executors.newCachedThreadPool();//newFixedThreadPool(5);
        for(int i=0;i<=10;i++){
            Runnable r=new Worker(""+i);
            executorService.execute(r);
        }
    }
}

class Worker implements  Runnable{
    String message;
    Worker(String message){
        this.message=message;
    }
    @Override
   public void run() {
        System.out.println(Thread.currentThread().getName()+" : " +this.message);
    }
}