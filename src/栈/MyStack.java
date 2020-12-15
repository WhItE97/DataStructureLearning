package 栈;

import java.util.Arrays;
/**
 * 通过 数组 实现 栈
 * 包括四个操作
 * ①压入元素push
 * ②弹出元素pop
 * ③查看栈顶元素peek
 * ④判断栈空isEmpty
 * @author ASUS
 *
 */
public class MyStack {
	int[] elements;
	
	public MyStack() {
		elements = new int[0];
	}
	
	//压入元素
	public void push(int element) {
		int[] newArr = new int[elements.length+1];
		for(int i=0;i<elements.length;i++)
		{
			newArr[i] = elements[i];
		}
		newArr[elements.length] = element;
		elements = newArr;
	}
	
	//弹出栈顶元素
	public int pop() {
		try {
			int[] newArr = new int[elements.length-1];
			int ret = elements[elements.length-1];
			for(int i=0;i<elements.length-1;i++)
			{
				newArr[i] = elements[i];
			}
			elements = newArr;
			return ret;
		}catch(Exception e) {
			//注意！！这里不是ArrayIndexOutOfBoundsException！！是创建数组的时候就会报错!
			//NegativeArraySizeException
			e.printStackTrace();
			System.out.println("栈空，无法出栈");
			return -1;
		}
	}
	
	//查看栈顶元素peek
	public int peek() {
		try {
			return elements[elements.length-1];
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("栈空，无栈顶元素");
			return -1;
		}
	}
	
	//判断栈是否为空
	public boolean isEmpty() {
		if(elements.length==0)
			return true;
		return false;
	}
	
	//use for test by self
	public void show() {
		System.out.println("elements:"+Arrays.toString(elements));
	}
}
