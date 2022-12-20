package com.mahmoud.fouad.javaStreams;

import java.util.Arrays;
import java.util.List;
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
}
