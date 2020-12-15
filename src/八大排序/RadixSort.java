package 八大排序;
import java.util.Arrays;

public class RadixSort {
/**
 * 八大排序之5.基数排序
 * 思想：
 * 第一轮：按照个位数将所有数放入0-9十个桶里，然后按放入顺序，先进先出的取出，得到一个新的序列
 * 第二轮：按照十位数字进行同上操作
 * ...
 * 重复直至最大数的最高位，得到的输出序列，已经是有序序列
 * @param args
 */
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[]{23,6,189,45,9,287,56,1,798,34,65,652,5};
		RadixSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void RadixSort(int[] arr) {
		//自己的思路，通过判断0桶中的元素个数是否==arr.length来判定结束——>最后一轮入桶操作冗余了——>直接找到先一个for找到max
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		//根据max取到最高位来迭代——>复杂了，可以通过把max+“”空字符串转为String，再.length得到位数
		int maxLength = (max+"").length();
		//创建一个二维数组用于模拟桶
		int[][] temp = new int[10][arr.length];
		//创建一个一维数组用于存放每个桶中的元素个数
		int[] tempIndex = new int[10];
		//为了方便后续的整除+取余操作，可以在for再加入一个变量
		//第一个循环：用于记录排序次数（每位数，对应一次排序）
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			//第二个循环：用于遍历所有数
			for(int j=0;j<arr.length;j++) {
				//对每个数取对应该轮次的位置上的数
				int ys = arr[j]/n%10;
				//根据该数字放入对应桶
				temp[ys][tempIndex[ys]] = arr[j];
				tempIndex[ys]++;
			}
			//出桶，进入下一轮次的入桶准备
			//k用于从0开始遍历到第9桶
			//p记录存入arr的角标
			int p = 0;
			for(int k=0;k<10;k++) {
				//tempIndex[k]只要没--到0，就说明该桶中还有数字
				//再用一个m取桶中数字
				int m=0;
				while(tempIndex[k]!=0) {
					arr[p] = temp[k][m];
					p++;
					m++;
					tempIndex[k]--;
				}
			}
		}
	}
}
