package ������;

public class BinaryTree {
	TreeNode root;

	// ���ø��ڵ�
	public void setRoot(TreeNode node) {
		this.root = node;
	}

	// ȡ���ڵ�
	public TreeNode getRoot() {
		return this.root;
	}
	
	//�ǵݹ�ǰ�к������
	public void NonRecursionPre() {
		if(root==null) {
			return;
		}
		root.NonRecursionPre();
	}
	
	//�ǵݹ��������
	public void NonRecursionIn() {
		if(root==null) {
			return;
		}
		root.NonRecursionIn();
	}
	
	//�ǵݹ�������
	public void NonRecursionPost() {
		if(root==null) {
			return;
		}
		root.NonRecursionPost();
	}

	// ͨ������root��ǰ���С��������ʵ�ֶ����ı���
	// ǰ�����
	public void preorderTraversal() {
		root.preorderTraversal();
	}

	// �������
	public void inorderTraversal() {
		root.inorderTraversal();
	}

	// ǰ�����
	public void postorderTraversal() {
		root.postorderTraversal();
	}

	public TreeNode frontSearch(int i) {
		// ���еĺ������ǿտǣ�����root��ʵ�ָù��ܵķ�����vans��
		return root.frontSearch(i);
	}

	public void delete(int i) {
		// ������Ҫ�������
		// ���ɾ�����Ǹ��ڵ㣬��ֱ�ӱ��һ�ÿ���
		if(root.value==i) {
			this.root = null;
		}
		//���Ǹ��Ļ�������ø��ڵ��ɾ������
		else {
			root.delete(i);
		}
	}
}
