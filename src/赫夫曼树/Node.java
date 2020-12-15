package ºÕ·òÂüÊ÷;

public class Node implements Comparable<Node>{
	int value;
	private Node leftNode;
	private Node rightNode;
	
	
	public Node(int value) {
		this.value = value;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	
	@Override
	public int compareTo(Node o) {
//		return this.value-o.value;
		if(this.value<o.value) return 1;
		if(this.value==o.value) return 0;
		else return -1;
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	
	//LRDºóÐø±éÀú
	public void postorderTraversal(Node node) {
		if(node.leftNode!=null) {
			node.leftNode.postorderTraversal();
		}
		if(node.rightNode!=null) {
			node.rightNode.postorderTraversal();
		}
		System.out.println(this.value);
	}
	
	public void postorderTraversal() {
		postorderTraversal(this);
	}
}
