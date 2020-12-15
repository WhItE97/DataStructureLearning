package 双链表_循环;

public class test {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		DoubleNode d1 = new DoubleNode(1);
		DoubleNode d2 = new DoubleNode(2);
		DoubleNode d3 = new DoubleNode(3);
		
		d1.after(d2);
		d2.after(d3);
		System.out.println("d2:"+d1.next.data);
		System.out.println("d3:"+d1.prior.data);
		System.out.println("d3:"+d2.next.data);
		System.out.println("d1:"+d3.next.data);
		
		DoubleNode d4 = new DoubleNode(4);
		d3.after(d4);
		d1.removeNext();
		System.out.println("d3:"+d1.next.data);
		System.out.println("d4:"+d3.next.data);
		System.out.println("d1:"+d4.next.data);
		System.out.println("d4:"+d1.prior.data);
	}

}
