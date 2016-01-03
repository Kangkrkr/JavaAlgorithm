package queue;

import java.util.LinkedList;

public class MaxSumOfWindow {

	public static void main(String[] args) {

		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		getSumInSlideWindow(queue, 3);
	}
	
	public static void getSumInSlideWindow(LinkedList<Integer> queue, int w){
		
		// 10개의 -10 부터 10 까지의 난수를 큐에 넣는다.
		for(int i=0; i<10; i++){
			queue.add((int)(Math.random() * 21 - 10));
		}
		
		for(int i=0; i<10; i++){
			System.out.print(queue.get(i)+" ");
		}
		System.out.println();
		
		// 창은 큐의 길이에서 창의 크기를 뺀만큼 탐색해야 한다.
		// 예를 들어, 창의 크기가 3, 배열의 길이가 10이라면 ..
		// 창은 0부터 7까지 3번씩 탐색하는 것이다.
		for(int i=0; i<=queue.size()-w; i++){
			int sum = 0;
			
			// 창이 현재 인덱스부터 창의 크기인 w 번씩 탐색한다.
			for(int j=i; j<i+w; j++){
				sum += queue.get(j);
			}
			System.out.println(i+"번째 창의 합 : "+sum);
		}
	}

}
