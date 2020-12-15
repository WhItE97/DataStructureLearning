package 二叉排序树;

public class BinarySortTree {
	Node root;
	
	//添加节点（or构建二叉排序树）
	public void add(Node node) {
		//如果是空树
		if(root==null) {
			root = node;
		}
		else {
			root.add(node);
		}
	}
	
	//查找
	public Node search(int value) {
		if(root==null) {
			return null;
		}
		return root.search(value);
	}
	
	//中序遍历
	public void inorderTraversal() {
		root.NonRecursionInTraversal();
	}
	
}
