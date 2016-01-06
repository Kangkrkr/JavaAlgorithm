package tree;

import java.util.Stack;


public class RemoveNode {

	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(5);
		root.setLeft(new BinaryTreeNode(7));
		root.setRight(new BinaryTreeNode(4));
		root.getLeft().setLeft(new BinaryTreeNode(6));
		root.getLeft().setRight(new BinaryTreeNode(8));
		root.getRight().setLeft(new BinaryTreeNode(2));
		root.getRight().setRight(new BinaryTreeNode(3));

		removeNode(root);
	}

	//         5
	//      7     4
	//    6   8  2   3
	// 후위탐색을 사용하여 삭제한다. 6 8 7 2 3 4 5
	public static void removeNode(BinaryTreeNode root){
		
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		// 순회한 노드들을 담아 둘 임시 스택.
		Stack<BinaryTreeNode> temp = new Stack<BinaryTreeNode>();
		
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
					
					// 임시스택을 역순으로 담을 스택.
					Stack<BinaryTreeNode> reverse = new Stack<BinaryTreeNode>();
					
					while(!temp.isEmpty()){
						reverse.push(temp.pop());
					}
					
					while(!reverse.isEmpty()){
						System.out.print(reverse.pop().getData()+" ");
					}
					
					return;
				}
				
				// 부모노드의 오른쪽 자식노드 역시 비었다면,
				if(stack.peek().getRight() == null){
					// 부모노드를 스택에서 팝하고 출력한다.
					root = stack.pop();
					temp.add(root);
					
					// 팝된 항목이 스택의 최상위 항목(부모노드)의 오른쪽 자식과 같은지 검사.
					// 같다면, 왼쪽 부속트리와 오른쪽 부속 트리 처리를 마친 것을 의미하며,
					// LRD 중 D를 처리하게 되는 단계이다.
					while((!stack.isEmpty()) && (root == stack.peek().getRight())){
						root = stack.pop();
						temp.add(root);
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
}
