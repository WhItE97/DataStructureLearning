package EleTest;

import java.util.Stack;

public class 栈 {

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
		System.out.println("st2.search(456):"+st2.search("abc"));//search该元素距离栈顶的位置（ATT，栈顶元素的distance=1）；如果不存在该元素，则return -1
	}

}
