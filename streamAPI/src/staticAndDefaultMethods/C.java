package staticAndDefaultMethods;

public interface C extends A, B {
	
	static void run() {
		System.out.println("Run() static from C interface");
	}
	
	default void start() {
		System.out.println(" start() default default from B interface");
		
	}

}
