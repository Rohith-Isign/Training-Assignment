package staticAndDefaultMethods;

public interface A {

	static void run() {
		System.out.println("Run() static  from A interface");
	}
	
	default void start() {
		System.out.println(" start() default from A interface");
		
	}
}
