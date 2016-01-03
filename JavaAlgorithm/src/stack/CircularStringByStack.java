package stack;

import java.util.Stack;

public class CircularStringByStack {

	public static void main(String[] args) {

		/*
		 * a와 b로 구성된 문자열이 있다. 이 문자열엔 특별한 문자 X가 있어서 문자열의 중앙을 표시한다. 
		 * 이 문자열이 회문인지 아닌지 검사하라.
		 */

		//                       0123456
		String circularString = "abaXaba";
		
		// 'X' 를 만나기 전까지 문자들을 스택에 쌓기 위함.
		Stack<Character> stack = new Stack<Character>();

		// 현재 인덱스 지정.
		int curIndex = 0;
		
		// 만난 문자가 'X'가 아닐때 까지 만난 문자를 스택에 쌓으며 인덱스를 증가시킴.
		while(circularString.charAt(curIndex) != 'X'){
			stack.push(circularString.charAt(curIndex));
			curIndex++;
		}
		
		// 인덱스가 'X' 에서 끝났으므로 한번 더 증가시킨다.
		curIndex++;
		
		// 회문인지 판별하기 위한 불린 변수.
		boolean isCircular = true;
		
		// 스택이 비어있지 않고, 인덱스가 문자열을 길이를 초과하지 않을 동안 동작.
		while(!stack.isEmpty() && (curIndex <= circularString.length() - 1)){
			
			// 저장한 스택들을 하나씩 꺼내며, 현재 인덱스의 문자와 비교한다.
			if(stack.pop() == circularString.charAt(curIndex)){
				// 같다면 다음 인덱스로 넘어가고,
				curIndex++;
				continue;
			}else{
				// 아니라면 바로 루프를 탈출한다.
				isCircular = false;
				break;
			}
		}
		
		System.out.println((isCircular) ? "회문 입니다." : "회문이 아닙니다.");
	}
}
