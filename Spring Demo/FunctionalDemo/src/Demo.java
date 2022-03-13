
public class Demo {

	public static void main(String[] args) {

		I1 i2=()->{
			System.out.println("show is working");
		};
		i2.show();
	}

}


class A implements I1{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
}

class B implements I1{

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
}


