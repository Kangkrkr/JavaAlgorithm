package stack;

public class FindingSpans {

	public static void main(String[] args) {

		/* 매일 현재 가격보다 낮은 주가의 연속된 날이 며칠인지 검사하기 */
		
		int stock[] = { 6, 3, 4, 5, 2 };	// 주식

		// 배열의 끝에서부터 검사하도록 한다.
		int i = stock.length - 1;
		
		while (i > 0) {

			// 각 단계의 초기 spans 값은 1이다.
			int spans = 1;
			int j = i;

			// 첫번째 단계는 검사하지 않는다.
			// 현재 단계보다 앞의 주가가 낮다면 spans를 증가시킨다.
			// j를 감소시켜 자신보다 앞의 주가도 검사한다.
			while((j > 0) && (stock[j] >= stock[j-1])){
				spans++;
				j--;
			}
			
			System.out.println(i+"번째 spans : "+spans);

			// 앞의 단계로 넘어간다..
			i--;
		}
		
		System.out.println("0번째 spans : "+1);

	}

}
