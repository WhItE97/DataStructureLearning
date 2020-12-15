package ������;

public class TestBinaryTree {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		//����һ�Ŷ�����
		BinaryTree binTree = new BinaryTree();
		//����һ�����
		TreeNode root = new TreeNode(1);
		//���ýڵ㸳���������ڵ�
		binTree.setRoot(root);
		//Ϊ���ڵ����һ����ڵ��һ���ҽڵ�
		TreeNode leftnode = new TreeNode(2);
		TreeNode rightnode = new TreeNode(3);
		//���˶��ӽڵ�ͨ��setter�������õ����ڵ�������ӽڵ�
		binTree.root.setleftNode(leftnode);//��Ƶ�� û��binTree��ֱ���õ�root.
		binTree.root.setrightNode(rightnode);
		
		//����Ӽ����ڵ㣬���ڲ���DLR,LDR,LRD���ֱ�����ʽ
		root.leftNode.leftNode = new TreeNode(4);
		root.leftNode.rightNode = new TreeNode(5);
		root.rightNode.leftNode = new TreeNode(6);
		root.rightNode.rightNode = new TreeNode(7);
		//������
		//DLR��1245367
		//LDR��4251637
		//LRD��4526731
		System.out.println("�������DLR:");
		binTree.preorderTraversal();
		System.out.println();
		System.out.println("�������LDR:");
		binTree.inorderTraversal();
		System.out.println();
		System.out.println("�������LRD:");
		binTree.postorderTraversal();
		System.out.println();
		
		//ǰ�����
//		TreeNode res = binTree.frontSearch(3);
//		System.out.println(res==rightnode);
		
		//ɾ��һ���ڵ�/����������ͨ���������ԣ����ɾ���Ľڵ㲻��Ҷ�ӣ������������һ��ɾ����
//		binTree.delete(3);
//		System.out.println("ɾ��Ԫ�غ󣬺��������");
//		binTree.postorderTraversal();
		
		//�ǵݹ�ǰ�����
		System.out.println("�ǵݹ��������DLR:");
		binTree.NonRecursionPre();
		System.out.println();
		System.out.println("�ǵݹ��������DLR:");
		binTree.NonRecursionIn();
		System.out.println();
		System.out.println("�ǵݹ�������LRD:");
		binTree.NonRecursionPost();
	}

}
