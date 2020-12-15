package 八大排序;
import java.util.Arrays;

public class ShellSort {
/**
 * 八大排序之2.插入排序 之2.2希尔排序
 * 思想：
 * 按步长分组进行插入排序
 * 步长初始=len/2
 * 之后以/2的方式进行迭代
 * 直到步长=0，终止排序
 * @param args
 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = {5,7,6,23,4,3,3,1,5,7,6,23,54};
		ShellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void ShellSort(int[] arr) {
		// 设置初始步长
		// 【步长】也叫【增量】 
		// eg：arr.length=9 有 step=9/2=5——>步长=5，分成了5组
		// 【步长】==【组数】的理解：步长等于5，则第一组第一个和第一组第二个间隔了4个，所以组数=第一组第一个+4个间隔的=5=步长
		
		//第一个循环用于遍历步长，直至等于0
		for(int step=arr.length/2;step>0;step/=2) {
			//第二个循环用于遍历所有（!注意是所有！即插入排序，从每组的第二个元素开始向前比，因为第一个已经默认有序了）元素
			for(int i=step;i<arr.length;i++) {
				//第三个循环用于遍历本组中的所有元素
				//j是当前元素，要从其当前位置，每次-step，一直比较，直到到达他该在的位置——>即对每一组，进行直接插入排序的过程
				for(int j=i;j>=step;j-=step) {
					if(arr[j]<arr[j-step]) {
						int temp = arr[j];
						arr[j] = arr[j-step];
						arr[j-step] = temp;
					}
//					//自己加的，感觉这样在不用挪的时候直接break出去而不是continue，会更省时间
//					else 
//						break;
				}
			}
		}
		
	}
}

/**
 * 下面是自己第一次的错误做法
 *
//第一个循环用于迭代至步长=0的时候结束排序
		for(int step=arr.length/2;step>0;step/=2) {
			//第二个循环用于迭代该步长下所有组
			//group从0进行+1操作——>最后一组的第一个元素——》【错了！！这样只迭代了每组第一个元素】
			for(int group=0;group<step;group++) {
				//第三个循环：得到每个组的首个元素后，对每个组进行直接插入排序
				for(int i=group;i<arr.length-step;i+=step) {
					//对每组 从该组首个元素开始遍历
					//如果下一个元素大于他，则交换
					if(arr[i]>arr[i+step]) {
						int temp = arr[i+step];
						arr[i+step] = arr[i];
						arr[i] = temp;
					}
				}
			}
		}
*/
