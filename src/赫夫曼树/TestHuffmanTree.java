package 赫夫曼树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestHuffmanTree {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[] {3,7,8,29,5,11,23,14};
		Node root = createHuffmanTree(arr);
//		System.out.println(root.value);
		//LRD后序遍历该树
		root.postorderTraversal();
	}

	
	//创建huffman树
	//return：huffman树的根节点
	public static Node createHuffmanTree(int[] arr) {
		//先把数组中所有元素，都创建成一个单节点的二叉树
		List<Node> nodes = new ArrayList<Node>();
		for(int val:arr) {
			nodes.add(new Node(val));
		}
		//循环处理
		//只要Nodes集合中还有2个及以上个数的节点，就还要合并为最优二叉树
		while(nodes.size()>1) {
			//为了取两个最小的节点，先要对该ArrayList排序
			//阅读JAVA API——>sort有两种用法，默认根据自然顺序排序。这种自定义元素，需要该自定义元素类实现一个Comparable接口，并且自定义排序规则
			//这里实现的是反序，大的在前，小的在后，所以每次取最后两个
			Collections.sort(nodes); 
			//分别取最后两个节点
			Node left = nodes.get(nodes.size()-1);//小的在左边
			Node right = nodes.get(nodes.size()-2);
			//取了后要从list中删除
//			nodes.remove(nodes.size()-1);
//			nodes.remove(nodes.size()-1);//这种方式删最后两个节点也是ok的
			nodes.remove(left);
			nodes.remove(right);
			//结合成一个节点
			Node parent = new Node(left.value+right.value);
			parent.setLeftNode(left);
			parent.setRightNode(right);
			//把新融合节点放进list
			nodes.add(parent);
		}
		return nodes.get(0);
	}
}
