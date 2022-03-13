
public class A 
{
	int i=90;
	public int msg()
	{
		System.out.println("msg(); is called of class A");
		//throw new RuntimeException("just for test");
		return 2;
	}
	
	@Override
	public String toString() {
		return "A [i=" + i + "]";
	}
	
	
}
