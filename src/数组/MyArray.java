package 数组;

import java.util.Arrays;

public class MyArray {
	//首先！！！要有一个用于存储数据的数组
	private int[] arr;
	
	//init
	public MyArray()
	{
		arr = new int[0];
	}
	
	//获取长度
	public int size()
	{
		return arr.length;
	}
	
	//输出当前数组
	public void show()
	{
		/*注意：Object类的toString方法：
		 * 
		public String toString() {   
			return getClass().getName() + "@" + Integer.toHexString(hashCode());   
		}
		输出的是“类型@哈希值”
		Object.toString 和 Arrays.toString(arr) 两者仅仅是重名函数，没有复写
		数组类中并没有对此方法重写(override)，仅仅是重载(overload)为类的静态方法
		*/   
		System.out.println(Arrays.toString(arr));
	}
	
	//添加元素到末尾
	public void add(int num)
	{
		int[] newArr = new int[arr.length+1];
		for(int i=0;i<arr.length;i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = num;
		arr = newArr;
	}
	
	//根据下标删除某个元素
	public void delete(int index)
	{
		if(index>arr.length-1||index<0)
		{
			System.out.println("index out of range");
			return;
		}
		int[] newArr = new int[arr.length-1];
		for(int i=0;i<arr.length-1;i++)
		{
			if(i<index)
			{
				newArr[i] = arr[i];
				continue;
			}
			else
			{
				newArr[i] = arr[i+1];
				continue;
			}
		}
		arr = newArr;
	}
	
	//取出指定位置元素
	public int get(int index)
	{
		int c = arr[index];
		return c;
	}
	
	//插入元素到指定位置
	public void insert(int index,int num)
	{
		if(index<0||index>arr.length)
		{
			System.out.println("index out of range");
			return;
		}
		int[] newArr = new int[arr.length+1];
		for(int i=0;i<arr.length;i++)
		{
			if(i<index)
			{
				newArr[i] = arr[i];
				continue;
			}
			else 
			{
				newArr[i+1] = arr[i];
				continue;
			}
		}
		newArr[index] = num;
		arr = newArr;
	}
	
	//替换指定位置的元素
	public void replace(int index,int num)
	{
		if(index<0 || index>=arr.length)
		{
			/*System.out.println("index out of range");
			return;*/
			throw new RuntimeException("下标越界");
		}
		arr[index] = num;
	}
}
