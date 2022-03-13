package deadLock;

public class DeadLock {
    public static void main(String arg[]){
        String s1="srk";
        String s2="rahul";
        Thread t1= new Thread() {
            @Override
            public void run() {
                synchronized (s1){
                    System.out.println(Thread.currentThread().getName());
                    synchronized (s2){
                        System.out.println(Thread.currentThread().getName());
                    }
                }

            }
        };

        Thread t2=new Thread(){
            @Override
            public void run() {
                synchronized (s2){
                    System.out.println(Thread.currentThread().getName());
                    synchronized (s1){
                        System.out.println(Thread.currentThread().getName());
                    }
                }

            }
        };
        t1.start();
        t2.start();
        System.out.println("main ends");
    }
}

