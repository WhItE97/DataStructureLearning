package 二叉排序树;

public class test {

	public static void main(String[] args) {
		int[] arr = new int[] {7,3,10,12,5,1,9};
		//创建一棵二叉排序树
		BinarySortTree bst = new BinarySortTree();
		for(int i:arr) {
			bst.add(new Node(i));
		}

		bst.inorderTraversal();
		System.out.println();
		System.out.println("search value 2:"+bst.search(2));
		System.out.println("search value 5:"+bst.search(5).value);
		System.out.println("查找父节点......");
		System.out.println("1的父节点："+bst.searchParent(1).value);
//		System.out.println("删除叶子节点 1，9 test...");
//		bst.delete(1);
//		bst.delete(9);
//		bst.inorderTraversal();
//		System.out.println();
//		System.out.println("删除单儿子节点 3，10 test...");
//		bst.delete(3);
//		bst.delete(10);
//		bst.inorderTraversal();
		System.out.println("删除有双子的节点3...");
		bst.delete(3);
		System.out.println("删除有双子的节点7...");
		bst.delete(7);
		bst.inorderTraversal();
	}

}
