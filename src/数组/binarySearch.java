package 数组;

import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = { 1, 3, 2, 5, 4 };
		Arrays.parallelSort(arr); // 并行排序API
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
		// ctrl shift f 快速调整格式
		mid = (left + right) / 2;
		if(left>right) 
		{
			System.out.println("无匹配");
			return -1;
		}
		if (arr[mid] == index)
			return mid;
		/**
		 * 易错点！！！
		 * 递归的时候不要直接传入mid作为其中一端！！
		 * 因为mid位置得元素已经验证了！不靠谱！
		 * 所以要进行+1或-1操作！
		 */
		else if (arr[mid] > index) // index在数组左半较小部分
		{
			bsearch(arr, index, left, mid-1);
		}	
		else //index在数组右半较大部分
		{
			bsearch(arr,index,mid+1,right);
		}
		return 0;
	}
}
