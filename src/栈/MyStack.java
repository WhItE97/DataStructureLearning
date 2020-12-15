package ջ;

import java.util.Arrays;
/**
 * ͨ�� ���� ʵ�� ջ
 * �����ĸ�����
 * ��ѹ��Ԫ��push
 * �ڵ���Ԫ��pop
 * �۲鿴ջ��Ԫ��peek
 * ���ж�ջ��isEmpty
 * @author ASUS
 *
 */
public class MyStack {
	int[] elements;
	
	public MyStack() {
		elements = new int[0];
	}
	
	//ѹ��Ԫ��
	public void push(int element) {
		int[] newArr = new int[elements.length+1];
		for(int i=0;i<elements.length;i++)
		{
			newArr[i] = elements[i];
		}
		newArr[elements.length] = element;
		elements = newArr;
	}
	
	//����ջ��Ԫ��
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
			//ע�⣡�����ﲻ��ArrayIndexOutOfBoundsException�����Ǵ��������ʱ��ͻᱨ��!
			//NegativeArraySizeException
			e.printStackTrace();
			System.out.println("ջ�գ��޷���ջ");
			return -1;
		}
	}
	
	//�鿴ջ��Ԫ��peek
	public int peek() {
		try {
			return elements[elements.length-1];
		}catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("ջ�գ���ջ��Ԫ��");
			return -1;
		}
	}
	
	//�ж�ջ�Ƿ�Ϊ��
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
