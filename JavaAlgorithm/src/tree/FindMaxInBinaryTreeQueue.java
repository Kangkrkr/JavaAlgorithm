package tree;

import java.util.LinkedList;


// 큐를 사용한 레벨탐색.
public class FindMaxInBinaryTreeQueue {

	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(5);
		root.setLeft(new BinaryTreeNode(7));
		root.setRight(new BinaryTreeNode(4));
		root.getLeft().setLeft(new BinaryTreeNode(6));
		root.getLeft().setRight(new BinaryTreeNode(8));
		root.getRight().setLeft(new BinaryTreeNode(2));
		root.getRight().setRight(new BinaryTreeNode(3));
		
		System.out.print(postOrder(root));
	}

	
	// LRD
	//         5
	//      7     4
	//    6   8  2   3
	public static int postOrder(BinaryTreeNode root){
		
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		
		// 초기 max 변수의 값은 integer 의 최소값.
		int max = Integer.MIN_VALUE;
		BinaryTreeNode tempNode = null;
		
		queue.add(root);
		
		while(!queue.isEmpty()){
			
			// 큐의 항목의 데이터(노드)가 제거될 때, 그 값을 관찰한다.
			tempNode = queue.remove();

			max = (max < tempNode.getData()) ? tempNode.getData() : max;
			
			if(tempNode.getLeft() != null){
				queue.add(tempNode.getLeft());
			}
			
			if(tempNode.getRight() != null){
				queue.add(tempNode.getRight());
			}
			
		}
		
		return max;
	}
	
}
