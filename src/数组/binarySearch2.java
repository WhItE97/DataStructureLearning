package ����;

import java.util.Scanner;
/**
 * ͨ��while(true)���ǵݹ���ú������ݹ�
 * @author ASUS
 *
 */
public class binarySearch2 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		// target��¼Ŀ����
		int target=-1;
		System.out.println("plz input a target:");
		Scanner input = new Scanner(System.in);
		if(input.hasNextInt()) {
			target = input.nextInt();
		}
//		input.close();

		// ��¼��Ӧ�±����
		int index = -1;
		//��¼��ߺ��ұ�
		int left = 0;
		int right = arr.length-1;
		// ��¼�м�λ��
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
					//target��midС�������
					right = mid-1;
				}
				else {
					//target��mid�����ұ�
					left = mid+1;
				}
				mid = (left+right)/2;
			}
		}
		System.out.println("index:"+index);
	}

}
