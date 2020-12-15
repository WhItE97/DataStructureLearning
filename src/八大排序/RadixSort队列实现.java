package �˴�����;
import java.util.Arrays;

import ����.MyQueue;


public class RadixSort����ʵ�� {
/**
 * ����������Ż�����>ͨ������ʵ��(����Ϊ֮ǰ�Լ���ʵ�ֵ�MyQueue)
 * @param args
 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = new int[]{23,6,189,45,9,287,56,1,798,34,65,652,5};
		RadixSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void RadixSort(int[] arr) {
		//�Լ���˼·��ͨ���ж�0Ͱ�е�Ԫ�ظ����Ƿ�==arr.length���ж���������>���һ����Ͱ���������ˡ���>ֱ���ҵ���һ��for�ҵ�max
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		
		//����maxȡ�����λ����������>�����ˣ�����ͨ����max+�������ַ���תΪString����.length�õ�λ��
		int maxLength = (max+"").length();
		//����һ����ά��������ģ��Ͱ##########��ɶ��к�Ͳ���Ҫ������г����ˣ�����һ��ʮά�Ķ��м���
//		int[][] temp = new int[10][arr.length];
		MyQueue[] temp = new MyQueue[10];
		for(int t=0;t<10;t++) {
			temp[t] = new MyQueue();
		}
		//����һ��һά�������ڴ��ÿ��Ͱ�е�Ԫ�ظ���############���в���Ҫ�ټ�¼Ͱ��Ԫ�ظ�����
//		int[] tempIndex = new int[10];
		//Ϊ�˷������������+ȡ�������������for�ټ���һ������
		//��һ��ѭ�������ڼ�¼���������ÿλ������Ӧһ������
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			//�ڶ���ѭ�������ڱ���������
			for(int j=0;j<arr.length;j++) {
				//��ÿ����ȡ��Ӧ���ִε�λ���ϵ���
				int ys = arr[j]/n%10;
				//���ݸ����ַ����ӦͰ
				temp[ys].add(arr[j]);
			}
			//��Ͱ��������һ�ִε���Ͱ׼��
			//k���ڴ�0��ʼ��������9Ͱ
			//p��¼����arr�ĽǱ�
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
