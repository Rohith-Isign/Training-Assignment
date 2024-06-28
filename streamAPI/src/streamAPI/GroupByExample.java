package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupByExample {

	 public static void main(String[] args) {
	        List<Person> people = Arrays.asList(
//	            new Person("John", "New York"),
	            new Person("Jane", "Los Angeles"),
	            new Person("Jack", "New York"),
	            new Person("Jill", "Chicago"),
	            new Person("Jen", "Los Angeles")
	        );

	        // Group by city
	        Map<String, List<Person>> peopleByCity = people.stream()
	            .collect(Collectors.groupingBy(Person::getCity));

	    
	        peopleByCity.forEach((city, persons) -> {
	            System.out.println("City: " + city);
	            persons.forEach(person -> System.out.println("  " + person));
	        });
	        
	        
	        
	        System.out.println("\n \n");
//	        findAny
	        Optional<Person> findAnyPerson = people.stream().findAny();
	        System.out.println("Find any person: " + findAnyPerson.orElse(null));
	        
//	        findFirst
	        Optional<Person> findFirstPerson = people.stream().findFirst();
	        System.out.println("Find first person: " + findFirstPerson.orElse(null));
	        
	    }
	 
	 
}
