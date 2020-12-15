package 二叉树;

public class TestBinaryTree {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//创建一颗二叉树
		BinaryTree binTree = new BinaryTree();
		//创建一个结点
		TreeNode root = new TreeNode(1);
		//将该节点赋给树做根节点
		binTree.setRoot(root);
		//为根节点添加一个左节点和一个右节点
		TreeNode leftnode = new TreeNode(2);
		TreeNode rightnode = new TreeNode(3);
		//将此二子节点通过setter方法设置到根节点的左右子节点
		binTree.root.setleftNode(leftnode);//视频里 没加binTree，直接用的root.
		binTree.root.setrightNode(rightnode);
		
		//多添加几个节点，用于测试DLR,LDR,LRD三种遍历方式
		root.leftNode.leftNode = new TreeNode(4);
		root.leftNode.rightNode = new TreeNode(5);
		root.rightNode.leftNode = new TreeNode(6);
		root.rightNode.rightNode = new TreeNode(7);
		//理想结果
		//DLR：1245367
		//LDR：4251637
		//LRD：4526731
		System.out.println("先序遍历DLR:");
		binTree.preorderTraversal();
		System.out.println();
		System.out.println("中序遍历LDR:");
		binTree.inorderTraversal();
		System.out.println();
		System.out.println("后序遍历LRD:");
		binTree.postorderTraversal();
		System.out.println();
		
		//前序查找
//		TreeNode res = binTree.frontSearch(3);
//		System.out.println(res==rightnode);
		
		//删除一个节点/子树（对普通二叉树而言，如果删除的节点不是叶子，则连带其儿子一起删掉）
//		binTree.delete(3);
//		System.out.println("删除元素后，后序遍历：");
//		binTree.postorderTraversal();
		
		//非递归前序遍历
		System.out.println("非递归先序遍历DLR:");
		binTree.NonRecursionPre();
		System.out.println();
		System.out.println("非递归中序遍历DLR:");
		binTree.NonRecursionIn();
		System.out.println();
		System.out.println("非递归后序遍历LRD:");
		binTree.NonRecursionPost();
	}

}
