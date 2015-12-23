package sort;

import java.util.Random;

public class QuickSort {

	public static void main(String[] args) {
		int srcArray[] = new int[10];
		
		for(int i=0; i<srcArray.length; i++){ srcArray[i] = new Random().nextInt(50); }
		
		System.out.print("정렬 전 : ");
		printArray(srcArray);  
		
		// 배열의 leftIndex로 제일 왼쪽, rightIndex로 가장 오른쪽을 전달한다.
		quickSort(srcArray, 0, srcArray.length - 1);
		
		System.out.print("정렬 후 : ");
		printArray(srcArray);
	}
	
	public static void printArray(int srcArray[]){
		for(int i=0; i<srcArray.length; i++){ System.out.print(srcArray[i]+" "); }
		System.out.println();
	}
	
	public static void quickSort(int srcArray[], int srcLeftIndex, int srcRightIndex){
		
		// 재귀함수의 종료 조건. 각 단계마다 10 -> 5 -> 2 -> 1 순으로 배열이 분할되어 정렬됨.
		// (srcRightIndex - srcLeftIndex) 을 찍어보면 확인 가능하다.
		// 배열의 길이가 0 이하면 종료한다.
		if((srcRightIndex - srcLeftIndex) <= 0){ return; }
		else{
			// 현재 단계의 가장 왼쪽 인덱스
			int leftIndex = srcLeftIndex - 1;
			// 현재 단계의 가장 오른쪽 인덱스
			int rightIndex = srcRightIndex;
			
			// 피봇은 현재 단계의 가장 오른쪽으로 한다.
			int pivot = srcArray[rightIndex];
			
			// 왼쪽 인덱스가 오른쪽 인덱스와 겹치거나 크다면
			// while 문을 탈출하고 분할을 시작한다.
			while(true){
				// 왼쪽부터 오른쪽으로 탐색. pivot 값보다 작다면 그냥 넘어간다.
				while(srcArray[++leftIndex] < pivot){ continue; }
				// 오른쪽부터 왼쪽으로 탐색. pivot 값보다 크다면 그냥 넘어간다.
				while((rightIndex > srcLeftIndex) && (srcArray[--rightIndex] > pivot)){ continue; }
				
				// 왼쪽 인덱스가 오른쪽 인덱스와 겹친다면 탈출하고 분할 시작.
				if(leftIndex >= rightIndex){ break; }
				// 아니라면, 서로 탐색하다 발견한 인덱스의 원소를 교환한다.
				else{ swap(srcArray, leftIndex, rightIndex); }
			}
			
			// 분할 시작전 pivot의 교환을 한다 (정렬).
			// leftIndex와 rightIndex가 겹친 인덱스와 원래의 pivot 인덱스를 교환.
			// 즉 현재단계에서 leftIndex 가 pivot 이 되는 것.
			swap(srcArray, leftIndex, srcRightIndex);
			
			// 현재 단계에서 pivot을 기준으로 왼쪽, 오른쪽 분할을 시작한다.
			quickSort(srcArray, srcLeftIndex, leftIndex - 1);
			quickSort(srcArray, leftIndex + 1, srcRightIndex);
		}
	}
	
	public static void swap(int srcArray[], int srcIndex, int dstIndex){
		int temp = srcArray[srcIndex];
		srcArray[srcIndex] = srcArray[dstIndex];
		srcArray[dstIndex] = temp;
	}
}
