package 单链表;

public class testNode {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.append(n2).append(n3);
//		n1.append(n3);
		n1.append(new Node(4));
		
		// 以下两种方式都可以
//		System.out.println(n1.next.next.next.data); //直接调用属性的方式获取值
//		System.out.println(n1.nextNode().nextNode().nextNode().getData()); //把data的获取和nextNode的获取封装在函数里的方式获取值
//		
//		System.out.println(n1.isLast());
//		System.out.println(n3.nextNode().isLast());
		n1.show();
		
//		if(n1.nextNode().nextNode().nextNode().nextNode()==null) { System.out.println("是null");} //test如果只有四个结点，通过next访问到第五个结点，确实==null
		
//		n1.removeNext(node)
		n1.removeNext();
		System.out.println("======after delete n1.next=======");
		n1.show();
		
		n1.nextNode().after(new Node(9));
		System.out.println("======after 插在n1.next的后面=======");
		n1.show();
	}

}
