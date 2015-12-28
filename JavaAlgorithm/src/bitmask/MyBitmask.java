package bitmask;

public class MyBitmask {

	// 비트연산 작업은 2^n 의 수에 최적화 되어 있기 때문에, 아래 작성한 일부 함수들이 작동하지 않는 경우가 있다.
	
	public static void main(String[] args) {
		
		int n = 150;
		
		// 몫
		int quota = getQuota(n, 10);
		// 나머지
		int remainder = getRemainder(n, 8);
		
		
		System.out.println("몫 : "+quota);
		System.out.println("비트마스킹으로 계산한 나머지 : "+remainder);
		System.out.println("unsignedIntValue : "+getUnsignedIntValue(n));

		isEven(n);
		
		printLoopNumber();
		System.out.println("비트 내 포함된 1의 갯수 : "+getBitsForShiftRight(n));
		System.out.println("비트 내 포함된 1의 갯수 : "+getBitsForReverse(n));
		
		System.out.println("평균 : "+getAverage(7, 16));
		
		bitSwap(10, 5);
		
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(n-1));
	}
	
	// 몫을 구하는 메소드
	public static int getQuota(int n, int divide){
		return n/divide;
	}

	// 나머지를 구하는 메소드
	public static int getRemainder(int n, int k){
		// 다음은 k가(divider) 2의 배수여야지만 나머지를 구할 수 있는 수식이다 (단점이지만 속도가 빠르다.)
		return (n & getUnsignedIntValue(k - 1));
	}
	
	// 부호 없는 정수를 반환하는 메소드
	public static int getUnsignedIntValue(int n){
		// ASCII가 표현할수 있는 범위인 127을 넘어가면 byte단에서 음수로 인식하기 때문에
		// 0xFF 의 비트마스크를 씌우면 음수로 인식하는 일이 없어진다.
		return (0xFF & (byte)n);
	}
	
	// 비트연산으로 짝수인지를 판별하는 메소드. 이 역시 2^n 의 수만 판별가능하다.
	public static void isEven(int n){
		if((n & n-1) == 0){
			System.out.println("이 수는 짝수 입니다.");
		}
	}
	
	// 해당 정수의 비트에서 1이 몇개나 있는지 검사하는 메소드들
	// 비트연산(shift right)로 계산한 비트 내의 1의 갯수
	public static int getBitsForShiftRight(int n){
		int c = 0;
		
		while(n > 0){
			c += (n & 1); 	// 끝자리의 비트를 검사. 끝자리가 1이라면 1이 더해지고, 아니라면 0이 더해진다.
			n = (n >> 1);	// 오른쪽으로 한자리씩 밀어 다음 비트를 당겨 온다.
		}
		
		return c;
	}
	
	// 비트 뒤집기(reverse)로 계산한 비트 내의 1의 갯수
	public static int getBitsForReverse(int n){
		int c = 0;
		
		while(n > 0){
			c++;
			n &= n-1;
		}
		
		return c;
	}
	
	// 비트 연산을 이용하여 평균을 구하는 메소드
	public static int getAverage(int low, int high){
		
		// N >> K : N 이라는 정수를 2^K 만큼 나눈다.
		return (low + high) >> 1;
	}
	
	// 비트 연산으로 두 수를 스왑하는 메소드이다.
	public static void bitSwap(int i, int j){
		
		i ^= j;			// 1111
		j ^= i;
		i ^= j;
		
		//System.out.println((i^j)^i);
		//System.out.println((i^j)^j);
		System.out.println(i);
		System.out.println(j);
	}
	
	public static void printLoopNumber(){
		int value = 0;
		
		// 0 1 2 3 0 1 2 3 0 1 2 3 이 출력된다.
		for(int i=0; i<12; i++){
			value = value & 0x03;
			System.out.print(value+" ");
			value++;
		}
		System.out.println();
	}
}
