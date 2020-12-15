package 八大排序;
import java.util.Arrays;

public class QuickSort {
/**
 * 八大排序之1（交换排序）之1.2（快速排序）
 * 思想：每轮取一个pivot，小的放在其左边，大的放在其右边...递归下去
 * @param args
 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {2,4,1,5,2,3};
		QuickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 视频上的做法，和自己的分两个函数一个思路，但是写的更简洁
	 * 但是！临界值处理上要注意！这种写法在大while下的两个小while中一定要是arr[xxx]>=或<=!!!
	 * “=”不能丢！不然会产生如下注释的死循环错误
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] arr,int start,int end) {
		//要注意考虑递归进来时候的判别条件
		//所以在函数最外围加上一个start end判别
		if(start<end) {
			int left = start;
			int right = end;
			int pivot = arr[start];
			while(left<right) {
				//这里arr[right] >= pivot
				//必须有“=”是因为：
				//如果第二个小while中 arr[left]==pivot，不跳过，而置换
				//则arr[right]=arr[left]==pivot,且right没有做--处理；进入下一次大循环的时候arr[right]就始终==pivot
				//小while 1和小while 2都不会对left和right进行更改，从而导致无限地arr[left]和arr[right]互相赋值——>陷入死循环
				while(left<right && arr[right]>=pivot){
					right--;
				}
				arr[left] = arr[right];
				
				while(left<right && arr[left]<=pivot) {
					left++;
				}
				arr[right] = arr[left];
			}
			arr[left] = pivot;
			quickSort(arr,start,left-1);
			quickSort(arr,left,end);
		}
	}
	
	
	/**
	 * 习惯的做法
	 * 把快排的整个流程拆分成每个pivot一次sort + return 该pivot最终位置 从而进入递归的递归函数
	 * @param arr
	 * @param left
	 * @param right
	 * @return
	 */
	//partition旨在完成一个pivot的分割
	//返回：一个最终pivot位置的int值，以用于递归
	public static int partition(int[] arr,int left,int right) {
		int pivot = arr[left];
		while(left<right) {
//			从右到左遍历，找比pivot小的，放到左边空位（初始空位是pivot的位置）
			while(left<right) {
				if(arr[right]<pivot) {
					arr[left] = arr[right];
					//此时right位置的元素已经copy到left位置，所以该位置可算作空的
					left++;
					break;
				}
				right--;
			}
			
			
			//从左到右遍历，找比pivot大的，放到右边空位
			while(left<right) {
				if(arr[left]>pivot) {
					arr[right] = arr[left];
					right--;
					break;
				}
				left++;
			}
		}
		arr[left] = pivot;
		return left;
	}
	
	
	public static void QuickSort(int[] arr,int left,int right) {
		int mid = 0;
		if(left<right) {
			mid = partition(arr,left,right);
			QuickSort(arr,left,mid);
			QuickSort(arr,mid+1,right);
		}
		else {
			return;
		}
	}
}
