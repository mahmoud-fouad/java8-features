package com.mahmoud.fouad.javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
@RunWith(JUnit4.class)
public class StreamTest extends TestCase {
	/**
	 * Call intermediate operation without final operation
	 */
	public void testInteranlWithoutFinal() {
		
		JavaSteam stream =new JavaSteam();
		// as the filter is intermediate operation the operation will not be executed unit final operation executed 
		stream.callFillterStreamWithoutFinalOperation();
		// as this is no final operation
//		the internal operation will not be executed
		assertEquals(0, stream.getCounter());
	}

	/**
	 * 
	 */

	/**
	 * Call intermediate operation then call final operation
	 */
	@Test
	public void testInteranlWithFinal() {
		
		JavaSteam stream =new JavaSteam();
		// as the filter is intermediate operation the operation will not be executed unit final operation executed 
		stream.callFillterStreamWithFinalOperation();
		// as this is no final operation
//		the internal operation will  be executed
		assertEquals(stream.getData().size(), stream.getCounter());
	}

	/**
	 * stream doesn't create data as it is not a collection 
	 */
	@Test
	public void evenNum(){
		
		// if stream creates data system should throw stack overflow as this is infinite numbers 
		Stream <Integer> numbers = Stream.iterate(0,i->i+1 );
		List<Integer> result = numbers.filter( i -> i %2 ==0 )
				.limit(10)
				.collect(Collectors.toList());
		
		assertEquals(10 , result.size());
				
	}
	
	
	@Rule
	public ExpectedException  exceptionRule = ExpectedException.none();
	/**
	 * stream traversed once only 
	 */
	@Test
	public void streamTravers(){
		
		List<Integer> data = Arrays.asList(2,10,8,6,9);
		Stream<Integer> filterData = data.stream().filter(num -> num > 7);
		
		filterData.forEach(num -> System.out.println(num));
		
		// assert that method throws IllegalStateException
		exceptionRule.expect(IllegalStateException.class);
		
		// Traversal methods can not be called more that one 
		filterData.forEach(num -> System.out.println(num));		
		
	}

	@Test
	public  void sortListUsingSortedLambda(){
List<Person> data = new ArrayList<>();
data.add(Person.builder().name("mahmoud").build());
data.add(Person.builder().name("ahmed").build());
data.add(Person.builder().name("fouad").build());

data.stream().sorted((o1, o2) -> o1.getName().compareTo(o2.getName())).forEach(e-> System.out.println(e));

	}

	@Test
	public  void sortListUsingComparatorLambda(){
List<Person> data = new ArrayList<>();
data.add(Person.builder().name("mahmoud").build());
data.add(Person.builder().name("ahmed").build());
data.add(Person.builder().name("fouad").build());

data.stream().sorted(Comparator.comparing(pers->pers.getName())).forEach(e-> System.out.println(e));

	}

	@Test
	public void sortMap(){
		Map<String,Integer> numbers = new java.util.Hashtable<>();
		numbers.put("eight", 8);
		numbers.put("four", 4);
		numbers.put("ten", 10);
		numbers.put("one", 1);

		 List<Entry<String, Integer>> keySet =new ArrayList<Entry<String, Integer>>(numbers.entrySet());

		 Collections.sort(keySet,new Comparator<Entry<String, Integer>>() {
			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				return o1.getValue() .compareTo(o2.getValue());
			}
		 });

		 System.out.println("print sorted map");
		 for(Entry<String, Integer>entyr: keySet ){
			System.out.println(entyr.getValue());
		 }

	}

	@Test
	public void sortMapLambda(){
		Map<String,Integer> numbers = new java.util.Hashtable<>();
		numbers.put("eight", 8);
		numbers.put("four", 4);
		numbers.put("ten", 10);
		numbers.put("one", 1);

		 List<Entry<String, Integer>> keySet =new ArrayList<Entry<String, Integer>>(numbers.entrySet());

		
		 Collections.sort(keySet
		 ,( o1, o2) -> o1.getValue() .compareTo(o2.getValue()));

		 System.out.println("print lambda sorted map");
		 for(Entry<String, Integer>entyr: keySet ){
			System.out.println(entyr.getValue());
		 }
	}

	@Test
	public void sortMapLambdaStream(){
		Map<String,Integer> numbers = new java.util.Hashtable<>();
		numbers.put("eight", 8);
		numbers.put("four", 4);
		numbers.put("ten", 10);
		numbers.put("one", 1);

 System.out.println("print stream sorted by value map");

		numbers.entrySet().stream().sorted(
			(o1,o2)->o1.getValue().compareTo(o2.getValue())
			).forEach(System.out::println);

			

			System.out.println("print stream sorted by key map");

			numbers.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

			//numbers.entrySet().forEach((entyr)->System.out.println(entyr.getValue()));
	}

	@Test
	public void sortPersonMapLambdaStream(){
		Map<String,Person> numbers = new java.util.Hashtable<>();
		numbers.put("eight", Person.builder().salary(8).build() );
		numbers.put("four", Person.builder().salary(4).build());
		numbers.put("ten", Person.builder().salary(10).build());
		numbers.put("one", Person.builder().salary(1).build());

 System.out.println("print stream sorted Person by value map");

		numbers.entrySet().stream().sorted(
			(o1,o2)->o1.getValue().getSalary().compareTo(o2.getValue().getSalary())
			).forEach(System.out::println);

			

			System.out.println("print stream sorted Person by value with comparator");

			numbers.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.comparing(Person::getSalary))).forEach(System.out::println);

			
	}
}
