import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;

@Aspect
public class Track_A {
	
	@Pointcut("execution(public * *(..))") //for all public method
	public void msg() {
		System.out.println("msg..() exec");
	}

	@Before("msg()")
	public void myadvice(JoinPoint jp) {
		System.out.println("before calling msg()");
	}

	@Pointcut("execution (* A.msg(..))")
	public void msg2() {
		System.out.println("msg() in track_A exc");
	}

	@After("msg()")
	public void myadvice2(JoinPoint jp)
	{
		System.out.println("after calling  A msg()");
		A o = (A) jp.getTarget();
		System.out.println(o);

	}

	@Around("msg()")
	public Object around(ProceedingJoinPoint jp) throws Throwable {
		//System.out.println("before calling around   A msg() : "+jp.proceed());
		jp.proceed();
		//System.out.println("after calling around   A msg() "+jp.proceed());
		return jp.proceed();
	}

	@AfterReturning("msg()")
	public void AfterReturning() {
		System.out.println("AfterReturning calling  A msg()");

	}
	
	//@AfterThrowing("msg()")
	public void AfterThrowing() {
		System.out.println("@AfterThrowing calling  A msg()");

	}
}
