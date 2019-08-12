package com.commons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;

public class Test {
	
	public static void main(String[] args) {
		
		HashMap<String, String> map = new HashMap<>();
		
		String response = "204";
		String response2 = "204";
//		
		String responseBody = response.substring(3);
		
		Integer responseStatus = Integer.parseInt(response.substring(0, 3));
		
		StringBuilder hello = new StringBuilder();
		
		hello = hello.append(","+"hello");
		
		String n = hello.substring(1);
		System.out.println(n);
		hello = hello.append(","+"world");
	
		String res = "(RM1-000064) The activity, LOAD NEW, cannot be performed on a resource or package entity (of type FNN, value 0260451335 and statusPENDING CONNECT).~~(RM1-000064) The activity, LOAD NEW, cannot be performed on a resource or package entity (of type FNN, value 0260451332 and statusPENDING CONNECT).|(RM1-000064) The activity, LOAD NEW, cannot be performed on a resource or package entity (of type FNN, value 0260451331 and statusPENDING CONNECT).";
		String ar[] = res.split("~~");
		
		System.out.println(ar[0]);
		
		for(int i=0; i< ar.length; i++) {
			
		}
		map.put("LRMNumber[Active].Numbers", "123,456");
		
		String a[] = map.get("LRMNumber[Active].Numbers").split(",");
		
		
		System.out.println(response.hashCode());
		System.out.println(response2.hashCode());
		System.out.println(response.hashCode() == response2.hashCode());
		System.out.println(hello);
		
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(1);
		set.add(2);
		set.add(3);
		
//		Optional<Integer> s  =  set.parallelStream().filter(a-> a.equals(2)).findFirst();
		
//		System.out.println(s.get());
		
		System.out.println(Pattern.matches("[a-zA-Z ]+Pending Transition[a-zA-Z ]+", "Update Number Pending Transition Status"));
		
	
	}

}
