package tree;

import java.util.LinkedList;

public class TreeSizeToQueue {

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

	private static int sizeofTree(BinaryTreeNode root) {
		
		int level = 0;
		
		if(root == null){
			return -1;
		}
		
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		
		BinaryTreeNode tempNode = null;
		
		while(!queue.isEmpty()){
			tempNode = queue.remove();
			level++;
			
			if(tempNode.getLeft() != null){
				queue.add(tempNode.getLeft());
			}
			
			if(tempNode.getRight() != null){
				queue.add(tempNode.getRight());
			}
		}
		
		return level;
	}

}
