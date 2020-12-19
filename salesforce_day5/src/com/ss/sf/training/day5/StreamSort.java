package com.ss.sf.training.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strArr = new ArrayList<>();
		strArr.add("add");
		strArr.add("dining");
		strArr.add("able");
		strArr.add("bear");
		strArr.add("bold");
		strArr.add("jaguar");
		strArr.add("and");
		strArr.add("alt");
		
		Stream<String> threeAArr = strArr.stream().filter(n -> n.length() == 3 & n.charAt(0) == 'a');
		System.out.println("Words that start with 'a' and have three letters:\n");
		threeAArr.forEach(e -> System.out.println(e));
		
	}

}
