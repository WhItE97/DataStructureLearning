package ������;

public class testNode {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.append(n2).append(n3);
//		n1.append(n3);
		n1.append(new Node(4));
		
		// �������ַ�ʽ������
//		System.out.println(n1.next.next.next.data); //ֱ�ӵ������Եķ�ʽ��ȡֵ
//		System.out.println(n1.nextNode().nextNode().nextNode().getData()); //��data�Ļ�ȡ��nextNode�Ļ�ȡ��װ�ں�����ķ�ʽ��ȡֵ
//		
//		System.out.println(n1.isLast());
//		System.out.println(n3.nextNode().isLast());
		n1.show();
		
//		if(n1.nextNode().nextNode().nextNode().nextNode()==null) { System.out.println("��null");} //test���ֻ���ĸ���㣬ͨ��next���ʵ��������㣬ȷʵ==null
		
//		n1.removeNext(node)
		n1.removeNext();
		System.out.println("======after delete n1.next=======");
		n1.show();
		
		n1.nextNode().after(new Node(9));
		System.out.println("======after ����n1.next�ĺ���=======");
		n1.show();
	}

}
