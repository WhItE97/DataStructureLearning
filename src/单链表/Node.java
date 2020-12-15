package ������;

public class Node {
	//װ����
	int data;
	//ָ����һ�����
	Node next;
	
	//��ʼ��һ����㣬��Ҫ��ֵ������һ��Ҫָ����һ�����
	public Node(int data){
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
	public Node nextNode() {
		return this.next;
	}
	
	//��ʾ���н����Ϣ
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
	
	//׷�ӽ��
	public Node append(Node node) {
		//����Ҫ�ҵ���ǰ��������һ�����
		Node currentNode = this;
		while(true) {
			if(currentNode.next == null) { //��һ�����Ϊ�գ������Ѿ������һ�������
				break;
			}
			currentNode = currentNode.next;
		}
		//������
		currentNode.next = node;
		return node;
	}
	
	//�ж��Ƿ������һ�����
	public boolean isLast() {
		return this.nextNode()==null;
	}
	
	//ɾ����һ�����
	public void removeNext() {
		Node currentNode = this;
		currentNode.next = this.nextNode().nextNode(); 
	}
	
	//����һ�������Ϊ��ǰ�ڵ����һ�����
	public void after(Node node) {
		Node nextNext = this.next;
		this.next = node;
		node.next = nextNext;
	}
}
