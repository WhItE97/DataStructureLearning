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
	}

}
