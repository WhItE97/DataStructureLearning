package ����;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = { 1, 3, 2, 5, 4 };
		Arrays.parallelSort(arr); // ��������API
//		System.out.println(Arrays.toString(arr));
		System.out.println("plz input a number to search:");
		Scanner input = new Scanner(System.in);
		int num=-1;
		if(input.hasNextInt()) {
			num = input.nextInt();
		}
		input.close();
		int posi = bsearch(arr,num,0,arr.length-1);
		System.out.println("posi:"+posi);
	}

	public static int bsearch(int[] arr, int index, int left, int right) {
		int mid = -1;
		// ctrl shift f ���ٵ�����ʽ
		mid = (left + right) / 2;
		if(left>right) 
		{
			System.out.println("��ƥ��");
			return -1;
		}
		if (arr[mid] == index)
			return mid;
		/**
		 * �״�㣡����
		 * �ݹ��ʱ��Ҫֱ�Ӵ���mid��Ϊ����һ�ˣ���
		 * ��Ϊmidλ�õ�Ԫ���Ѿ���֤�ˣ������ף�
		 * ����Ҫ����+1��-1������
		 */
		else if (arr[mid] > index) // index����������С����
		{
			bsearch(arr, index, left, mid-1);
		}	
		else //index�������Ұ�ϴ󲿷�
		{
			bsearch(arr,index,mid+1,right);
		}
		return 0;
	}
}
