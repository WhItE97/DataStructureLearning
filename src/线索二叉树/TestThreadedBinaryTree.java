package ����������;

import ����������.ThreadedBinaryTree;
import ����������.ThreadedNode;

public class TestThreadedBinaryTree {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		// ����һ�Ŷ�����
		ThreadedBinaryTree binTree = new ThreadedBinaryTree();
		// ����һ�����
		ThreadedNode root = new ThreadedNode(1);
		// ���ýڵ㸳���������ڵ�
		binTree.setRoot(root);
		// Ϊ���ڵ����һ����ڵ��һ���ҽڵ�
		ThreadedNode leftnode = new ThreadedNode(2);
		ThreadedNode rightnode = new ThreadedNode(3);
		// ���˶��ӽڵ�ͨ��setter�������õ����ڵ�������ӽڵ�
		binTree.root.setleftNode(leftnode);// ��Ƶ�� û��binTree��ֱ���õ�root.
		binTree.root.setrightNode(rightnode);

		// ����Ӽ����ڵ㣬���ڲ���DLR,LDR,LRD���ֱ�����ʽ
		root.leftNode.leftNode = new ThreadedNode(4);
		root.leftNode.rightNode = new ThreadedNode(5);
		root.rightNode.leftNode = new ThreadedNode(6);
		root.rightNode.rightNode = new ThreadedNode(7);
		
		//LDR����
		binTree.inorderTraversal();
		//����������������
		binTree.threadNodes();
		ThreadedNode n = root.leftNode.rightNode.leftNode;//5����û������ӣ�����Ӧ����ǰ������2
		System.out.println(n==leftnode);
		binTree.threadIterate();
	}

}
