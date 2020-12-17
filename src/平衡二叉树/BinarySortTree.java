package ƽ�������;

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
	
	//ɾ���ڵ�
	/**
	 * ɾ���ڵ�
	 * ˼·��
	 * Ҫ�����������ɾ����Ҷ�Ӣ�ɾ���ڵ�ֻ��һ���ӽڵ��ɾ���ڵ��������ӽڵ�
	 * @param value
	 */
	public void delete(int value) {
		if(root==null) {//��Ҫ���������գ�
			System.out.println("����");
			return;
		}else {
			//���ҵ��ڵ�
			Node target = root.search(value);
			if(target==null) {
				//û�ҵ�����ڵ�
				System.out.println("û�ҵ��ýڵ�");
				return;
			}
			//�ҵ��ýڵ��,���ҵ����ĸ��ڵ�,���ڽ���ɾ������
			Node parent = searchParent(value);
			//�õ�parent ��Ҫ��ʼ����������ˣ�������
			//1.Ҫɾ������Ҷ�ӽڵ�
			//core��Ҷ�ӽڵ㣬ֱ��ɾ����(�漰�����ж�����parent�����ӻ������ӣ�����ֱ�Ӽ��ϸ�֦)
			if(target.left==null&&target.right==null) {
				if(parent.left==target) {
					parent.left = null;
				}
				if(parent.right==target) {
					parent.right = null;
				}
			}
			
			//3.Ҫɾ�������������ӽڵ�Ľڵ�
			//core���Ҵ�ɾ���ڵ��ǰ�����̽ڵ㣬��ֵ�滻���ýڵ��ֵ�����ڵ㱾���ָ�򲻱䣩������ɾ������ȡ�����Ľڵ��ԭ�ڵ�
			//����ѡ���ô�ɾ���ڵ�ĺ�̽ڵ���ȡ����(�漰������ɾ���ڵ��������е���Сֵ�ڵ���ܻ����Ҷ��ӣ�Ҫ���Ҷ���ȡ��ɾ������Сֵ�ڵ��λ��)
			else if(target.left!=null&&target.right!=null) {
				//3.1ɾ����ɾ���ڵ�����������Сֵ�Ľڵ㣬���һ�ȡ�����Ľڵ�ֵ
				int min = deleteMin(target.right);//��target���������ӽ�ȥ��ɾ����С�ڵ㲢ȡֵ
				//3.2�滻target��ֵΪmin����
				target.value=min;
			}
			//2.Ҫɾ��������һ���ӽڵ�ķ�Ҷ�ڵ�(�ж�����д�����鷳�����԰�Ҫɾ�����������ӵĽڵ�ķ���������棬�������д�ж�����)
			//core:ֱ�Ӱ�target�Ķ��ӽ������Լ�ԭ����λ�ü���(�漰������target��parent�����ӻ������Ӣ�target�ĵ������������ӻ�������)
			else if(target.left!=null||target.right!=null) {
				//2.1��Ҫ�ж�target�е������ӻ�������
				if(target.left!=null) {//���target�ĵ�����������
					//2.1.1���ǲ���Ҫ�ж�target��parent�����ӻ�������
					if(parent.left==target) {//��target����parent������
						parent.left = target.left;
					}
					if(parent.right==target) {
						parent.right = target.left;
					}
				}
				//2.2�ж�target�е������ӻ�������
				if(target.right!=null) {//���target�ĵ�����������
					//2.2.1���ǲ���Ҫ�ж�target��parent�����ӻ�������
					if(parent.left==target) {//��target����parent������
						parent.left = target.right;
					}
					if(parent.right==target) {
						parent.right = target.right;
					}
				}
			}
		}
	}
	
	/**
	 * ɾ��һ��������С�Ľڵ�
	 * @param node��target�����ӣ����������ڵ㣬��minɾ��
	 * @return
	 */
	private int deleteMin(Node node) {
		Node target = node;
		//��ʼ����ö���������������min�ڵ�
		while(target.left!=null) {
			target = target.left;
		}
		//�ж������Сֵ�ڵ㻹��û�����ӡ���>�Ա����ɾ���˽ڵ㲻�������>����ʵ�����ã���������д��delete�����Ͱ�����ɾ�� ���� ���� ������ �Ľڵ����������Ե���delete����
		delete(target.value);
		return target.value;
	}

	/**
	 * �ҵ�value�ڵ�ĸ��ڵ�
	 * @param value
	 * @return
	 */
	public Node searchParent(int value) {
		if(root==null) {
			return null;
		}else {
			return root.searchParent(value);
		}
	}
	
	//�������
	public void inorderTraversal() {
		root.NonRecursionInTraversal();
	}
	
}
