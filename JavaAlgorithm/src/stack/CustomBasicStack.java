package stack;

public class CustomBasicStack {

	// 필요한 기본 변수 : top, 용량, 데이터를 저장할 배열
	private int top;
	private int capacity;
	private int stack[];
	
	public CustomBasicStack(){
		top = -1;
		capacity = 10;
		stack = new int[capacity];
	}
	
	public boolean isEmpty(){
		return (top == -1);
	}
	
	public boolean isFull(){
		return (top == (capacity - 1));
	}
	
	public void push(int item){
		if(isFull()){
			System.out.println("스택이 가득 차서 더이상 푸쉬할 수 없습니다.");
			return;
		}else{
			stack[++top] = item;
		}
	}
	
	public int pop(){
		if(isEmpty()){
			System.out.println("스택이 비어 있어서 더이상 팝할 수 없습니다.");
			return -1;
		}else{
			return stack[top--];
		}
	}
	
	public int getSize(){
		return (top + 1);
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public static void main(String[] args) {
		CustomBasicStack customStack = new CustomBasicStack();
		
		for(int i=0; i<customStack.getCapacity(); i++){
			customStack.push(i);
		}
		
		customStack.push(10);	// 스택 용량 초과로 푸쉬 불가.
		
		for(int i=0; i<customStack.getCapacity(); i++){
			System.out.println(customStack.pop());
		}
		
		customStack.pop();		// 스택이 비어 있어서 팝 불가.
	}

}
