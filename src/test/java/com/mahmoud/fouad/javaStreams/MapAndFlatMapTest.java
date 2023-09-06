package com.mahmoud.fouad.javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import junit.framework.TestCase;

@RunWith(JUnit4.class)
public class MapAndFlatMapTest extends TestCase{

    @Test
    public void testMap(){
       
        List<Person>persons =  Arrays.asList(
        Person.builder().name("first").phoneNo(Arrays.asList("1231","1244")).build(),
        Person.builder().name("second").phoneNo(Arrays.asList("2134","2244")).build(),
        Person.builder().name("thirs").phoneNo(Arrays.asList("3231","3244")).build()
        
        );

       List<List<String>> phones= persons.stream().map(p->p.getPhoneNo()).collect(Collectors.toList());
       System.out.println(" print map of persons pohnes");
       phones.forEach(phl-> phl.stream().forEach(System.out::println));
    }

    @Test
    public void testFlatMap(){
       
        List<Person>persons =  Arrays.asList(
        Person.builder().name("first").phoneNo(Arrays.asList("1231","1244")).build(),
        Person.builder().name("second").phoneNo(Arrays.asList("2134","2244")).build(),
        Person.builder().name("thirs").phoneNo(Arrays.asList("3231","3244")).build()
        
        );

       List<String> phones= persons.stream().flatMap(p->p.getPhoneNo().stream()).collect(Collectors.toList());
       System.out.println(" print flat map of persons pohnes");
       phones.forEach(System.out::println);
    }

}
