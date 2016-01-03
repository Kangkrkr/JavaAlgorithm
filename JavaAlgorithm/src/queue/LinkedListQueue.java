package queue;

import java.util.LinkedList;

public class LinkedListQueue {

	public static void main(String[] args) {
		
		LinkedList<Integer> queue = new LinkedList<>();
		
		for(int i=1; i<=10; i++){
			queue.add(i);
		}
		
		for(int i=1; i<=10; i++){
			System.out.print(queue.remove()+" ");
		}
	}

}
