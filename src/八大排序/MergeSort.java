package �˴�����;
import java.util.Arrays;

public class MergeSort {
/**
 * �˴�����֮4.�鲢����
 * ˼�룺
 * ������ݹ��ֳ��������飨���������ǲ���һ��һ���ĵ�Ԫ�����飬�ٽ���merge������>��Ƶû�����ж����򣬶���Ĭ��ȫ��ɵ���Ԫ��������merge��
 * Ȼ��ÿ�����������ÿ��������ÿ��Ԫ�صĴ�С����merge
 * ��һ���µ�����ȥװ
 * @param args
 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = {3,12,32,4,1,43,2,5,0,6};
		mergeSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	//merge�ϲ�����
	//��Ϊʵ���������һ�����飬������Ҫ����low��high��middle�����зֳ����Ͻ���merge
	public static void merge(int[] arr,int low,int middle,int high) {
		//��һ��temp������װmerge�Ľ���������ͨ��forѭ��Ų��ԭ����arr
		int[] temp = new int[high-low+1];
		//��Ҫһ��index���ڼ�¼��ǰtemp��λ��
		int index = 0;
		//������ָ��ֱ��¼��������ĵ�ǰλ��
		int a = low;
		int b = middle+1;
		//ֻҪ���������һ������ָ��λ�ã�������ѭ��
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
		//����ѭ�������ֿ�����
		//��һ���� ��ߵ����黹������Ԫ��
		if(b>high) {
			for(int i=a;i<=middle;i++) {
				temp[index] = arr[i];
				index++;
			}
		}
		//�ڶ����� �ұߵ����黹������Ԫ��
		if(a>middle) {
			for(int i=b;i<=high;i++) {
				temp[index] = arr[i];
				index++;
			}
		}
		//����������Ҫ��temp�����Ԫ�ر����滻arr
		for(int i=0;i<temp.length;i++) {
			arr[low] = temp[i];
			low++;
		}
	}
	
	//mergeSort����
	//���ڵݹ������������
	//�����մ���merge���й鲢�����յõ���������
	public static void mergeSort(int[] arr,int low,int high) {
		//��Ҫ�������õݹ������������
		if(low<high) {
			int middle = (low+high)/2;
			mergeSort(arr,low,middle);
			mergeSort(arr,middle+1,high);
			merge(arr,low,middle,high);
		}
	}
}
