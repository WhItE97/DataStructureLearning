package �շ�����;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestHuffmanTree {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = new int[] {3,7,8,29,5,11,23,14};
		Node root = createHuffmanTree(arr);
//		System.out.println(root.value);
		//LRD�����������
		root.postorderTraversal();
	}

	
	//����huffman��
	//return��huffman���ĸ��ڵ�
	public static Node createHuffmanTree(int[] arr) {
		//�Ȱ�����������Ԫ�أ���������һ�����ڵ�Ķ�����
		List<Node> nodes = new ArrayList<Node>();
		for(int val:arr) {
			nodes.add(new Node(val));
		}
		//ѭ������
		//ֻҪNodes�����л���2�������ϸ����Ľڵ㣬�ͻ�Ҫ�ϲ�Ϊ���Ŷ�����
		while(nodes.size()>1) {
			//Ϊ��ȡ������С�Ľڵ㣬��Ҫ�Ը�ArrayList����
			//�Ķ�JAVA API����>sort�������÷���Ĭ�ϸ�����Ȼ˳�����������Զ���Ԫ�أ���Ҫ���Զ���Ԫ����ʵ��һ��Comparable�ӿڣ������Զ����������
			//����ʵ�ֵ��Ƿ��򣬴����ǰ��С���ں�����ÿ��ȡ�������
			Collections.sort(nodes); 
			//�ֱ�ȡ��������ڵ�
			Node left = nodes.get(nodes.size()-1);//С�������
			Node right = nodes.get(nodes.size()-2);
			//ȡ�˺�Ҫ��list��ɾ��
//			nodes.remove(nodes.size()-1);
//			nodes.remove(nodes.size()-1);//���ַ�ʽɾ��������ڵ�Ҳ��ok��
			nodes.remove(left);
			nodes.remove(right);
			//��ϳ�һ���ڵ�
			Node parent = new Node(left.value+right.value);
			parent.setLeftNode(left);
			parent.setRightNode(right);
			//�����ںϽڵ�Ž�list
			nodes.add(parent);
		}
		return nodes.get(0);
	}
}
