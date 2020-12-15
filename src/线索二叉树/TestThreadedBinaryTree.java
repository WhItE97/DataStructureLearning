package 线索二叉树;

import 线索二叉树.ThreadedBinaryTree;
import 线索二叉树.ThreadedNode;

public class TestThreadedBinaryTree {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		// 创建一颗二叉树
		ThreadedBinaryTree binTree = new ThreadedBinaryTree();
		// 创建一个结点
		ThreadedNode root = new ThreadedNode(1);
		// 将该节点赋给树做根节点
		binTree.setRoot(root);
		// 为根节点添加一个左节点和一个右节点
		ThreadedNode leftnode = new ThreadedNode(2);
		ThreadedNode rightnode = new ThreadedNode(3);
		// 将此二子节点通过setter方法设置到根节点的左右子节点
		binTree.root.setleftNode(leftnode);// 视频里 没加binTree，直接用的root.
		binTree.root.setrightNode(rightnode);

		// 多添加几个节点，用于测试DLR,LDR,LRD三种遍历方式
		root.leftNode.leftNode = new ThreadedNode(4);
		root.leftNode.rightNode = new ThreadedNode(5);
		root.rightNode.leftNode = new ThreadedNode(6);
		root.rightNode.rightNode = new ThreadedNode(7);
		
		//LDR遍历
		binTree.inorderTraversal();
		//中序线索化二叉树
		binTree.threadNodes();
		ThreadedNode n = root.leftNode.rightNode.leftNode;//5本来没有左儿子，这里应该是前驱，即2
		System.out.println(n==leftnode);
		binTree.threadIterate();
	}

}
