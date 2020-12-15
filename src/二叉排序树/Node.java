package 二叉排序树;

import java.util.Stack;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	//中序遍历BST得到一个有序数组（非递归）
	//访问与处理顺序不一致（访问要一直到树的左边最底部，处理从中间节点开始）
	public void NonRecursionInTraversal() {
		Node cur = this;//用于记录访问顺序
		Stack<Node> st = new Stack<Node>();
		while(!st.isEmpty()||cur!=null) {
			if(cur!=null) {
				st.push(cur);
				cur = cur.left;
			}
			else {
				cur = st.pop();//中
				System.out.print(cur.value+" ");
				cur = cur.right;
			}
		}
	}

	/**
	 * 向子树中添加节点
	 * 法一：
	 * 自己的非递归解法
	 * 通过一个while循环找到该节点应该插入的位置（每轮都和一个节点进行比较，大了就继续和右子比，小了就继续和左子比，直到无子）
	 * 使用一个pre Node记录该无子节点，再通过一个boolean记录插入节点的value和pre Node的大小关系，插入节点大就往右子放，小就往左子放
	 * @param node
	 */
	static Node pre;
	static Boolean leftflag = null;
	public void selfadd(Node node) {
		if(node==null) {
			return;
		}
		Node n = this;
		//找到自己该在的位置
		while(n!=null) {
			if(n.value<node.value) {
				//附加node的值大于当前值
				//如果加在当前node，则加在右子，则leftflag=false
				leftflag = false;
				pre = n;
				n = n.right;
				continue;
			}
			else {
				//附加node的值小于当前值
				leftflag = true;
				pre = n;
				n = n.left;
			}
		}
		//跳出来
		if(leftflag) {
			pre.left = node;
		}
		else {
			pre.right = node;
		}
	}
	
	/**
	 * 向二叉排序树中添加节点
	 * 法二：递归添加
	 * @param node
	 */
	public void add(Node node) {
		if(node==null) {
			return;
		}
		//判断传入节点的value和当前子树！的根节点的value大小
		if(node.value<this.value) {
			//如果node值更小,分两种情况处理
			//1）this没有左子了，直接嵌上去
			if(this.left==null) {
				this.left=node;
			}
			else {
				this.left.add(node);
			}
		}
		else {
			//如果node值更大,同样分两种
			//1）this没有右子，直接嵌上去
			if(this.right==null) {
				this.right = node;
			}
			else {
				this.right.add(node);
			}
		}
	}
	
	/**
	 * 输入一个value，查找对应节点，如果存在则返回该节点
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
		//找完了都没有
		return null;
	}
}
