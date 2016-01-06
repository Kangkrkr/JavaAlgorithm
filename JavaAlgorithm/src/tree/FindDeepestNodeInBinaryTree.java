package tree;

import java.util.ArrayList;


public class FindDeepestNodeInBinaryTree {

	private static ArrayList<BinaryTreeNode> nodes = new ArrayList<BinaryTreeNode>();
	private static ArrayList<BinaryTreeNode> prevNodes = new ArrayList<BinaryTreeNode>();
	
	public static void main(String[] args) {
		
		BinaryTreeNode root = new BinaryTreeNode(5);
		root.setLeft(new BinaryTreeNode(7));
		root.setRight(new BinaryTreeNode(4));
		root.getLeft().setLeft(null);
		root.getLeft().setRight(new BinaryTreeNode(8));
		root.getLeft().getRight().setLeft(new BinaryTreeNode(9));
		root.getRight().setLeft(null);
		root.getRight().setRight(new BinaryTreeNode(3));
		
		findDeepestNode(root);
		for(BinaryTreeNode node : prevNodes){
			System.out.print(node.getData()+" ");
		}
	}
	
	//         5
	//      7     4
	//    n   8  n   3
	//  n  n 9 nn n n  n
	public static void findDeepestNode(BinaryTreeNode root){
		
		if(root == null){
			return;
		}
		
		findDeepestNode(root.getLeft());
		findDeepestNode(root.getRight());
	}

}
