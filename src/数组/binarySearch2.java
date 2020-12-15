package 数组;

import java.util.Scanner;
/**
 * 通过while(true)而非递归调用函数来递归
 * @author ASUS
 *
 */
public class binarySearch2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// target记录目标数
		int target=-1;
		System.out.println("plz input a target:");
		Scanner input = new Scanner(System.in);
		if(input.hasNextInt()) {
			target = input.nextInt();
		}
//		input.close();

		// 记录对应下标输出
		int index = -1;
		//记录左边和右边
		int left = 0;
		int right = arr.length-1;
		// 记录中间位置
		int mid = (left + right) / 2;
		while (true) {
			if(left>right) {
				System.out.println("no match");
				break;
			}
			if (arr[mid] == target) {
				index = mid;
				break;
			}
			else {
				if(arr[mid]>target) {
					//target比mid小，在左边
					right = mid-1;
				}
				else {
					//target比mid打，在右边
					left = mid+1;
				}
				mid = (left+right)/2;
			}
		}
		System.out.println("index:"+index);
	}

}
