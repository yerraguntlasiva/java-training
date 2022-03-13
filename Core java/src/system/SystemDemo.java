package system;

import java.util.Enumeration;
import java.util.Properties;

public class SystemDemo {
    public static void main(String[] arg){
        Properties p=System.getProperties();
        Enumeration em=p.propertyNames();
        while (em.hasMoreElements()){
            System.out.println(p.getProperty((String) em.nextElement()));
        }
    }
}
