package 单链表;

public class Node {
	//装数据
	int data;
	//指向下一个结点
	Node next;
	
	//初始化一个结点，需要有值，但不一定要指向下一个结点
	public Node(int data){
		this.data = data;
	}
	
	/**
	 * 可以选择把获取data和next修改为func
	 * 当然，直接通过node.next.next.data 这样的形式也是可以的
	 * @param node
	 */
	
	//获取data
	public int getData() {
		return this.data;
	}
	
	//获取下一个node
	public Node nextNode() {
		return this.next;
	}
	
	//显示所有结点信息
	public void show() {
		int i = 1;
		Node n;
		n = this;
		while(n!=null) {
			System.out.println("node "+i+":"+n.data);
			i++;
			n = n.next;
		}
	}
	
	//追加结点
	public Node append(Node node) {
		//首先要找到当前链表的最后一个结点
		Node currentNode = this;
		while(true) {
			if(currentNode.next == null) { //下一个结点为空，所以已经是最后一个结点了
				break;
			}
			currentNode = currentNode.next;
		}
		//插入结点
		currentNode.next = node;
		return node;
	}
	
	//判断是否是最后一个结点
	public boolean isLast() {
		return this.nextNode()==null;
	}
	
	//删除下一个结点
	public void removeNext() {
		Node currentNode = this;
		currentNode.next = this.nextNode().nextNode(); 
	}
	
	//插入一个结点作为当前节点的下一个结点
	public void after(Node node) {
		Node nextNext = this.next;
		this.next = node;
		node.next = nextNext;
	}
}
