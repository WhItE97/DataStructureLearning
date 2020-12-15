package 线索二叉树;

import 二叉树.TreeNode;

public class ThreadedNode {
	// 节点值/权
	int value;
	// 每个节点的左儿子和右儿子
	ThreadedNode leftNode;// ctrl+1可以快速生成该属性的getter/setter方法
	ThreadedNode rightNode;
	//#####################new：线索化二叉树需要一个标识位来标识其左右指针指向的是左右儿子还是前驱or后继节点
	int leftType;
	int rightType;//default=0——>即指向左右儿子



	public ThreadedNode(int value) {
		this.value = value;
	}

	// 设置左儿子
	public void setleftNode(ThreadedNode node) {
		this.leftNode = node;
	}

	// 设置右儿子
	public void setrightNode(ThreadedNode node) {
		this.rightNode = node;
	}

	// DLR先序遍历 当前节点
	public void preorderTraversal() {
		System.out.println(value);
		// 递归先序左子树
		if (leftNode != null) {
			leftNode.preorderTraversal();
		}
		// 再递归右子树
		if (rightNode != null) {
			rightNode.preorderTraversal();
		}
	}

	// LDR中序遍历 当前节点
	public void inorderTraversal() {
		// 递归先序左子树
		if (leftNode != null) {
			leftNode.inorderTraversal();
		}
		System.out.println(value);
		// 再递归右子树
		if (rightNode != null) {
			rightNode.inorderTraversal();
		}
	}

	// LRD后序遍历 当前节点
	public void postorderTraversal() {
		// 递归先序左子树
		if (leftNode != null) {
			leftNode.postorderTraversal();
		}
		// 再递归右子树
		if (rightNode != null) {
			rightNode.postorderTraversal();
		}
		System.out.println(value);
	}

	// 前序查找DLR
	public ThreadedNode frontSearch(int i) {
		ThreadedNode target = null;
		// 对比当前节点的值
		if (value == i)
			return this;
		// 没有匹配成功，则找左儿子
		// 先判断有没有左儿子
		if (leftNode != null) {
			// 用target装左儿子的值，没找到则target==null————>自己的错误点！
			// 自己写的时候没有用target吃返回值，而是像之前遍历一样直接递归调用了
			// ATT java基础上的理解错误！
			// 【子递归中的return，只结束了该【子】递归（不能结束整个递归流程！），返回值传给了他的上一级递归调用，如果上一级不对这个返回值做处理，则此返回值实际没起作用】
			// 所以这里必须要吃下返回值，并且层层返回
			// ########画图尝试一个流程进行理解，理解难点在于：
			// 当找到了value后，该节点是被自己的上一级调用的，并且上一级用target吃了这个返回值；然后上上一级又会吃掉上一级的返回值...
			// 直至根节点的父调用——>吃到返回之后直接return该target，结束了父递归，从而结束了整轮递归
			target = leftNode.frontSearch(i);
		}
		// 判断target找到没————>如果不用target装返回值，以进行判断，那么即使左儿子找到了，
		if (target != null) {
			return target;
		}
		// 如果左儿子也没找到，再来找右儿子
		if (rightNode != null) {
			target = rightNode.frontSearch(i);
		}
		return target;// 此时右儿子无论找到与否，都可以直接return
	}

	public void delete(int i) {
		// 树中已经帮我们判别过了，删除的不是根节点
		// 删除节点只需要——>将其父节点指向它的箭头去掉
		// myidea：随便选一种遍历先找到他，再找到他的父节点，删掉该箭头————>实际上操作起来不简单，单向的树找父节点并不容易。
		// 思路：
		// 从根节点开始，取节点做parent，对parent的左右儿子进行匹配，删除
		// 如果不匹配，则分别递归parent为parent的左儿子和右儿子
		ThreadedNode parent = this;
		// 判断左儿子
		if (leftNode != null) {
			if (leftNode.value == i) {
				this.leftNode = null;
				return;
			}
		}
		// 判断右儿子
		if (rightNode != null) {
			if (rightNode.value == i) {
				this.rightNode = null;
				return;
			}
		}
		// 可能左儿子右儿子都没匹配上，那就递归
		// 先将左儿子做parent递归
		if (leftNode != null) {
			parent = leftNode;
			parent.delete(i);
		}
		// 再将右儿子做parent递归
		if (rightNode != null) {
			parent = rightNode;
			parent.delete(i);
		}
	}
}
