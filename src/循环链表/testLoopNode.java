package ѭ������;

public class testLoopNode {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		LoopNode l1 = new LoopNode(1);
		l1.after(new LoopNode(2));
		l1.next.after(new LoopNode(3));
		System.out.println(l1.next.next.next.data);
		System.out.println("node 3:"+l1.next.next.data);
		System.out.println("node 3.next:"+l1.next.next.next.data);
	}

}
