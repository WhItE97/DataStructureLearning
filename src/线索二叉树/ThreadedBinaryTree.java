package ����������;

import ����������.ThreadedNode;

public class ThreadedBinaryTree {
	ThreadedNode root;
	
	ThreadedNode pre;

	// ###########################new:���������������� LDR
	// ��һ���������ú󣬵��ô˷� �������ͱ��һ������������������
	public void threadNodes(ThreadedNode node) { // ����������������>�϶���ݹ顪��>���õ��ڵ㣬���Է���������node
		// մ�ߵݹ飬ע���п�
		if (node == null) {
			return;
		}
		// ��ΪLDR�������Ȱ�˳��ע�ã�������// ��˵ݹ���ȥ����һ����ʼ������������������Ľڵ㣬һ����LDR�������׸��ڵ㣬�����������Ϊ�գ������ֱ��return����ʼ�����Լ���
		// �ȴ���������
		threadNodes(node.leftNode);
		
		// �ٴ����Լ�
		// ����ǰ���ڵ�,�Ѵ�������preָ���Լ�
		if(node.leftNode==null) {
			//�����Ϊ�գ�����Ҫ����ָ����ǰ���ڵ㣻���Ҹı�����ָ���ָ������leftType
			node.leftNode = pre; // Ҫָ����ǰ���ڵ㣬�ͱ���Ҫ��ʱ������ǰ���ڵ��Թ�ָ��������Ҫ��tree�����ж���һ���洢ǰ������ʱ�ڵ㡪��>���µ�����
			node.leftType = 1; // ��typeĬ��=0��ʱ��ָ������ָ��������Ҷ���
		}
		// �����̽ڵ�,���pre���Ҷ���Ϊ��,������ָ���Լ�
		if(pre.rightNode==null) { // �����ڱ����ĵ�һ���ڵ��ʱ������pre�����ܻ��ָ���쳣��������Ҫ�п�
			pre.rightNode = node;
			pre.rightType = 1;
		}
		// ��ΪthreadNodes(node)��ݹ飬����ÿ��һ�Σ��ͰѸôεĽڵ���Ϊpre����
		pre = node;

		// �����������
		threadNodes(node.rightNode);
	}

	// Ϊ�˿���ֱ�ӵ���threadNodes����ʵ��������������������������ĳ���ڵ�����������дһ�������εĺ���
	public void threadNodes() {
		threadNodes(root);
	}
	
	//��������������
	public void threadIterate() {
		ThreadedNode node = root;
		while(node!=null) {
			//ѭ���ҵ��ʼ�Ľڵ�
			while(node.leftType==0) {
				node = node.leftNode;
			}
			//��ӡ��ǰ����ֵ
			System.out.println(node.value);
			//�����ǰ�ڵ����ָ��ָ����Ǻ�̽ڵ㣬���ܺ�̽ڵ㻹�к�̽ڵ�
			while(node.rightType==1) {
				node = node.rightNode;
				System.out.println(node.value);
			}
			//�滻�����Ľڵ�
			node = node.rightNode;
		}
	}

	// ���ø��ڵ�
	public void setRoot(ThreadedNode node) {
		this.root = node;
	}

	// ȡ���ڵ�
	public ThreadedNode getRoot() {
		return this.root;
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

	public ThreadedNode frontSearch(int i) {
		// ���еĺ������ǿտǣ�����root��ʵ�ָù��ܵķ�����vans��
		return root.frontSearch(i);
	}

	public void delete(int i) {
		// ������Ҫ�������
		// ���ɾ�����Ǹ��ڵ㣬��ֱ�ӱ��һ�ÿ���
		if (root.value == i) {
			this.root = null;
		}
		// ���Ǹ��Ļ�������ø��ڵ��ɾ������
		else {
			root.delete(i);
		}
	}
}
