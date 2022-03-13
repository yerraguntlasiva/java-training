package threadGroup;

public class Demo {
    public  static void  main(String arg[]) throws InterruptedException {
        ThreadGroup th=new ThreadGroup("srk");
        Thread t1=new Thread(th,new Run(),"One");
        Thread t2=new Thread(th,new Run(),"Two");
        Thread t3=new Thread(th,new Run(),"Three");
        t1.start();
        t2.start();
        t3.start();
        th.list();

        for (int i=0;i<=10;i++){
            System.out.println("amin : "+i);

            if(i==1){
                th.suspend();

            }
            if(i>8){
                th.resume();
                Thread.sleep(1000);


            }

            //System.out.println("active count : "+th.activeCount());
            //System.out.println("active count : "+th.activeGroupCount());//sub thread group

        }
    }
}

class Run extends Thread{

    Run(){

    }
    @Override
    public void run() {
        for (int i=0;i<=10;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }
}
