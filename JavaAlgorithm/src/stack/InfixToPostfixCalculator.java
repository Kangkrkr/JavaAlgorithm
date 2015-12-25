package stack;

import java.util.Stack;

public class InfixToPostfixCalculator {

	public static void main(String[] args) {
		
		// 중위표현식 : 1*2-(3+4)+5
		// 후위표현식 : 12*34+-5+
		// 결과값     : 0 
		String postfix = InfixToPostfix.postfix("1*2-(3+4)+5");
		System.out.println(calculate(postfix));
	}
	
	public static int calculate(String postfix){
		
		Stack stack = new Stack();
		
		for(int i=0; i<postfix.length(); i++){
			
			char c = postfix.charAt(i);
			
			// 숫자라면 스택에 푸쉬한다.
			if(InfixToPostfix.isNumber(c)){
				stack.push(c);
			}
			// 연산자라면 먼저, 단항연산자인지 이항연산자인지 구분한다.
			// 단항연산자라면 스택에서 하나를 팝,
			// 이항연산자라면 스택에서 두개를 팝한다.
			// 먼저 스택에서 팝된 피연산자가 이항연산자 연산시의 두번째 피연산자가 된다.
			else if(InfixToPostfix.isOperator(c)){
				
				// 일단, 이항연산자인 것을 전제조건으로 해본다. (스택에서 피연산자 두개 팝)
				int post = Integer.parseInt(stack.pop()+"");
				int pre = Integer.parseInt(stack.pop()+"");
				
				int result = 0;
				
				switch (c) {
				case '+':
					result = pre + post;
					break;
				case '-':
					result = pre - post;
					break;
				case '*':
					result = pre * post;
					break;
				case '/':
					result = pre * post;
					break;
				default:
					System.out.println("지원되지 않는 연산자입니다.");
					break;
				}
				
				// 계산한 결과를 스택에 푸쉬한다.
				stack.push(result);
			}
		}
		
		// 루프문이 종료되고 난 후에는 스택에 최종결과 값이 하나 저장되어있다.
		// 그 결과값을 팝하여 결과를 보여준다.
		return Integer.parseInt(stack.pop()+"");
	}

}
