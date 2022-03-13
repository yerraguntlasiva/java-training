
import org.springframework.context.ApplicationContext;  
import org.springframework.context.support.ClassPathXmlApplicationContext;  
public class Main_Class{  
    public static void main(String[] args){  
        ApplicationContext context = new ClassPathXmlApplicationContext("annotaion_aop.xml");  
        A e = (A) context.getBean("opBean");   
        System.out.println("amin msg : "+e.msg());  
         
    }  
}