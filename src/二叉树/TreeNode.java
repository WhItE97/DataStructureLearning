package ������;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//һ���ڵ�
public class TreeNode {
	//�ڵ�ֵ/Ȩ
	int value;
	//ÿ���ڵ������Ӻ��Ҷ���
	TreeNode leftNode;//ctrl+1���Կ������ɸ����Ե�getter/setter����
	TreeNode rightNode;
	
	public TreeNode(int value) {
		this.value = value;
	}
	//���������
	public void setleftNode(TreeNode node) {
		this.leftNode = node;
	}
	//�����Ҷ���
	public void setrightNode(TreeNode node) {
		this.rightNode = node;
	}
	
	//�ǵݹ�ǰ���������>���ݹ鶼�ǿ�ջ��ʵ�ֵģ����Կ���ʹ�õ�����������ջ����ʵ�ֵݹ��Ч��
	public void NonRecursionPre() {
		//�õ�ջ�Ƚ����
		//˼·��
		//�Ȱ�rootѹ��ջ����ʼ��ջ�Ƿ�Ϊ�ս���ѭ��
		//ÿpopһ������Ҫ�����Ҷ��ӡ����������ѹ��ջ
		//�ظ�ֱ��ջ��
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(this);
		while(!st.isEmpty()) {
			TreeNode t = st.pop();
			System.out.print(t.value+" ");//��D
			if(t.rightNode!=null) {//��L
				st.push(t.rightNode);
			}
			if(t.leftNode!=null) {//��R
				st.push(t.leftNode);
			}
		}
	}
	
	//�ǵݹ��������
	/**
	 * ˼·��
	 * ÿ���ڵ�ĵ�һ�ξ������������ʣ�������ջ
	 * һֱ��������������������󣬲Ŷ��Լ����ʲ���ջ
	 * Ȼ���ٶ��Լ������ӽ�����ͬ����
	 * HDP:
	 * ����ѭ����������ջ��Ϊ�� || �ڵ�ָ�벻Ϊ��
	 * 
	 * �ͷǵݹ�������ȣ�
	 * �ǵݹ����������DLR��Ҫ���ʵĽڵ��Ҫ�����������ջ���Ľڵ㶼���м�ڵ㣬���ʺʹ����Ԫ��˳��һ�£����Դ�����
	 * �ǵݹ����������LDR���ȷ��ʵ��Ƕ����������Ľڵ㣬ֱ�����ʵ��������ײ����ſ�ʼ�����������ջ���ڵ㣻so����ָ������������ʣ�ջ������ڵ��ϵ�Ԫ��
	 */
	public void NonRecursionIn() {
		Stack<TreeNode> st = new Stack<TreeNode>();//��������
		TreeNode node = this;//����������������
		while(!st.isEmpty()||node!=null) {
			//���ȷ���leftNode
			if(node!=null) {
				st.push(node);
				node = node.leftNode;//��L
			}
			//�˽ڵ�û��leftNode�ˣ��ǾͰ��Լ����ʲ���ջ��
			else {
				node = st.pop();
				System.out.print(node.value+" ");//��D
				//HDP:�Լ�����û�п��ǵ���
				//node.rightNode���Ϊ�գ��ҡ���>��ջҲ��Ԫ�أ��������ĸ��ڵ����ˣ���������Ҳ���ˣ��Ǿ�break��while�ˣ���ջ��Ԫ�أ���ص���һ�����ڵ�
				node = node.rightNode;//��R
			}
		}
	}
	
	//�ǵݹ�������
	/**
	 * ˼·��
	 * ���������DLR�����������LRD������ֻҪ�������DLR����>DRL�����ܵõ�����ĺ�����������ֻ�ô�����������������ɣ�
	 */
	public void NonRecursionPost() {
		Stack<TreeNode> st = new Stack<TreeNode>();
		List<Integer> list = new ArrayList<Integer>();//���ڴ��DRL�Ľ�����Ա�����������LRD
		TreeNode node = this;
		st.push(node);
		
		while(!st.isEmpty()) {
			//����DLRʵ��DRL
			//������һ������һ��
			node = st.pop();
			list.add(node.value);
			//DRL����Ҫ��ѹ��L
			if(node.leftNode!=null) {
				st.push(node.leftNode);
			}
			if(node.rightNode!=null) {
				st.push(node.rightNode);
			}
		}
		//ѭ����õ�һ��DRL��list�����������ΪLRD
		for(int i=list.size()-1;i>=0;i--) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	//DLR������� ��ǰ�ڵ�
	public void preorderTraversal() {
		System.out.print(value+" ");
		//�ݹ�����������
		if(leftNode!=null) {
			leftNode.preorderTraversal();
		}
		//�ٵݹ�������
		if(rightNode!=null) {
			rightNode.preorderTraversal();
		}
	}
	
	//LDR������� ��ǰ�ڵ�
	public void inorderTraversal() {
		//�ݹ�����������
		if(leftNode!=null) {
			leftNode.inorderTraversal();
		}
		System.out.print(value+" ");
		//�ٵݹ�������
		if(rightNode!=null) {
			rightNode.inorderTraversal();
		}
	}
		
	//LRD������� ��ǰ�ڵ�
	public void postorderTraversal() {
		//�ݹ�����������
		if(leftNode!=null) {
			leftNode.postorderTraversal();
		}
		//�ٵݹ�������
		if(rightNode!=null) {
			rightNode.postorderTraversal();
		}
		System.out.print(value+" ");
	}
	
	//ǰ�����DLR
	public TreeNode frontSearch(int i) {
		TreeNode target = null;
		//�Աȵ�ǰ�ڵ��ֵ
		if(value==i)
			return this;
		//û��ƥ��ɹ������������
		//���ж���û�������
		if(leftNode!=null) {
			//��targetװ����ӵ�ֵ��û�ҵ���target==null��������>�Լ��Ĵ���㣡
			//�Լ�д��ʱ��û����target�Է���ֵ��������֮ǰ����һ��ֱ�ӵݹ������
			//ATT java�����ϵ�������
			//���ӵݹ��е�return��ֻ�����˸á��ӡ��ݹ飨���ܽ��������ݹ����̣���������ֵ������������һ���ݹ���ã������һ�������������ֵ��������˷���ֵʵ��û�����á�
			//�����������Ҫ���·���ֵ�����Ҳ�㷵��
			//########��ͼ����һ�����̽�����⣬����ѵ����ڣ�
			//���ҵ���value�󣬸ýڵ��Ǳ��Լ�����һ�����õģ�������һ����target�����������ֵ��Ȼ������һ���ֻ�Ե���һ���ķ���ֵ...
			//ֱ�����ڵ�ĸ����á���>�Ե�����֮��ֱ��return��target�������˸��ݹ飬�Ӷ����������ֵݹ�
			target = leftNode.frontSearch(i);
		}
		//�ж�target�ҵ�û��������>�������targetװ����ֵ���Խ����жϣ���ô��ʹ������ҵ��ˣ�
		if(target!=null) {
			return target;
		}
		//��������Ҳû�ҵ����������Ҷ���
		if(rightNode!=null) {
			target = rightNode.frontSearch(i);
		}
		return target;//��ʱ�Ҷ��������ҵ���񣬶�����ֱ��return
	}
	
	public void delete(int i) {
		// �����Ѿ��������б���ˣ�ɾ���Ĳ��Ǹ��ڵ�
		// ɾ���ڵ�ֻ��Ҫ����>���丸�ڵ�ָ�����ļ�ͷȥ��
		// myidea�����ѡһ�ֱ������ҵ��������ҵ����ĸ��ڵ㣬ɾ���ü�ͷ��������>ʵ���ϲ����������򵥣���������Ҹ��ڵ㲢�����ס�
		// ˼·��
		// �Ӹ��ڵ㿪ʼ��ȡ�ڵ���parent����parent�����Ҷ��ӽ���ƥ�䣬ɾ��
		// �����ƥ�䣬��ֱ�ݹ�parentΪparent������Ӻ��Ҷ���
		TreeNode parent = this;
		//�ж������
		if(leftNode!=null) {
			if(leftNode.value == i) {
				this.leftNode = null;
				return;
			}
		}
		//�ж��Ҷ���
		if(rightNode!=null) {
			if(rightNode.value == i) {
				this.rightNode = null;
				return;
			}
		}
		//����������Ҷ��Ӷ�ûƥ���ϣ��Ǿ͵ݹ�
		//�Ƚ��������parent�ݹ�
		if(leftNode!=null) {
			parent = leftNode;
			parent.delete(i);
		}
		//�ٽ��Ҷ�����parent�ݹ�
		if(rightNode!=null) {
			parent = rightNode;
			parent.delete(i);
		}
	}
}
