package queue;

import java.util.Stack;


/* 1 2 3 4 5 가 연속으로 입력된다면 ??
   하지만 연속으로 입력될 수 있다는 가능성이 확실하지 않으니 그 방법을 체크하기가 어렵다..
   시뮬레이션을 해보자.
   1 2 3 을 인큐하고, 다시 디큐한후, 4 5 를 인큐한후 다시 디큐해보자. */

public class QueueByTwoStack {
	
	private Stack<Integer> leftStack;
	private Stack<Integer> rightStack;
	
	private int front = -1;
	private int rear = -1;
	
	/* 생성자 */
	public QueueByTwoStack(){
		leftStack = new Stack<Integer>();	// add() 시 들어오는 아이템의 입력 작업을 관리하는 스택이다.
		rightStack = new Stack<Integer>();	// remove() 시 아이템의 출력(빼는) 작업을 관리하는 스택이다.
	}
	
	public void add(int item){
		// 아이템을 그대로 leftStack 에 넣는다 (후입선출에 의거)
		leftStack.push(item);
		// 일반 큐와 마찬가지로 rear이 증가한다.
		++rear;
	}
	
	public int remove(){
		
		// 첫 시작시는 rightStack이 비어있으므로, else 문을 실행하여
		// leftStack의 아이템들을 pop() 하여 rightStack으로 옮기는 작업을 한다.
		// 옮기는 작업이 이미 실행된후, rightStack에 항목이 있다면 pop()을 하고 해당 메소드를 종료한다.
		if(!rightStack.isEmpty()){
			++front;
			return rightStack.pop();
		}else{
			// 여기로 넘어오는 경우는, rightStack이 비어있는 경우이므로
			// leftStack의 아이템들을 pop() 하여 rightStack으로 옮기는 작업을 한다.
			while(!leftStack.isEmpty()){
				rightStack.push(leftStack.pop());
			}
		}
		
		// rightStack의 항목을 pop() 한다.
		++front;
		return rightStack.pop();
	}
	
	public int getFront(){
		return front;
	}
	
	public int getRear(){
		return rear;
	}
	
	public static void main(String[] args) {
		QueueByTwoStack queue = new QueueByTwoStack();
		
		System.out.println("현재 큐의 front : "+queue.getFront()+" , rear : "+queue.getRear());
		
		for(int i=1; i<=3; i++){
			queue.add(i);
		}
		
		System.out.println("3개의 아이템을 Enqueue한 현재 큐의 front : "+queue.getFront()+" , rear : "+queue.getRear());
		
		for(int i=1; i<=3; i++){
			System.out.print(queue.remove()+" ");
		}
		System.out.println("\n3개의 아이템을 Dequeue한 현재 큐의 front : "+queue.getFront()+" , rear : "+queue.getRear());
		
		for(int i=4; i<=5; i++){
			queue.add(i);
		}
		
		System.out.println("2개의 아이템을 Enqueue한 현재 큐의 front : "+queue.getFront()+" , rear : "+queue.getRear());
		
		for(int i=4; i<=5; i++){
			System.out.print(queue.remove()+" ");
		}
		System.out.println("\n2개의 아이템을 Dequeue한 현재 큐의 front : "+queue.getFront()+" , rear : "+queue.getRear());
		
	}
}

