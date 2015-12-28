package stack;

import java.util.Random;
import java.util.Stack;

public class SortASCInStack {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i<5; i++){
			int value = new Random().nextInt(10);
			stack.push(value);
		}
		
		for(int i=4; i>=0; i--){
			System.out.print(stack.get(i)+" ");
		}
		System.out.println();
		
		stack = sort(stack);
		for(int i=4; i>=0; i--){
			System.out.print(stack.get(i)+" ");
		}
		System.out.println();
	}
	
	public static Stack<Integer> sort(Stack<Integer> stack){
	
		// 스택을 하나 더 생성한다.
		Stack<Integer> result = new Stack<Integer>();
		
		// 원본 스택이 빌 때까지 실행한다.
		while(!stack.isEmpty()){
			
			// 원본 스택에서 하나 가져온다.
			int temp = stack.pop();
			
			// 임시 스택의 최상위 아이템값이 원본 스택에서 빼온 값보다 크다면,
			// 원본 스택에서 빼온 값보다 작은 값을 만날때 까지 아이템들을 팝하여 원본 스택에 넣어버린다.
			while(!result.isEmpty() && result.peek() > temp){
				stack.push(result.pop());
			}
			
			// 그리고 나서 원본 스택에서 빼온 데이터를 임시 스택에 넣는다.
			result.push(temp);
			
		}
		
		return result;
	}
}
