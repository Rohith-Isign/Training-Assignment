package streamAPI;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SequentialProcessingEx {

	public static void main(String[] args) {
		List<Integer> preOpe = IntStream.range(0, 1000000).boxed().collect(Collectors.toList());
		long startTime = System.currentTimeMillis();
		List<Integer> postOpe = preOpe.parallelStream().map(e->e+e).sorted().filter(e->e%2==0).collect(Collectors.toList());
		long endTime = System.currentTimeMillis();
		System.out.println("Processing time of Parallel Streams : "+ (endTime-startTime));
	}
}
