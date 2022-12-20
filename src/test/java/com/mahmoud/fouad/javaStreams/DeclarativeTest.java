package com.mahmoud.fouad.javaStreams;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DeclarativeTest {

	// use imperative and declarative to get odd numners
	@Test
	public void oddNumber() {
		List<Integer> numbers = Arrays.asList(1, 2, 4, 7, 9, 5);

		// imperative way
		List<Integer> imperiveList = new ArrayList<Integer>();
		for (int i : numbers) {
			if (i % 2 != 0)
				imperiveList.add(i);
		}

		// declarative
		List<Integer> declarativeList = numbers.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());

		assertArrayEquals(imperiveList.toArray(), declarativeList.toArray());

	}

	// use imperative and declarative use lambda expression to print dat
	@Test
	public void printData() {
		List<String> names = Arrays.asList("mahmoud", "ahmed", "fouad");

		// imperative way
		for (String name : names) {
			System.out.println(name.toUpperCase());
		}
		System.out.println("print in declarative way");
		names.stream().map(na -> na.toUpperCase()).forEach(System.out::println);

	}

	// use imperative and declarative use lambda expression to print dat
	@Test
	public void EvenNumsSum() {
		List<Integer> numbers = Arrays.asList(1, 2, 4, 7, 9, 5);

		// imperative way
		int  imperiveSum =0;
		for (int i : numbers) {
			if (i % 2 == 0)
				imperiveSum+=i;
		}

		// declarative
		int declarativeSum= numbers.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();

		assertEquals(imperiveSum, declarativeSum);

	}

}
