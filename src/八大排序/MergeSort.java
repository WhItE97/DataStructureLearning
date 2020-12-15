package 八大排序;
import java.util.Arrays;

public class MergeSort {
/**
 * 八大排序之4.归并排序
 * 思想：
 * 将数组递归拆分成有序数组（如果无序就是拆解成一个一个的单元素数组，再进行merge）——>视频没体现判断有序，而是默认全拆成单个元素数组再merge了
 * 然后每两个数组根据每个数组中每个元素的大小进行merge
 * 用一个新的数组去装
 * @param args
 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {3,12,32,4,1,43,2,5,0,6};
		mergeSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	//merge合并函数
	//因为实际输入的是一个数组，所以需要给我low，high，middle用于切分成两断进行merge
	public static void merge(int[] arr,int low,int middle,int high) {
		//用一个temp数组来装merge的结果，最后再通过for循环挪回原来的arr
		int[] temp = new int[high-low+1];
		//需要一个index用于记录当前temp中位置
		int index = 0;
		//用两个指针分别记录两个数组的当前位置
		int a = low;
		int b = middle+1;
		//只要数组的其中一方超过指的位置，则跳出循环
		while(a<=middle && b<=high) {
			if(arr[a]<=arr[b]) {
				temp[index] = arr[a];
				a++;
			}
			else {
				temp[index] = arr[b];
				b++;
			}
			index++;
		}
		//跳出循环有两种可能性
		//第一种是 左边的数组还有余下元素
		if(b>high) {
			for(int i=a;i<=middle;i++) {
				temp[index] = arr[i];
				index++;
			}
		}
		//第二种是 右边的数组还有余下元素
		if(a>middle) {
			for(int i=b;i<=high;i++) {
				temp[index] = arr[i];
				index++;
			}
		}
		//接下来还需要把temp数组的元素遍历替换arr
		for(int i=0;i<temp.length;i++) {
			arr[low] = temp[i];
			low++;
		}
	}
	
	//mergeSort函数
	//用于递归拆分输入的数组
	//并最终传入merge进行归并，最终得到有序数组
	public static void mergeSort(int[] arr,int low,int high) {
		//不要忘了设置递归结束的条件！
		if(low<high) {
			int middle = (low+high)/2;
			mergeSort(arr,low,middle);
			mergeSort(arr,middle+1,high);
			merge(arr,low,middle,high);
		}
	}
}
