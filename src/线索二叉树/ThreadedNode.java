package ����������;

import ������.TreeNode;

public class ThreadedNode {
	// �ڵ�ֵ/Ȩ
	int value;
	// ÿ���ڵ������Ӻ��Ҷ���
	ThreadedNode leftNode;// ctrl+1���Կ������ɸ����Ե�getter/setter����
	ThreadedNode rightNode;
	//#####################new����������������Ҫһ����ʶλ����ʶ������ָ��ָ��������Ҷ��ӻ���ǰ��or��̽ڵ�
	int leftType;
	int rightType;//default=0����>��ָ�����Ҷ���



	public ThreadedNode(int value) {
		this.value = value;
	}

	// ���������
	public void setleftNode(ThreadedNode node) {
		this.leftNode = node;
	}

	// �����Ҷ���
	public void setrightNode(ThreadedNode node) {
		this.rightNode = node;
	}

	// DLR������� ��ǰ�ڵ�
	public void preorderTraversal() {
		System.out.println(value);
		// �ݹ�����������
		if (leftNode != null) {
			leftNode.preorderTraversal();
		}
		// �ٵݹ�������
		if (rightNode != null) {
			rightNode.preorderTraversal();
		}
	}

	// LDR������� ��ǰ�ڵ�
	public void inorderTraversal() {
		// �ݹ�����������
		if (leftNode != null) {
			leftNode.inorderTraversal();
		}
		System.out.println(value);
		// �ٵݹ�������
		if (rightNode != null) {
			rightNode.inorderTraversal();
		}
	}

	// LRD������� ��ǰ�ڵ�
	public void postorderTraversal() {
		// �ݹ�����������
		if (leftNode != null) {
			leftNode.postorderTraversal();
		}
		// �ٵݹ�������
		if (rightNode != null) {
			rightNode.postorderTraversal();
		}
		System.out.println(value);
	}

	// ǰ�����DLR
	public ThreadedNode frontSearch(int i) {
		ThreadedNode target = null;
		// �Աȵ�ǰ�ڵ��ֵ
		if (value == i)
			return this;
		// û��ƥ��ɹ������������
		// ���ж���û�������
		if (leftNode != null) {
			// ��targetװ����ӵ�ֵ��û�ҵ���target==null��������>�Լ��Ĵ���㣡
			// �Լ�д��ʱ��û����target�Է���ֵ��������֮ǰ����һ��ֱ�ӵݹ������
			// ATT java�����ϵ�������
			// ���ӵݹ��е�return��ֻ�����˸á��ӡ��ݹ飨���ܽ��������ݹ����̣���������ֵ������������һ���ݹ���ã������һ�������������ֵ��������˷���ֵʵ��û�����á�
			// �����������Ҫ���·���ֵ�����Ҳ�㷵��
			// ########��ͼ����һ�����̽�����⣬����ѵ����ڣ�
			// ���ҵ���value�󣬸ýڵ��Ǳ��Լ�����һ�����õģ�������һ����target�����������ֵ��Ȼ������һ���ֻ�Ե���һ���ķ���ֵ...
			// ֱ�����ڵ�ĸ����á���>�Ե�����֮��ֱ��return��target�������˸��ݹ飬�Ӷ����������ֵݹ�
			target = leftNode.frontSearch(i);
		}
		// �ж�target�ҵ�û��������>�������targetװ����ֵ���Խ����жϣ���ô��ʹ������ҵ��ˣ�
		if (target != null) {
			return target;
		}
		// ��������Ҳû�ҵ����������Ҷ���
		if (rightNode != null) {
			target = rightNode.frontSearch(i);
		}
		return target;// ��ʱ�Ҷ��������ҵ���񣬶�����ֱ��return
	}

	public void delete(int i) {
		// �����Ѿ��������б���ˣ�ɾ���Ĳ��Ǹ��ڵ�
		// ɾ���ڵ�ֻ��Ҫ����>���丸�ڵ�ָ�����ļ�ͷȥ��
		// myidea�����ѡһ�ֱ������ҵ��������ҵ����ĸ��ڵ㣬ɾ���ü�ͷ��������>ʵ���ϲ����������򵥣���������Ҹ��ڵ㲢�����ס�
		// ˼·��
		// �Ӹ��ڵ㿪ʼ��ȡ�ڵ���parent����parent�����Ҷ��ӽ���ƥ�䣬ɾ��
		// �����ƥ�䣬��ֱ�ݹ�parentΪparent������Ӻ��Ҷ���
		ThreadedNode parent = this;
		// �ж������
		if (leftNode != null) {
			if (leftNode.value == i) {
				this.leftNode = null;
				return;
			}
		}
		// �ж��Ҷ���
		if (rightNode != null) {
			if (rightNode.value == i) {
				this.rightNode = null;
				return;
			}
		}
		// ����������Ҷ��Ӷ�ûƥ���ϣ��Ǿ͵ݹ�
		// �Ƚ��������parent�ݹ�
		if (leftNode != null) {
			parent = leftNode;
			parent.delete(i);
		}
		// �ٽ��Ҷ�����parent�ݹ�
		if (rightNode != null) {
			parent = rightNode;
			parent.delete(i);
		}
	}
}
