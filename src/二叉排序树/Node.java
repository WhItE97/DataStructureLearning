package ����������;

import java.util.Stack;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	//�������BST�õ�һ���������飨�ǵݹ飩
	//�����봦��˳��һ�£�����Ҫһֱ�����������ײ���������м�ڵ㿪ʼ��
	public void NonRecursionInTraversal() {
		Node cur = this;//���ڼ�¼����˳��
		Stack<Node> st = new Stack<Node>();
		while(!st.isEmpty()||cur!=null) {
			if(cur!=null) {
				st.push(cur);
				cur = cur.left;
			}
			else {
				cur = st.pop();//��
				System.out.print(cur.value+" ");
				cur = cur.right;
			}
		}
	}

	/**
	 * ����������ӽڵ�
	 * ��һ��
	 * �Լ��ķǵݹ�ⷨ
	 * ͨ��һ��whileѭ���ҵ��ýڵ�Ӧ�ò����λ�ã�ÿ�ֶ���һ���ڵ���бȽϣ����˾ͼ��������ӱȣ�С�˾ͼ��������ӱȣ�ֱ�����ӣ�
	 * ʹ��һ��pre Node��¼�����ӽڵ㣬��ͨ��һ��boolean��¼����ڵ��value��pre Node�Ĵ�С��ϵ������ڵ��������ӷţ�С�������ӷ�
	 * @param node
	 */
	static Node pre;
	static Boolean leftflag = null;
	public void selfadd(Node node) {
		if(node==null) {
			return;
		}
		Node n = this;
		//�ҵ��Լ����ڵ�λ��
		while(n!=null) {
			if(n.value<node.value) {
				//����node��ֵ���ڵ�ǰֵ
				//������ڵ�ǰnode����������ӣ���leftflag=false
				leftflag = false;
				pre = n;
				n = n.right;
				continue;
			}
			else {
				//����node��ֵС�ڵ�ǰֵ
				leftflag = true;
				pre = n;
				n = n.left;
			}
		}
		//������
		if(leftflag) {
			pre.left = node;
		}
		else {
			pre.right = node;
		}
	}
	
	/**
	 * ���������������ӽڵ�
	 * �������ݹ����
	 * @param node
	 */
	public void add(Node node) {
		if(node==null) {
			return;
		}
		//�жϴ���ڵ��value�͵�ǰ�������ĸ��ڵ��value��С
		if(node.value<this.value) {
			//���nodeֵ��С,�������������
			//1��thisû�������ˣ�ֱ��Ƕ��ȥ
			if(this.left==null) {
				this.left=node;
			}
			else {
				this.left.add(node);
			}
		}
		else {
			//���nodeֵ����,ͬ��������
			//1��thisû�����ӣ�ֱ��Ƕ��ȥ
			if(this.right==null) {
				this.right = node;
			}
			else {
				this.right.add(node);
			}
		}
	}
	
	/**
	 * ����һ��value�����Ҷ�Ӧ�ڵ㣬��������򷵻ظýڵ�
	 * @param value
	 * @return
	 */
	public Node search(int value) {
		if(this.value==value) {
			return this;
		}
		if(this.value>value&&this.left!=null) {
			return left.search(value);
		}
		if(this.value<value&&this.right!=null){
			return right.search(value);
		}
		//�����˶�û��
		return null;
	}
}
