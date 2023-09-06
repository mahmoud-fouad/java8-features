package com.mahmoud.fouad.javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Data;
import lombok.Getter;

@Data
@Getter

public class JavaSteam {

	int counter = 0;

	List<String> data = Arrays.asList("mahmoud ahmed", "mohamed hussine", "Ai", "Osama mahmoud");

	public void visit() {

		counter++;
	}

	public void callFillterStreamWithoutFinalOperation() {
		data.stream().filter(str -> {
			visit();
			System.out.println(str);
			return str.contains("mahmoud");
		});
	}

	public void callFillterStreamWithFinalOperation(){
		data.stream().filter(str -> {
				visit();
				System.out.println(str) ;
				return str.contains("mahmoud");
		}
				).map(str-> str.toUpperCase()).collect(Collectors.toList());
	}

	

}
