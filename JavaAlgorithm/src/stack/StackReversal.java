package stack;

import java.util.Stack;

public class StackReversal {
	
	public static void reverseStack(Stack stack){
		
		// 스택이 빌 때까지 스택을 팝하며 각 단계를 분할하여 실행되며,
		// 각 단계마다 스택 내 아이템들의 reverse 작업이 이루어진다.
		if(stack.isEmpty())return;
		int temp = (int)stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, temp);
	}

	public static void insertAtBottom(Stack stack, int data){
		
		 /* 스택 내 아이템들을 모두 빼내어 최하단에 data를 집어넣고,
		    다시 빼낸 아이템들을 집어 넣는다. */
		
		// 1-1. 모든 아이템들을 빼내었다면 넣으려는 data를 push한다.
		if(stack.isEmpty()){
			stack.push(data);
			return;
		}
		
		// 1. 스택내의 아이템들을 빼는 작업.
		int temp = (int)stack.pop();
		insertAtBottom(stack, data);
		
		// 2. 빼낸 아이템들을 다시 집어 넣는다.
		stack.push(temp);
	}
	
	public static void main(String[] args) {

		Stack stack = new Stack<>();
		for(int i=0; i<3; i++){
			stack.push(i);
		}
		
		reverseStack(stack);
		
		
		System.out.println("뒤집은 후 : ");
		for(int i=0; i<3; i++){
			System.out.println(stack.pop());
		}
		
	}

}
