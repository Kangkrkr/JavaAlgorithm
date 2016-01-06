package tree;

public class FindDataInBinaryTreeToRecursive {

	private static int count = 0;
	
	public static void main(String[] args) {

		BinaryTreeNode root = new BinaryTreeNode(5);
		root.setLeft(new BinaryTreeNode(7));
		root.setRight(new BinaryTreeNode(4));
		root.getLeft().setLeft(new BinaryTreeNode(6));
		root.getLeft().setRight(new BinaryTreeNode(8));
		root.getRight().setLeft(new BinaryTreeNode(2));
		root.getRight().setRight(new BinaryTreeNode(3));
		
		findData(root, 4);
	}
	
	// 전위순회 (DLR)로 한다.
	//         5
	//      7     4
	//    6   8  2   3
	public static void findData(BinaryTreeNode root, int toFind){

		if(root == null) return;
		
		count++;
		if(toFind == root.getData()){
			System.out.println(count+" 번째 만에 데이터를 찾음.");
			return;
		}
		findData(root.getLeft(), toFind);
		findData(root.getRight(), toFind);
		
	}

}
