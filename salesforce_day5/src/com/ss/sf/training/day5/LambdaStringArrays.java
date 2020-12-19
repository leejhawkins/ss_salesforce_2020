package com.ss.sf.training.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaStringArrays  {

	public static void main(String[] args) {
		
		List<String> stringArr = new ArrayList<>();
		stringArr.add("Elephant");
		stringArr.add("Rhinoceros");
		stringArr.add("Aardvark");
		stringArr.add("Hippopotamus");
		stringArr.add("Bear");
		stringArr.add("Emu");
		
		stringArr.sort((e1,e2) -> e1.length() - e2.length());
		System.out.println("Array sorted shortest to longest:");
		stringArr.forEach(animal -> System.out.println(animal));
		
		stringArr.sort((e1,e2) -> e2.length() - e1.length());
		System.out.println("\nArray sorted longest to shortest:");
		stringArr.forEach(animal -> System.out.println(animal));
		
		stringArr.sort((e1,e2) -> e1.charAt(0) - e2.charAt(0));
		System.out.println("\nArray sorted alphabetically by first letter:");
		stringArr.forEach(animal -> System.out.println(animal));
		
		stringArr.forEach(animal -> {
			if (animal.toLowerCase().charAt(0)=='e') {
				stringArr.forEach(a -> {
					if (a.toLowerCase().charAt(0) !='e' && stringArr.indexOf(animal) > stringArr.indexOf(a)) {
						Collections.swap(stringArr,stringArr.indexOf(a),stringArr.indexOf(animal));
						
					}
				});
				;
			}
		});
		System.out.println("\nArray sorted with e's up top :");
		stringArr.forEach(animal -> System.out.println(animal));
		
		
		

	}

}
