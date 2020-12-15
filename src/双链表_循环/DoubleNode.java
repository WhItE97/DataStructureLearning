package 双链表_循环;

public class DoubleNode {

	int data;
	DoubleNode next;
	DoubleNode prior;
	
	public DoubleNode(int data) {
		this.data = data;
		this.next = this;
		this.prior = this;
	}
	
	public DoubleNode getNext() {
		return this.next;
	}
	
	public DoubleNode getPrior() {
		return this.prior;
	}
	
	//在调用方法的结点后插入一个结点
	public void after(DoubleNode node) {
		//取原来的下一个结点
		DoubleNode nextNext = this.next;
		//接下来分两步处理
		//1.处理当前节点和新插入节点的互指关系
		this.next = node;
		node.prior = this;
		//2.处理下一个结点和新插入结点的互指关系
		nextNext.prior = node;
		node.next = nextNext;
	}
	
	//删除调用方法结点的后一个结点
	public void removeNext() {
		DoubleNode delNode = this.next;
		this.next.next.prior = this;
		this.next = delNode.next;
	}
}
