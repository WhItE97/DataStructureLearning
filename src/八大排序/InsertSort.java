package 八大排序;
import java.util.Arrays;

public class InsertSort {
/**
 * 八大排序之2插入排序之2.1直接插入排序
 * 思想：
 * 从第一个数开始遍历
 * 将该数与其前一个数比较
 * 如果更小，则交换二者，然后继续递归的将该轮的数与再前一个数比较，递归直到该数大于等于前一个数
 * 如果等于或更大，则直接进入下一个数的遍历（因为从第一个数开始遍历，所以第i个数遍历时，其前方i-1个数已经是有序数组）
 * @param args
 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {4,5,2,1,3,23,43,21,3,4,2,1};
		InsertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void InsertSort(int[] arr) {
		//i用来从第一个数指到最后一个数,但第一个数肯定有序了，所以从i=1开始
		for(int i=1;i<arr.length;i++) {
			//原数组第i个数，最多要比较i-1次（此为最差情况，即i是最小的）
			int j = i-1;
			//arr[i]>=arr[i-1]，则第i个大于前面所有i-1个有序数组，所以直接continue
			if(arr[i]>=arr[j])
				continue;
			//通过递归j找到一个arr[i]<arr[j]的位置
			while(j>=0) {
				if(arr[i]<arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
				i--;
				j--;
			}
		}
	}
}
