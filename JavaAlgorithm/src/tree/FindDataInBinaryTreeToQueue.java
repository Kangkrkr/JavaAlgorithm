package tree;

import java.util.LinkedList;

public class FindDataInBinaryTreeToQueue {

	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(5);
		root.setLeft(new BinaryTreeNode(7));
		root.setRight(new BinaryTreeNode(4));
		root.getLeft().setLeft(new BinaryTreeNode(6));
		root.getLeft().setRight(new BinaryTreeNode(8));
		root.getRight().setLeft(new BinaryTreeNode(2));
		root.getRight().setRight(new BinaryTreeNode(3));
		
		findData(root, 2);
		
	}

	private static void findData(BinaryTreeNode root, int toFind) {
		
		if(root == null){
			return;
		}
		
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		
		BinaryTreeNode tempNode = null;
		queue.add(root);
		
		while(!queue.isEmpty()){
			tempNode = queue.remove();
			
			if(toFind == tempNode.getData()){
				System.out.println("데이터를 찾았습니다.");
				return;
			}
			
			if(tempNode.getLeft() != null){
				queue.add(tempNode.getLeft());
			}
			
			if(tempNode.getRight() != null){
				queue.add(tempNode.getRight());
			}
		}
	}

}
