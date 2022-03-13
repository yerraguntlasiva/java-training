package waitDemo;

public class ThreadInterCommunication {
    public static void main(String arg[]){
        Consumer c1=new Consumer();
        Thread t1= new Thread() {
            @Override
            public void run() {
                try {
                    c1.cosume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Thread t2=new Thread(){
            @Override
            public void run() {
                try {
                    c1.suply();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
        t2.start();
        System.out.println("main ends");
    }
}

class Consumer{
    synchronized  public void cosume() throws InterruptedException {
        for(int i=0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
            if(i==4){
                wait();
            }
        }
    }

    synchronized public void suply() throws InterruptedException {
        for(int i=0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
            Thread.sleep(1000);

        }
        notify();
    }
}

class Supplier{
    public void suply() throws InterruptedException {
        for(int i=0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
            if(i==8){
                notify();
            }
        }
    }
}
