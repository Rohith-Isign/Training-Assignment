package staticAndDefaultMethods;

public interface B {
	
	static void run() {
		System.out.println("Run() static from B interface");
	}

	default void start() {
		System.out.println(" start() default from B interface");
		
	}
}
