package ѭ������;

public class LoopNode {
	//װ����
	int data;
	//ָ����һ�����
	//��ע�⣡������͵�����ͬ��next��ʼ��Ϊthis����>��ʼֻ��һ����㣬ѭ������Ӧ��ָ�����Լ�
	LoopNode next=this;
	
	//��ʼ��һ����㣬��Ҫ��ֵ������һ��Ҫָ����һ�����
	public LoopNode(int data){
		this.data = data;
	}
	
	/**
	 * ����ѡ��ѻ�ȡdata��next�޸�Ϊfunc
	 * ��Ȼ��ֱ��ͨ��node.next.next.data ��������ʽҲ�ǿ��Ե�
	 * @param node
	 */
	
	//��ȡdata
	public int getData() {
		return this.data;
	}
	
	//��ȡ��һ��node
	public LoopNode nextNode() {
		return this.next;
	}
	
	//ɾ����һ�����
	public void removeNext() {
		LoopNode currentNode = this;
		currentNode.next = this.nextNode().nextNode(); 
	}
	
	//����һ�������Ϊ��ǰ�ڵ����һ�����
	public void after(LoopNode node) {
		LoopNode nextNext = this.next;
		this.next = node;
		node.next = nextNext;
	}
}
