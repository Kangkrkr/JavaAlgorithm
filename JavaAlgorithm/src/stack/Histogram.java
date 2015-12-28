package stack;

import java.util.Stack;


/*책의 예제대로 타이핑 했는데 뭔가 좀 이상하다 ....*/


class StackItem{
	public int height;
	public int index;
	
	public StackItem(int height, int index){
		this.height = height;
		this.index = index;
	}
}

public class Histogram {

	public static void main(String[] args) {

		Stack<StackItem> stack = new Stack<StackItem>();
		
		int A[] = {3, 2, 5, 6, 1, 4, 4};
		stack = maxRectangleArea(A, 7);
		
		for(StackItem s : stack){
			System.out.println(s.height);
		}
	}
	
	public static Stack<StackItem> maxRectangleArea(int A[], int n){

		if(A == null || A.length == 0){
			return null;
		}
		
		Stack<StackItem> S = new Stack<StackItem>();
		S.push(new StackItem(Integer.MIN_VALUE, -1));
		
		for(int i=0; i<=n; i++){
			StackItem cur = new StackItem(i<n ? A[i] : Integer.MIN_VALUE, i);
			
			if(cur.height > S.peek().height){
				S.push(cur);
				continue;
			}
			
			while(S.size() > 1){
				StackItem prev = S.peek();
				
				prev.height = cur.height;
				if(prev.height > S.get(S.size() - 2).height){
					break;
				}
				
				S.pop();
			}
		}
		
		return S;
	}

}
