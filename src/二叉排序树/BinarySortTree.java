package ����������;

public class BinarySortTree {
	Node root;
	
	//��ӽڵ㣨or����������������
	public void add(Node node) {
		//����ǿ���
		if(root==null) {
			root = node;
		}
		else {
			root.add(node);
		}
	}
	
	//����
	public Node search(int value) {
		if(root==null) {
			return null;
		}
		return root.search(value);
	}
	
	//�������
	public void inorderTraversal() {
		root.NonRecursionInTraversal();
	}
	
}
