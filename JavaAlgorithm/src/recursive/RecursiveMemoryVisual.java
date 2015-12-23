package recursive;

public class RecursiveMemoryVisual {

	public static void main(String[] args) {
		visualization(4);
	}
	
	public static int visualization(int n){
		if(n == 0){
			return 0;
		}else{
			System.out.println(n);
			return visualization(n-1);
		}
	}

}
