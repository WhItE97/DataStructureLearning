package 八大排序;
import java.util.Arrays;

import 队列.MyQueue;


public class RadixSort队列实现 {
/**
 * 基数排序的优化——>通过队列实现(队列为之前自己的实现的MyQueue)
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
		//创建一个二维数组用于模拟桶##########变成队列后就不需要在意队列长度了，声明一个十维的队列即可
//		int[][] temp = new int[10][arr.length];
		MyQueue[] temp = new MyQueue[10];
		for(int t=0;t<10;t++) {
			temp[t] = new MyQueue();
		}
		//创建一个一维数组用于存放每个桶中的元素个数############队列不需要再记录桶中元素个数了
//		int[] tempIndex = new int[10];
		//为了方便后续的整除+取余操作，可以在for再加入一个变量
		//第一个循环：用于记录排序次数（每位数，对应一次排序）
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			//第二个循环：用于遍历所有数
			for(int j=0;j<arr.length;j++) {
				//对每个数取对应该轮次的位置上的数
				int ys = arr[j]/n%10;
				//根据该数字放入对应桶
				temp[ys].add(arr[j]);
			}
			//出桶，进入下一轮次的入桶准备
			//k用于从0开始遍历到第9桶
			//p记录存入arr的角标
			int p = 0;
			for(int k=0;k<10;k++) {
				while(!temp[k].isEmpty()) {
					arr[p] = temp[k].poll();
					p++;
				}
			}
		}
	}

}
