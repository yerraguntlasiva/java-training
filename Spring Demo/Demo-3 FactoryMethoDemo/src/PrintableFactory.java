import com.beans.A;
import com.beans.Printable;
import com.javatpoint.A2;

public class PrintableFactory {  
    //non-static factory method  
    public Printable getPrintable(){  
        return new A();//return any one instance, either A or B  
    }  
    
    private  final A2 obj=new A2(); 
    public  A2 getA2(){  
        System.out.println("factory method ");  
        return obj;  
    }
}