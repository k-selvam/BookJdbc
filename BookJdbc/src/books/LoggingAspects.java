package books;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class LoggingAspects {
	
	@Before("execution(* books.dao.BookDaoImpl.*(..))")
	public void myLogginAdviceBefore(JoinPoint jp) {
		System.out.println("\n\nThe method is "+jp.getSignature().getName());
	}
	
	@After("execution(* books.dao.BookDaoImpl.*(..))")
	public void myLogginAdviceAfter() {
		System.out.println("\n\nAfter advice");
	}
}