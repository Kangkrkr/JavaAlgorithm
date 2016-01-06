package tree;

public class TreeSizeToRecursive {

	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(5);
		root.setLeft(new BinaryTreeNode(7));
		root.setRight(new BinaryTreeNode(4));
		root.getLeft().setLeft(new BinaryTreeNode(6));
		root.getLeft().setRight(new BinaryTreeNode(8));
		root.getRight().setLeft(new BinaryTreeNode(2));
		root.getRight().setRight(new BinaryTreeNode(3));
		
		System.out.println(sizeofTree(root));
	}
	
	public static int sizeofTree(BinaryTreeNode root){
		
		if(root == null){
			return 0;
		}
		
		// 왼쪽 부속트리의 수와 루트, 오른쪽 부속트리의 갯수를 모두 더한다.
		return sizeofTree(root.getLeft()) + 1 + sizeofTree(root.getRight());
		
	}

}
