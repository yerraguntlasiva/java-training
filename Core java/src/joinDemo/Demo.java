package joinDemo;

public class Demo {
    public static void main(String arg[]) throws InterruptedException {
        Demo23 d = new Demo23();
        d.start();
        for(int i=0;i<=10;i++){
            System.out.println("main : "+i);

            if(i==5){
                d.join();
            }
        }


    }
}

class Demo23 extends Thread
{
    public void run()
    {
        for(int i=0;i<=10;i++)
        {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            System.out.println(Thread.currentThread().getName()+" : "+i);


        }
    }
}