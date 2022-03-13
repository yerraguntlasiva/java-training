package synchronize;


public class SynchornozedDemo {
    public static void main(String arg[]) throws InterruptedException {
        Table t1=new Table();
        Demo d1 = new Demo(t1);
        d1.start();
        Demo d2 = new Demo(t1);
        d2.start();

    }
}
class Demo extends Thread
{
    Table t;
    Demo(Table t){
        this.t=t;

    }
    public void run()
    {
        //t.printTable(5);
        try {
            t.printTable(5);//static synch
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

class Table{
    synchronized   public void printTable(int a) throws InterruptedException {
        for(int i=1;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+" : "+(a*i));
            Thread.sleep(1000);

        }
    }
}

class Table2{
    public void printTable(int a){
        for(int i=1;i<=10;i++){
            System.out.println("Non Synch : "+Thread.currentThread().getName());
            synchronized (this){
                System.out.println(Thread.currentThread().getName()+" : "+(a*i));
            }

        }
    }
}