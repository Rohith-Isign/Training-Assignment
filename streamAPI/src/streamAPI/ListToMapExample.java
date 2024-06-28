package streamAPI;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMapExample {
	public static void main(String[] args) {
        List<Integer> inte = Arrays.asList(1, 5, 3, 6, 8, 6, 8);

        List<Integer> list = inte.stream().distinct().map(e -> e + e).filter(e -> e % 2 == 0).sorted().collect(Collectors.toList());

        for (Integer integer : list) {
			System.out.println(integer);
		}//using list
     
        Map<Integer, Integer> map = inte.stream().distinct().map(e -> e + e).filter(e -> e % 2 == 0).sorted().collect(Collectors.toMap(e -> e, e -> e * 2));

        
        map.forEach((key, value) -> {
            System.out.println("Key: " + key + ", Value: " + value);
        });//using Map
    }

}
