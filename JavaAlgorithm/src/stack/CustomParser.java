package stack;

public class CustomParser {

	// 필요한 기본 변수 : top, 용량, 데이터를 저장할 배열
	private int top;
	private int capacity;
	private char stack[];

	public CustomParser() {
		top = -1;
		capacity = 20;
		stack = new char[capacity];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public boolean isFull() {
		return (top == (capacity - 1));
	}

	public void push(char item) {
		if (isFull()) {
			System.out.println("스택이 가득 차서 더이상 푸쉬할 수 없습니다.");
			return;
		} else {
			stack[++top] = item;
		}
	}

	public char pop() {
		if (isEmpty()) {
			System.out.println("스택이 비어 있어서 더이상 팝할 수 없습니다.");
			return ' ';
		} else {
			return stack[top--];
		}
	}

	public int getSize() {
		return (top + 1);
	}

	public int getCapacity() {
		return capacity;
	}

	public void startParsing(String string) {
		
		// 1.   입력의 끝까지 읽어들인다.
		// 1-1. 파서는 한번에 한글자씩만 읽어 들인다.
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);

			// 2. 읽은 글자가 짝을 맞춰야 하는 기호가 아니라면 무시한다.
			if (c == '+' || c == '-' || c == '/' || c == '%')
				continue;
			
			// 3. 여는 경계문자이면 스택에 저장한다.
			if (c == '(' || c == '[' || c == '{') {
				push(c);
				continue;
			}

			// 4. 아래와 같이 닫는 경계 문자가 나오면 스택에서 팝한다.
			// 	    그 후, 둘의 짝의 검사하여 이 짝이 맞다면 문자열의 파싱이 계속된다.
			//	    스택이 비었다면 오류를 보고한다. 그렇지 않다면 스택에서 팝을 한다.
			//    팝한 기호가 여는 기호에 맞는 짝이 아니라면 오류를 보고한다.
			if (c == ')') {
				if ((pop() == '(') ? true : false)
					continue;
			}

			if (c == ']') {
				if ((pop() == '[') ? true : false)
					continue;
			}

			if (c == '}') {
				if ((pop() == '{') ? true : false)
					continue;
			}
		}

		// 5. 입력의 끝에 스택이 비어 있지 않다면 오류를 보고한다.
		if (isEmpty()) {
			System.out.println("짝이 잘 맞습니다.");
		} else {
			System.out.println("올바르지 않은 수식입니다.");
		}
	}

	public static void main(String[] args) {
		CustomParser customParser = new CustomParser();

		customParser.startParsing("{([()])}");
	}

}
