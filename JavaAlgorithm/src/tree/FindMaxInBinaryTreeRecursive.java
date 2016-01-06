package tree;

public class FindMaxInBinaryTreeRecursive {

	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(5);
		root.setLeft(new BinaryTreeNode(7));
		root.setRight(new BinaryTreeNode(4));
		root.getLeft().setLeft(new BinaryTreeNode(6));
		root.getLeft().setRight(new BinaryTreeNode(8));
		root.getRight().setLeft(new BinaryTreeNode(2));
		root.getRight().setRight(new BinaryTreeNode(3));
		
		postOrder(root);
		System.out.print(max);
	}

	
	// LRD
	//         5
	//      7     4
	//    6   8  2   3
	public static void postOrder(BinaryTreeNode root){
		
		if(root == null){
			return;
		}
		
		postOrder(root.getLeft());				// 왼쪽 부속트리 탐색.
		postOrder(root.getRight());				// 오른쪽 부속트리 탐색.
		max = (root.getData() < max) ? max : root.getData();	// 부모노드 탐색.
	}
	
}
