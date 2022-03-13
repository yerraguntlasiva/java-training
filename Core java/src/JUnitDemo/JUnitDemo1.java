package JUnitDemo;


import com.sun.org.glassfish.gmbal.ParameterNames;
import junit.framework.JUnit4TestAdapter;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class JUnitDemo1 {
    public static void main(String[] arg){

    }

    static Caluclator caluclator=null;
    @BeforeClass
    public static  void beForeClass(){
        System.out.println("Before class");
        caluclator=new Caluclator();
    }

    @Before
    public  void Before(){
        System.out.println("Before");
        if(caluclator==null){
            //throw new RuntimeException("Caluclator is not initilized");
        }
    }

    @AfterClass
    public static  void afterClass(){
        System.out.println("afterClass");
    }

    @After
    public void after()
    {
        System.out.println("After ");
    }
    @Test(timeout = 100)
    public void testSum() throws InterruptedException {
        int f=caluclator.sum(5,5);
        Thread.sleep(1);
        Assert.assertEquals(f,10,0.0);

    }

    @Test(expected = NullPointerException.class)
    public void testSumNullpointerException()
    {
        System.out.println("null1 pointer came ");
        int f=caluclator.sum(5,5);
        System.out.println("null pointer came ");
    }

    @Test
    public void testSub(){
        int f=caluclator.sub(10,5);
        Assert.assertEquals(f,5,0.0);
    }
    @Test
    public void testDiv(){
        float f=caluclator.div(5,5);
        Assert.assertEquals(f,1,0.0);
    }
    @Test
    public void testMul(){
        int f=caluclator.mul(5,5);
        Assert.assertEquals(f,25,0.0);
    }
}



