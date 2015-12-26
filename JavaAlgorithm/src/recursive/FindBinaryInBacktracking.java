package recursive;

public class FindBinaryInBacktracking {

	private static int A[] = new int[3];
	
	public static void main(String[] args) {

		binary(3);
		
	}
	
	public static void binary(int n){
		if(n < 1){
			for(int i=0; i<3; i++){
				System.out.print(A[i]);
			}
			System.out.println();
		}else{
			A[n-1] = 0;
			binary(n-1);
			A[n-1] = 1;
			binary(n-1);
		}
	}

}
