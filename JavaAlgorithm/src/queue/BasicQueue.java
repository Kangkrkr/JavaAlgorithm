package queue;


// 큐의 구현을 위한 인터페이스. ADT는 다음과 같다.
interface Queue {

	public boolean isEmpty();
	public boolean isFull();
	public void enqueue(int item);	// 큐의 끝에 데이터 삽입
	public int dequeue();			// 큐의 맨처음 데이터를 반환(삭제)
	public int getSize();
}


public class BasicQueue implements Queue{

	private int front;	// head 라고도 한다.
	private int rear;	// tail 이라고도 한다.
	
	private int capacity;
	private int buffer[];
	
	public BasicQueue(int size) {
		// 초기 front 와 rear 은 -1 로 초기화한다.
		front = -1;
		rear = -1;
		capacity = size;
		buffer = new int[capacity];
	}

	@Override
	public boolean isEmpty() {
		// front 와 rear이 가리키는 인덱스가 같다면 현재 큐는 빈 상태이다.
		return (rear == front);
	}

	@Override
	public boolean isFull() {
		// rear + 1 을 capacity로 나눈 몫이 front와 같다면, 현재 큐는 가득 찬 상태이다.
		return ((rear+1)%capacity == front);
	}

	@Override
	public int getSize() {
		// ?? 맞는지 모르겠음 ..
		return ((capacity-front+rear+1)%capacity);
	}
	
	public int get(int index){
		return buffer[index];
	}
	
	public int getFront(){
		return front % capacity;
	}
	
	public int getRear(){
		return rear % capacity;
	}

	@Override
	// enqueue 시 rear 이 움직인다. (뒷부분부터 추가되므로) -> rear = rear + 1
	public void enqueue(int item) {
		if(isFull()){
			System.out.println("큐가 가득찼습니다.");
			return;
		}
		
		// (++rear)%capacity 의 위치에 아이템 삽입.
		buffer[(++rear)%capacity] = item;
	}
	
	// dequeue 시 front 가 움직인다. (앞부분부터 빼내므로) -> front = front + 1
	@Override
	public int dequeue() {
		if(isEmpty()){
			System.out.println("큐가 비었습니다.");
			return -1;
		}
		
		// (++front)%capacity 의 위치에 아이템 반환 및 제거.
		int item = buffer[(++front)%capacity];
		buffer[(front)%capacity] = 0;
		return item;
	}
	
	public static void main(String[] args) {

		BasicQueue queue = new BasicQueue(10);
		
		/* front 가 rear 보다 커지는 경우를 시뮬레이션 해본다 */
		
		for(int i=1; i<=12; i++){
			queue.enqueue(i);
		}
		// front = -1 , rear = (11 % capacity) = 1;
		System.out.println("front : "+queue.getFront()+" , rear : "+queue.getRear());
		
		for(int i=1; i<=3; i++){
			queue.dequeue();
		}
		//  front = 2 , rear = 1;
		System.out.println("front : "+queue.getFront()+" , rear : "+queue.getRear());
		
		System.out.println("현재 큐의 사이즈 : "+queue.getSize());
	}

}
