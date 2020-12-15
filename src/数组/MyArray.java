package ����;

import java.util.Arrays;

public class MyArray {
	//���ȣ�����Ҫ��һ�����ڴ洢���ݵ�����
	private int[] arr;
	
	//init
	public MyArray()
	{
		arr = new int[0];
	}
	
	//��ȡ����
	public int size()
	{
		return arr.length;
	}
	
	//�����ǰ����
	public void show()
	{
		/*ע�⣺Object���toString������
		 * 
		public String toString() {   
			return getClass().getName() + "@" + Integer.toHexString(hashCode());   
		}
		������ǡ�����@��ϣֵ��
		Object.toString �� Arrays.toString(arr) ���߽���������������û�и�д
		�������в�û�жԴ˷�����д(override)������������(overload)Ϊ��ľ�̬����
		*/   
		System.out.println(Arrays.toString(arr));
	}
	
	//���Ԫ�ص�ĩβ
	public void add(int num)
	{
		int[] newArr = new int[arr.length+1];
		for(int i=0;i<arr.length;i++) {
			newArr[i] = arr[i];
		}
		newArr[arr.length] = num;
		arr = newArr;
	}
	
	//�����±�ɾ��ĳ��Ԫ��
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
	
	//ȡ��ָ��λ��Ԫ��
	public int get(int index)
	{
		int c = arr[index];
		return c;
	}
	
	//����Ԫ�ص�ָ��λ��
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
	
	//�滻ָ��λ�õ�Ԫ��
	public void replace(int index,int num)
	{
		if(index<0 || index>=arr.length)
		{
			/*System.out.println("index out of range");
			return;*/
			throw new RuntimeException("�±�Խ��");
		}
		arr[index] = num;
	}
}
