package tree;


public class BinaryTreeToRecursive {

	public static void main(String[] args){
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
	}
	
	// DLR
	public static void preOrder(BinaryTreeNode root){
		if(root == null){
			return;
		}
		
		System.out.print(root.getData()+" ");
		preOrder(root.getLeft());
		preOrder(root.getRight());
	}
	
	// LDR
	public static void inOrder(BinaryTreeNode root){
		if(root == null){
			return;
		}
		
		inOrder(root.getLeft());
		System.out.print(root.getData()+" ");
		inOrder(root.getRight());
	}
	
	// LRD
	public static void postOrder(BinaryTreeNode root){
		if(root == null){
			return;
		}
		
		postOrder(root.getLeft());
		postOrder(root.getRight());
		System.out.print(root.getData()+" ");
	}
}
