package JUnitDemo.parameterized;

import JUnitDemo.Caluclator;
import junit.framework.JUnit4TestAdapter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
@RunWith(Parameterized.class)
public class ParameterizedDemo {

    int a,b,sum;
    public ParameterizedDemo(int a,int b,int sum){
        this.a=a;
        this.b=b;
        this.sum=sum;
    }
  static Caluclator caluclator=new Caluclator();
    @Parameterized.Parameters
    public static Collection values(){
        return Arrays.asList(new Object[][]{
                {2,2,4},
                {5,5,10},
                {10,10,30}
        });
    }

    @Test
    public void testWithParam(){
        int sum2=caluclator.sum(a,b);
        Assert.assertEquals(sum,sum2);
    }
    @Test
    public void test2(){
        System.out.println("test2 "+a+ " :"+b+ "  : "+sum);
        Assert.assertEquals(10,10);
    }
}
