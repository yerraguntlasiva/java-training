package suspend;

public class SuspendDemo {
    public static void main(String arg[]) throws InterruptedException {
        Demo d1=new Demo();
        d1.start();
        Demo d2=new Demo();
        d2.start();

        for (int i=0;i<=10;i++){
            System.out.println("main  :"+i);
            Thread.sleep(10000);
            if(i==3){
                d1.suspend();
            }
            if(i==9){
                d1.resume();

            }

        }
    }
}

class Demo extends Thread
{
    public void run()
    {
        for(int i=0;i<=10;i++)
        {

            if(Thread.currentThread().getName().equals("Thread-0")){

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(Thread.currentThread().getName()+" : "+i);


        }
    }
}