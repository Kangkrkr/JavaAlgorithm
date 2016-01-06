package tree;

import java.util.LinkedList;
import java.util.Stack;



// ※ 참고 - Queue 로도 가능하다 !
public class BinaryTreeToLoop {

	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(1);
		root.setLeft(new BinaryTreeNode(2));
		root.setRight(new BinaryTreeNode(3));
		root.getLeft().setLeft(new BinaryTreeNode(4));
		root.getLeft().setRight(new BinaryTreeNode(5));
		root.getRight().setLeft(new BinaryTreeNode(6));
		root.getRight().setRight(new BinaryTreeNode(7));
		
		preOrder(root);
		System.out.println();
		
		inOrder(root);
		System.out.println();
		
		postOrder(root);
		System.out.println();
		
		levelOrder(root);
		System.out.println();
	}

	// DLR
	//         1
	//      2     3
	//    4   5  6   7
	public static void preOrder(BinaryTreeNode root){
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		/* 자식 노드를 방문시, 부모노드의 정보를 알고 있어야 한다.
		 * 부모노드의 정보를 저장하기 위해 스택을 사용한다.   */
		
		while(true){
			// 뿌리에서 말단노드까지 탐색. (실은 말단노드의 자식노드인 null 까지도 탐색한다)
			while(root != null){
				// 현재의 노드를 방문하고 방문정보를 스택에 담는다. (자식노드에 대한 부모노드의 정보가 된다)
				System.out.print(root.getData() + " ");
				stack.push(root);
				root = root.getLeft();	// 부모 노드의 왼쪽 자식 방문.
			}
			
			// 스택에 방문정보가 없다면 루프를 종료시킨다.
			if(stack.isEmpty()){
				return;
			}
			
			// 스택으로부터 부모노드의 정보를 가져온다.
			root = stack.pop();
			root = root.getRight();		// 부모 노드의 오른쪽 자식 방문.
			
			// 해당 노드의 방문 끝..
			
		}
	}
	
	// LDR
	//         1
	//      2     3
	//    4   5  6   7
	public static void inOrder(BinaryTreeNode root){
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		while(true){
			while(root != null){
				stack.push(root);
				root = root.getLeft();
			}
			
			if(stack.isEmpty()){
				return;
			}
			
			root = stack.pop();
			System.out.print(root.getData()+" ");
			root = root.getRight();
		}
	}
	
	// LRD
	//         1
	//      2     3
	//    4   5  6   7
	public static void postOrder(BinaryTreeNode root) {

		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		while(true){
			
			// 현재의 노드가 null이 아니면 스택에 집어넣는다.
			if(root != null){
				stack.push(root);
				root = root.getLeft();	// 집어넣고, 왼쪽 자식노드로 향한다.
			}
			// 왼쪽 자식노드가 null인 경우.
			else{
				// 스택이 비었다면 종료.
				if(stack.isEmpty()){
					return;
				}
				
				// 부모노드의 오른쪽 자식노드 역시 비었다면,
				if(stack.peek().getRight() == null){
					// 부모노드를 스택에서 팝하고 출력한다.
					root = stack.pop();
					System.out.print(root.getData()+" ");
					
					// 팝된 항목이 스택의 최상위 항목(부모노드)의 오른쪽 자식과 같은지 검사.
					// 같다면, 왼쪽 부속트리와 오른쪽 부속 트리 처리를 마친 것을 의미하며,
					// LRD 중 D를 처리하게 되는 단계이다.
					while((!stack.isEmpty()) && (root == stack.peek().getRight())){
						root = stack.pop();
						System.out.print(root.getData()+" ");
					}
				}
				
				// 오른쪽 형제노드로 이동한다.
				if(!stack.isEmpty()){
					root = stack.peek().getRight();
				}
				// 작업 후 스택이 비었다면, 모든 노드들을 방문한것이므로 종료.
				else{
					root = null;
				}
			}
		}
	}
	
	
	// LEVEL
	//         1
	//      2     3
	//    4   5  6   7
	public static void levelOrder(BinaryTreeNode root){
		
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode temp = null;
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			temp = queue.remove();
			System.out.print(temp.getData()+" ");
			
			if(temp.getLeft() != null){
				queue.add(temp.getLeft());
			}
			
			if(temp.getRight() != null){
				queue.add(temp.getRight());
			}
		}
		
	}
}
