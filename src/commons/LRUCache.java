package commons;

import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class LRUCache {
	private static Deque<Integer> dq;
	private static Set<Integer> keys;
	private static int cacheSize;
	
	LRUCache(int n) {
		dq = new LinkedList<>();
		keys = new HashSet<>();
		
		cacheSize = n;
	}
	
	public void refer(int pageNumber) {
		
		if(!keys.contains(pageNumber) ) {
			if(dq.size() == cacheSize) {
				int last = dq.removeLast();
				keys.remove(last);
			}
		} else {
			int pos = 0;
			
			for(Integer p: dq) {
				if(p == pageNumber)
					break;
				pos++;
			}
			
			dq.remove(pos);
		}
		
		dq.push(pageNumber);
		keys.add(pageNumber);
	}
	
	public void display() {
		for (Integer integer : dq)
			System.out.print(integer + " ");
    } 
	
	public static void main(String[] args) {
		LRUCache ca = new LRUCache(4); 
        ca.refer(1); 
        ca.refer(2); 
        ca.refer(3); 
        ca.refer(1); 
        ca.refer(4); 
        ca.refer(5); 
        ca.display();
	}
}
