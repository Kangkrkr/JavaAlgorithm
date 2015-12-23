package queue;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class MyPriorityBlockingQueue {

	public static void main(String[] args) {
		
		// 우선순위 큐 -> 생성시 Compator 인터페이스를 인자로 받으며, poll() 시 우선순위가 낮은(혹은 높은) 것 부터 뽑아낸다.
		PriorityBlockingQueue queue = new PriorityBlockingQueue(1, new Comparator<Integer>() {

			@Override
			public int compare(Integer pre, Integer post) {
				if(pre < post){
					return -1;
				}else if(pre == post){
					return 0;
				}else{
					return 1;
				}
			}
		});

		for(int i=0; i<10; i++){
			queue.add(new Random().nextInt(20));
		}
		
		for(int i=0; i<10; i++){
			System.out.print(queue.poll()+" ");
		}
		System.out.println();

	}

}
