package 线索二叉树;

import 线索二叉树.ThreadedNode;

public class ThreadedBinaryTree {
	ThreadedNode root;
	
	ThreadedNode pre;

	// ###########################new:中序线索化二叉树 LDR
	// 在一棵树创建好后，调用此方 法，它就变成一颗中序线索化二叉树
	public void threadNodes(ThreadedNode node) { // 线索化整棵树——>肯定会递归——>会用到节点，所以方法带参数node
		// 沾边递归，注意判空
		if (node == null) {
			return;
		}
		// 因为LDR，所以先按顺序备注好，按序处理// 如此递归下去，第一个开始真正进行线索化处理的节点，一定是LDR遍历的首个节点，所以其左儿子为空，左儿子直接return，开始处理自己。
		// 先处理左子树
		threadNodes(node.leftNode);
		
		// 再处理自己
		// 处理前驱节点,把存下来的pre指向自己
		if(node.leftNode==null) {
			//左儿子为空，则需要让其指向其前驱节点；并且改变其左指针的指针类型leftType
			node.leftNode = pre; // 要指向其前驱节点，就必须要临时保存其前驱节点以供指向，所以需要在tree的类中定义一个存储前驱的临时节点——>往下第三行
			node.leftType = 1; // 此type默认=0的时候，指的是其指向的是左右儿子
		}
		// 处理后继节点,如果pre的右儿子为空,则让他指向自己
		if(pre.rightNode==null) { // 这里在遍历的第一个节点的时候，其无pre，可能会空指针异常，所以需要判空
			pre.rightNode = node;
			pre.rightType = 1;
		}
		// 因为threadNodes(node)会递归，所以每调一次，就把该次的节点作为pre存入
		pre = node;

		// 最后处理右子树
		threadNodes(node.rightNode);
	}

	// 为了可以直接调用threadNodes方法实现整棵树的线索化，而不输入某个节点做参数，再写一个不带参的函数
	public void threadNodes() {
		threadNodes(root);
	}
	
	//遍历线索二叉树
	public void threadIterate() {
		ThreadedNode node = root;
		while(node!=null) {
			//循环找到最开始的节点
			while(node.leftType==0) {
				node = node.leftNode;
			}
			//打印当前结点的值
			System.out.println(node.value);
			//如果当前节点的右指针指向的是后继节点，可能后继节点还有后继节点
			while(node.rightType==1) {
				node = node.rightNode;
				System.out.println(node.value);
			}
			//替换遍历的节点
			node = node.rightNode;
		}
	}

	// 设置根节点
	public void setRoot(ThreadedNode node) {
		this.root = node;
	}

	// 取根节点
	public ThreadedNode getRoot() {
		return this.root;
	}

	// 通过调用root的前、中、后序遍历实现对树的遍历
	// 前序遍历
	public void preorderTraversal() {
		root.preorderTraversal();
	}

	// 中序遍历
	public void inorderTraversal() {
		root.inorderTraversal();
	}

	// 前序遍历
	public void postorderTraversal() {
		root.postorderTraversal();
	}

	public ThreadedNode frontSearch(int i) {
		// 树中的函数都是空壳，调用root的实现该功能的方法就vans了
		return root.frontSearch(i);
	}

	public void delete(int i) {
		// 树这里要分情况！
		// 如果删除的是根节点，则直接变成一棵空树
		if (root.value == i) {
			this.root = null;
		}
		// 不是根的话，则调用根节点的删除方法
		else {
			root.delete(i);
		}
	}
}
