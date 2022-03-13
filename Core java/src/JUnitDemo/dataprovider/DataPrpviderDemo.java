package JUnitDemo.dataprovider;

import JUnitDemo.Caluclator;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.junit.*;
import org.junit.runner.RunWith;

@RunWith(DataProviderRunner.class)
public class DataPrpviderDemo {

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

    @DataProvider
    public static  Object[][] getData(){
        return new Object[][]{
                {2,2,4},
                {5,5,10},
                {10,10,30}
        };
    }

    @Test
    @UseDataProvider(value = "getData")
    public void testSum(int a, int b,int sum){
        int actualSum=caluclator.sum(a,b);
        Assert.assertEquals(actualSum,sum);
    }

    @Test
    @UseDataProvider(value = "getData")
    public void testSum2(int a, int b,int sum){
        int actualSum=caluclator.sum(a,b);
        Assert.assertEquals(actualSum,sum);
    }

}
