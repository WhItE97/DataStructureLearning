package EleTest;

import java.util.Stack;

public class ջ {

	public static void main(String[] args) {
		Stack st = new Stack();
		
		st.push(1);
		System.out.println("peek:"+st.peek());
		int a = (int)st.pop();
		st.addElement(2);
		System.out.println("a="+a);
		System.out.println("pop2:"+(int)st.pop());
		
		Stack<String> st2 = new Stack<String>();
		st2.push("abc");
		System.out.println("st2.pop:"+st2.pop());
		st2.push("123");
		st2.push("456");
		System.out.println("st2.search(456):"+st2.search("abc"));//search��Ԫ�ؾ���ջ����λ�ã�ATT��ջ��Ԫ�ص�distance=1������������ڸ�Ԫ�أ���return -1
	}

}
