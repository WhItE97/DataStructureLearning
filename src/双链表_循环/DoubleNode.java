package ˫����_ѭ��;

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
	
	//�ڵ��÷����Ľ������һ�����
	public void after(DoubleNode node) {
		//ȡԭ������һ�����
		DoubleNode nextNext = this.next;
		//����������������
		//1.����ǰ�ڵ���²���ڵ�Ļ�ָ��ϵ
		this.next = node;
		node.prior = this;
		//2.������һ�������²�����Ļ�ָ��ϵ
		nextNext.prior = node;
		node.next = nextNext;
	}
	
	//ɾ�����÷������ĺ�һ�����
	public void removeNext() {
		DoubleNode delNode = this.next;
		this.next.next.prior = this;
		this.next = delNode.next;
	}
}
