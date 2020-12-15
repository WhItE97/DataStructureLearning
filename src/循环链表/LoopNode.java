package 循环链表;

public class LoopNode {
	//装数据
	int data;
	//指向下一个结点
	//【注意！】这里和单链表不同，next初始化为this——>初始只有一个结点，循环链表应该指向他自己
	LoopNode next=this;
	
	//初始化一个结点，需要有值，但不一定要指向下一个结点
	public LoopNode(int data){
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
	public LoopNode nextNode() {
		return this.next;
	}
	
	//删除下一个结点
	public void removeNext() {
		LoopNode currentNode = this;
		currentNode.next = this.nextNode().nextNode(); 
	}
	
	//插入一个结点作为当前节点的下一个结点
	public void after(LoopNode node) {
		LoopNode nextNext = this.next;
		this.next = node;
		node.next = nextNext;
	}
}
