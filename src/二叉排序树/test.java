package ����������;

public class test {

	public static void main(String[] args) {
		int[] arr = new int[] {7,3,10,12,5,1,9};
		//����һ�ö���������
		BinarySortTree bst = new BinarySortTree();
		for(int i:arr) {
			bst.add(new Node(i));
		}

		bst.inorderTraversal();
		System.out.println();
		System.out.println("search value 2:"+bst.search(2));
		System.out.println("search value 5:"+bst.search(5).value);
		System.out.println("���Ҹ��ڵ�......");
		System.out.println("1�ĸ��ڵ㣺"+bst.searchParent(1).value);
//		System.out.println("ɾ��Ҷ�ӽڵ� 1��9 test...");
//		bst.delete(1);
//		bst.delete(9);
//		bst.inorderTraversal();
//		System.out.println();
//		System.out.println("ɾ�������ӽڵ� 3��10 test...");
//		bst.delete(3);
//		bst.delete(10);
//		bst.inorderTraversal();
		System.out.println("ɾ����˫�ӵĽڵ�3...");
		bst.delete(3);
		System.out.println("ɾ����˫�ӵĽڵ�7...");
		bst.delete(7);
		bst.inorderTraversal();
	}

}
