package ջ;

public class MyStackTest {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		MyStack st = new MyStack();
		st.push(1);
		st.push(2);
		st.push(4);
		st.push(5);
		System.out.println(st.pop());
		System.out.println("top:"+st.peek());
		System.out.println(st.pop());
		System.out.println("top:"+st.peek());
		System.out.println(st.pop());
		System.out.println("top:"+st.peek());
		System.out.println("isEmpty:"+st.isEmpty());
		System.out.println(st.pop());
		System.out.println("isEmpty:"+st.isEmpty());
		System.out.println(st.pop());
		System.out.println(st.peek());
	}

}
