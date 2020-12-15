package 二叉树;

public class BinaryTree {
	TreeNode root;

	// 设置根节点
	public void setRoot(TreeNode node) {
		this.root = node;
	}

	// 取根节点
	public TreeNode getRoot() {
		return this.root;
	}
	
	//非递归前中后序遍历
	public void NonRecursionPre() {
		if(root==null) {
			return;
		}
		root.NonRecursionPre();
	}
	
	//非递归中序遍历
	public void NonRecursionIn() {
		if(root==null) {
			return;
		}
		root.NonRecursionIn();
	}
	
	//非递归后序遍历
	public void NonRecursionPost() {
		if(root==null) {
			return;
		}
		root.NonRecursionPost();
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

	public TreeNode frontSearch(int i) {
		// 树中的函数都是空壳，调用root的实现该功能的方法就vans了
		return root.frontSearch(i);
	}

	public void delete(int i) {
		// 树这里要分情况！
		// 如果删除的是根节点，则直接变成一棵空树
		if(root.value==i) {
			this.root = null;
		}
		//不是根的话，则调用根节点的删除方法
		else {
			root.delete(i);
		}
	}
}
