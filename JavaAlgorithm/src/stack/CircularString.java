package stack;

public class CircularString {

	public static void main(String[] args) {

		/* a와 b로 구성된 문자열이 있다. 이 문자열엔 특별한 문자 X가 있어서
		 문자열의 중앙을 표시한다. 이 문자열이 회문인지 아닌지 검사하라.*/
		
		//						 0123456
		String circularString = "abaXaba";
		
		int leftBound = 0;
		int rightBound = circularString.length()-1;
		
		// leftBound 와 rightBound가 크로스 되지 않을 때 까지 실행.
		while(	(leftBound < rightBound) &&
				(circularString.charAt(leftBound) == circularString.charAt(rightBound))){
			leftBound++;
			rightBound--;
		}
		
		if(leftBound < rightBound){
			System.out.println("회문이 아닙니다.");
		}else{
			System.out.println("회문 입니다.");
		}
	}

}
