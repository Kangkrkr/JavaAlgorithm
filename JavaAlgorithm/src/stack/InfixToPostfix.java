package stack;

import java.util.Stack;


public class InfixToPostfix {

	public static void main(String[] args) {

		//      인픽스            포스트픽스
		// (2-1)*3+(4-2)/4  -->  21-3*42-4/+
		//   1*2-(3+4)+5    -->   12*34+-5+
		String infix = "(2-1)*3+(4-2)/4";
		postfix(infix);
	}
	
	public static void postfix(String infix){
		
		// A * B - (C + D) + E : infix
		// AB*CD+-E+		   : postfix
		
		// 1. 연산자 및 '(' 를 push, pop 할 스택을 만든다.
		Stack<Character> stack = new Stack<Character>();
		
		// 2. 입력받은 문자열에서 각각의 글자 단위로 검사한다.
		for(int i=0; i<infix.length(); i++){

			// 문자열에서 한글자 가져오기.
			char c = infix.charAt(i);
			
			// 3. 숫자(피연산자)를 만난다면 그냥 출력한다.
			if(isNumber(c)){
				System.out.print(c);
			}
			// 4. 오른쪽(닫는) 괄호가 나오면, 
			// 스택이 비어있지 않는 조건한에서 왼쪽(여는) 괄호를 만날떄까지 팝하며 출력한다.
			else if(c == ')'){
				while(!stack.isEmpty() && stack.peek() != '('){
					System.out.print(stack.pop());
				}
				
				// 위의 while문은 '(' 전까지 팝되었으므로,
				// '(' 은 출력하지 않고 버린다.(팝을 한다.)
				stack.pop();
			}
			// 5. 그외, 왼쪽(여는) 괄호를 만났을 경우나 연산자를 만나는 경우 .
			else{
				// 여는 괄호를 만나면 스택에 푸쉬한다.
				if(c == '('){
					stack.push('(');
				}
				
				// 연산자를 만난다면, 
				// 스택이 비어 있지 않은 조건하에서
				// 현재 자신보다 우선순위가 높은 연산자를 팝하며 출력한다.
				if(isOperator(c)){
					while(!stack.isEmpty() && (getPrec(c) <= getPrec(stack.peek()))){
						System.out.print(stack.pop());
					}
					
					// 그리고나서 자신을 스택에 푸쉬한다.
					stack.push(c);
				}
			}
		}
		
		// 6. 순환문이 끝나고 나면, 스택이 빌때까지 팝을 하며 출력한다.
		while(!stack.isEmpty()){
			System.out.print(stack.pop());
		}
	}
	
	public static boolean isNumber(char c){
		return (c >= '0' && c <= '9');
	}
	
	public static boolean isOperator(char c){
		return ((c == '+') || (c == '-') || (c == '*') || (c == '/'));
	}
	
	// 연산자별 우선순위 체크를 하는 메소드
	public static int getPrec(char c){
		
		if((c == '+') || (c == '-'))
			return 1;
		if((c == '*') || (c == '/'))
			return 2;
		return 0;
	}
}
