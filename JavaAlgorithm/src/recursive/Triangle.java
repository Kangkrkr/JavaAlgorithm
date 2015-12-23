package recursive;

public class Triangle {

	public static void main(String[] args) {
		int n = 100;
		
		System.out.println(triangle(n));
	}
	
	public static int triangle(int n){
		if(n <= 1){
			return 1;
		}else{
			return n + triangle(n-1);
		}
	}

}
