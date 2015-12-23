package recursive;

// 정렬된 배열 {0, 1, 2, 3, 4, 5, 6, 7, 8, 9} 가 있다고 가정.
// 7 을 찾는다 ?
// 배열의 중간 인덱스를 pivot 으로 설정.
// 초기 ->  leftBound = 0, rightBound = 배열의길이 - 1 두개를 더하고 나누기 2 한다.
// 배열[pivot] 의 값이 찾는값과 동일하다면 그 pivot을 리턴.
// 찾는값이 배열[pivot]의 값 보다 크다면 leftBound = pivot + 1;
// 찾는값이 배열[pivot]의 값 보다 작다면 rightBound = pivot - 1;
// 루프문을 돌다, leftBound 가 rightBound 보다 커졌다면 찾지 못한것이므로 -1 반환.

public class BinarySearch {

	public static void main(String[] args) {

		int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println(binarySearch(array, 7, 0, array.length - 1));
		
	}

	public static int binarySearch(int array[], int searchValue, int leftBound, int rightBound){
		
		int pivot = (leftBound + rightBound) / 2;
		
		if(leftBound > rightBound){
			return -1;
		}else if(array[pivot] == searchValue){
			return pivot;
		}else if(array[pivot] < searchValue){
			return binarySearch(array, searchValue, pivot + 1, rightBound);
		}else{
			return binarySearch(array, searchValue, leftBound, pivot - 1);
		}
	}
}
