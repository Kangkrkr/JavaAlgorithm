package queue;

import java.util.LinkedList;
import java.util.Stack;

public class ReverseQueue {

	public static void main(String[] args) {
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		initQueue(queue);
		printQueue(queue);
		
		reverseQueue(queue);
		printQueue(queue);
	}
	
	public static void initQueue(LinkedList<Integer> queue){
		for(int i=1; i<=5; i++){
			queue.add(i);
		}
	}
	
	public static void reverseQueue(LinkedList<Integer> queue){
		
		// 큐를 reverse 할 임시 스택을 만든다.
		Stack<Integer> reverseStack = new Stack<Integer>();
		
		// 큐의 모든 아이템들을 스택으로 이동한다.
		while(!queue.isEmpty()){
			reverseStack.push(queue.remove());
		}
		
		// 스택의 모든 아이템들을 다시 큐로 이동한다.
		while(!reverseStack.isEmpty()){
			queue.add(reverseStack.pop());
		}
		
	}
	
	public static void printQueue(LinkedList<Integer> queue){
		for(int i=0; i<queue.size(); i++){
			System.out.print(queue.get(i)+" ");
		}
		System.out.println();
	}

}
