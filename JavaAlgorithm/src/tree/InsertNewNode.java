package tree;

import java.util.LinkedList;

public class InsertNewNode {

	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(5);
		root.setLeft(new BinaryTreeNode(7));
		root.setRight(new BinaryTreeNode(4));
		root.getLeft().setLeft(new BinaryTreeNode(6));
		root.getLeft().setRight(new BinaryTreeNode(8));
		root.getRight().setLeft(new BinaryTreeNode(2));
		root.getRight().setRight(new BinaryTreeNode(3));
		
		inserNewNode(root, 9);
		inserNewNode(root, 10);
		BinaryTreeToLoop.preOrder(root);
	}

	//         5
	//      7     4
	//    6   8  2   3
	private static void inserNewNode(BinaryTreeNode root, int data){
		
		// 새 노드를 만든다. 새 노드의 왼쪽, 오른쪽 자식은 모두 null 이다.
		BinaryTreeNode newNode = new BinaryTreeNode(data);
		newNode.setLeft(null);
		newNode.setRight(null);
		
		// 만약, root가 없다면 새 노드를 root 로 한다.
		if(root == null){
			root = newNode;
			return;
		}
		
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
		
		BinaryTreeNode temp = null;
		
		while(!queue.isEmpty()){
			temp = queue.remove();
			
			if(temp.getLeft() != null){
				queue.add(temp.getLeft());
			}else{
				// temp 노드의 왼쪽 자식이 null 이라면, 왼쪽 자식을 새노드로 설정한다.
				temp.setLeft(newNode);
				return;
			}
			
			if(temp.getRight() != null){
				queue.add(temp.getRight());
			}else{
				// temp 노드의 오른쪽 자식이 null 이라면, 오른쪽 자식을 새노드로 설정한다.
				temp.setRight(newNode);
				return;			
			}
		}
		
	}
}
