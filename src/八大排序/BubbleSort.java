package �˴�����;
import java.util.Arrays;

public class BubbleSort {
/**
 * �˴�����֮1����������֮1.1��ð������
 * ˼�룺�����Ƚϣ�ÿһ�����ִΣ�����0�ȵ�arr.length-i���ִΣ�����ð�ݳ�һ��max or min�����ұ�
 * @param args
 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] a = {5,7,2,9,4,1,0,5,7};
		BubbleSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void BubbleSort(int[] arr) {
		int temp = 0;
		for(int i = 0;i<arr.length-1;i++)
			for(int j=0;j<arr.length-1-i;j++)
			{
				if(arr[j]>arr[j+1]) 
				{
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
	}
}
