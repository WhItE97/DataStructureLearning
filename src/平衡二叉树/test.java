package ƽ�������;

public class test {

	public static void main(String[] args) {
//		int[] arr = new int[] {8,9,6,7,5,4};//LL��test
//		int[] arr = new int[] {2,1,4,3,5,6};//RR��test
//		int[] arr = new int[] {5,2,7,1,4,3};//LR��test
		int[] arr = new int[] {2,1,5,4,6,3};//RL��test
		//����һ�ö���������
		BinarySortTree bst = new BinarySortTree();
		for(int i:arr) {
			bst.add(new Node(i));
		}

		bst.inorderTraversal();
		
//		System.out.println();
//		System.out.println("height now:"+bst.root.height());;
//		System.out.println("root now(not 8,should be 6):"+bst.root.value);//LL��test
		
//		System.out.println();
//		System.out.println("height now(should be 3):"+bst.root.height());
//		System.out.println("root now(not 2,should be 4):"+bst.root.value);//RR��test
		
//		System.out.println();
//		System.out.println("height now(should be 3):"+bst.root.height());
//		System.out.println("root now(not 5,should be 4):"+bst.root.value);//LR��test
		
		System.out.println();
		System.out.println("height now(should be 3):"+bst.root.height());
		System.out.println("root now(not 2,should be 4):"+bst.root.value);//RL��test
	}

}
