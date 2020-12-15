package 八大排序;
import java.util.Arrays;

public class BubbleSort {
/**
 * 八大排序之1（交换排序）之1.1（冒泡排序）
 * 思想：两两比较，每一个大轮次（即从0比到arr.length-i（轮次）），冒泡出一个max or min到最右边
 * @param args
 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] a = {5,7,2,9,4,1,0,5,7};
		BubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void BubbleSort(int[] arr) {
		int temp = 0;
		for(int i = 0;i<arr.length-1;i++)
			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1]) 
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
	}
}
