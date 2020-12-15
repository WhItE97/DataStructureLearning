package 队列;
/**
 *ATT
 *如果要用队列数组，必须如下
 *第一句仅仅是声明了一个队列数组，但是数组元素都是空的，都是null
 *还需要遍历赋以实例化对象的初值
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
	
	//入队：先进先出，插在队尾
	public void add(int element) {
		int[] newArr = new int[elements.length+1];
		for(int i=0;i<elements.length;i++)
		{
			newArr[i] = elements[i];
		}
		newArr[elements.length] = element;
		elements = newArr;
	}
	
	//出队：先进先出，出队头元素
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
			System.out.println("队列为空，无法出队");
			return -1;
		}
	}
	
	//判断队空
	public boolean isEmpty() {
		return elements.length == 0;
	}
}
