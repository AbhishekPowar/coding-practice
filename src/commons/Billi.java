package com.commons;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;


public class Billi {
	
	public static int getMin(int[] ar) {
		
		int size = ar.length;
		
		Map<Integer, Integer> map= new TreeMap();
		
		
		for(int i=0; i<size-1; i++) {
			int count = 1;
			if(ar[i] > ar[i+1]) {
				count++;
			} else {
				map.put(count, i);
				break;
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int errorCode = 404;
		
		System.out.println(String.valueOf(errorCode));
	}
}
