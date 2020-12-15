package ����;
/**
 *ATT
 *���Ҫ�ö������飬��������
 *��һ�������������һ���������飬��������Ԫ�ض��ǿյģ�����null
 *����Ҫ��������ʵ��������ĳ�ֵ
 *	MyQueue[] mq = new MyQueue[10];
	for(int i=0;i<10;i++) {
		mq[i] = new MyQueue();
	}
	mq[0].add(1);
	System.out.println(mq[0].poll());
 */
public class MyQueue {
	int[] elements;
	
	public MyQueue(){
		elements = new int[0];
	}
	
	//��ӣ��Ƚ��ȳ������ڶ�β
	public void add(int element) {
		int[] newArr = new int[elements.length+1];
		for(int i=0;i<elements.length;i++)
		{
			newArr[i] = elements[i];
		}
		newArr[elements.length] = element;
		elements = newArr;
	}
	
	//���ӣ��Ƚ��ȳ�������ͷԪ��
	public int poll() {
		try {
			int[] newArr = new int[elements.length-1];
			int num = elements[0];
			for(int i=0;i<elements.length-1;i++)
			{
				newArr[i] = elements[i+1];
			}
			elements = newArr;
			return num;
		}catch(NegativeArraySizeException e) {
			e.printStackTrace();
			System.out.println("����Ϊ�գ��޷�����");
			return -1;
		}
	}
	
	//�ж϶ӿ�
	public boolean isEmpty() {
		return elements.length == 0;
	}
}
