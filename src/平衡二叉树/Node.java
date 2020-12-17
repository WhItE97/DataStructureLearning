package ƽ�������;

import java.util.Stack;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	/**
	 * height���ڷ��ص�ǰ�ڵ�ĸ߶�
	 * core:��ǰ�ڵ��=max(������,������)
	 * @return
	 */
	public int height() {
//		return Math.max(left.height(), right.height())+1;//����������������Ϊ�գ������޸�����
		return Math.max(left==null?0:left.height(), right==null?0:right.height())+1;
	}
	
	/**
	 * ��ȡ�������ĸ߶�
	 * ATT:
	 * �����heightֻ�����������������ĸ߶�max���ܵ������Ľڵ�һ���Ǵ��ڵģ�
	 * ���������Ǽ���������or�������߶�ʱ�����ܸ�����û����or��������Ҳ��û�취����height���������ԻᱨNullPointerException
	 * @return
	 */
	public int leftHeight() {
		if(left==null)
			return 0;
		return left.height();
	}
	
	/**
	 * ��ȡ�������ĸ߶�
	 * @return
	 */
	public int rightHeight() {
		if(right==null)
			return 0;
		return right.height();
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
		
		/**
		 * ��������ͨ��BST����������ڵ�Ĺ��̣����ܻ���ɲ�ƽ�⣬Ӱ��BST��������
		 * �������濪ʼ��BST����>AVL
		 */
		//ÿ���һ���ڵ㣬��Ҫ����BST �Ƿ�ƽ��(�����Ӻ����ӵĸ߶Ȳ��Ƿ�<=1)����>������Ҫһ����������ǰ�ڵ�ĸ߶�
		//1.LL�ͣ���������height-��������height>=2
		//����ת���ڵ�
//		if(left.height()-right.height()>=2) {//��ߵ������ұ��������ǿյģ���������ᱨ��ָ���쳣����������ר����leftheight��rightheight�ķ�������������
		if(leftHeight()-rightHeight()>=2) {
			//����LR���ж�
			//1.2 LR��:�ȶ�L�ӽ����������ٶ�this�����������
			//�ж����������ӵ��������߶ȴ����������߶�
			if(left.leftHeight()<left.rightHeight()) {
				left.leftRotate();
				rightRotate();
			}
			else {//�������LL��,ֻ����������
				rightRotate();
			}
		}
		//2.RR��
		//����ת���ڵ�
		else if(leftHeight()-rightHeight()<=-2){
			//2.2 RL���ж�:����RL�ͣ����ȶ����ӽ���������������
			//�ж����������ӵ��������߶ȴ����������߶�
			if(right.leftHeight()>right.rightHeight()) {
				right.rightRotate();
				leftRotate();
			}
			else {//�������RR��,ֱ������
				leftRotate();
			}
		}
	}
	
	/**
	 * ����ת
	 */
	private void rightRotate() {
		//1.������ǰ�ڵ��ֵ������һ���µĽڵ�
		Node node = new Node(this.value);
		//2.�½ڵ������=��ǰ�ڵ������
		node.right = this.right;
		//3.�½ڵ������=��ǰ�ڵ����ӵ�����
		node.left = this.left.right;//���ܲ�����,nullҲһ�����Կ�����
		//4.��ǰ�ڵ��ֵ����Ϊ�����ӵ�ֵ
		this.value = left.value;
		//5.������ǰ�ڵ�����ӣ���Ϊ��ֵ�Ѿ���������ǰ�ڵ��У�,����ǰ�ڵ����������Ϊ���ӵ�����
		left = left.left;
		//6.��ǰ�ڵ����������Ϊ�½ڵ�
		right = node;
	}
	
	/**
	 * ����ת
	 */
	private void leftRotate() {
		Node node = new Node(this.value);
		node.left = this.left;
		node.right = this.right.left;
		this.value = right.value;
		right = right.right;
		left = node;
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

	public Node searchParent(int value) {
		if((this.left!=null&&this.left.value==value)||(this.right!=null&&this.right.value==value)) {
			return this;
		}
		else {
			//���value�ȵ�ǰ�ڵ�С������������
			if(this.value>value&&this.left!=null) {
				return this.left.searchParent(value);
			}
			//���value���ڵ�ǰ�ڵ㣬��������
			if(this.value<value&&this.right!=null) {
				return this.right.searchParent(value);
			}
			//��û�ҵ�
			return null;
		}
	}
}
