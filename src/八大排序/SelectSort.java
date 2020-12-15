package 八大排序;
import java.util.Arrays;

public class SelectSort {
/**
 * 八大排序之3.选择排序 之3.3简单选择排序
 * 思想：
 * 从数组中找到一个最小的数字，挪到第一个位置
 * 递归以上过程
 * @param args
 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {1,3,2,5,4,1,1,2,4,2,34};
		SelectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void SelectSort(int[] arr) {
		//第一个循环：遍历所有的数
		for(int i=0;i<arr.length;i++) {
			int min = arr[i];//其实也可以不记录min值，记录了min的下标即可
			int min_posi = i;
			//第二个循环：对该遍历数，所有排在它后面的，都要全部和他进行比较，并且记录下min的下标index
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<min) {
					min = arr[j];
					min_posi = j;
				}
			}
			int temp = arr[i];
			arr[i] =min;
			arr[min_posi] = temp;
		}
	}
}
