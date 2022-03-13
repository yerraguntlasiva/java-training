public class StringBuilderDemo {
    public static void main(String arg[])
    {
        Demo d1=new Demo();
        d1.start();
        Demo d2=new Demo();
        d2.start();
        for (int i=0;i<=10;i++){
            d1.interrupt();
        }
    }
}

class Demo extends Thread
{
    public void run()
    {
        for(int i=0;i<=10;i++)
        {

            if(Thread.currentThread().getName().equals("Thread-0") && i==5){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("awaken");
                }
            }
            System.out.println(Thread.currentThread().getName()+" : "+i);


        }
    }
}
