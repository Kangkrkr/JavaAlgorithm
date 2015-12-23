package recursive;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

public class Hanoi {

	private int[] A = new int[3];
	private static int count = 0;
	
	public static void main(String[] args) {
		Hanoi hanoi = new Hanoi();
//		hanoi.hanoi(3, 'A', 'B', 'C');
//		hanoi.findBinaryString(3);
//		hanoi.kArray(3, 3);
		System.out.println(hanoi.sizeof(0b1001011));
	}
	
	public int sizeof(int n){

		// 재귀적 표현
		if(n <= 0){
			return count;
		}else{
			count++;
			return sizeof(n/10);
		}
		
		
		/* 반복적 표현
		while(n > 0){
			count++;
			n /= 10;
		}
		
		return count;*/
		
	}
	
	public void hanoi(int n, char from, char visit, char to){
		
		if(n == 1){
			System.out.println("원반1을 "+from+"에서 "+to+"로 옮깁니다.");
		}else{
			// 제일 아래 원판을 제외한 윗판들을 C를 경유하여 B로 옮긴다.
			hanoi(n-1, from, to, visit);
			
			// 그리고나서, 제일 밑의 원판을 A에서 C로 옮긴다.
			System.out.println("원반"+n+"을 "+from+"에서 "+to+"로 옮깁니다.");
			
			// B에 있던 나머지 원판들을 다시 B에서 C로 옮긴다.
			hanoi(n-1, visit, from, to);
		}
		
	}
	
	public void findBinaryString(int n){
		
		if( n < 1){
			for(int i : A){
				System.out.print(i);
			}
			System.out.println();	// 000 100 010 110 001 101 011 111
		}
		else{
			
			A[n-1] = 0;
			findBinaryString(n-1);
			A[n-1] = 1;
			findBinaryString(n-1);
			
			// 재귀문이 두개가 사용되므로 두단계씩 나뉜다.
			// 나뉘는 단계에서 한쪾은 0, 다른 한쪽은 1로 값이 설정되며 나뉘어진다.
		}
	}
	
	// 고른 길이 n, 배열길이 k
	public void kArray(int n, int k){
		if( n < 1){
			count++;
			for(int i : A){
				System.out.print(i);
			}
			System.out.println();
		}else{
			for(int i=0; i<k; i++){ // k의 n승
				A[n-1] = i;
				kArray(n-1, k);
			}
		}
	}

}
