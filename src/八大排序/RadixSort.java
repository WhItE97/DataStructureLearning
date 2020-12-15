package �˴�����;
import java.util.Arrays;

public class RadixSort {
/**
 * �˴�����֮5.��������
 * ˼�룺
 * ��һ�֣����ո�λ��������������0-9ʮ��Ͱ�Ȼ�󰴷���˳���Ƚ��ȳ���ȡ�����õ�һ���µ�����
 * �ڶ��֣�����ʮλ���ֽ���ͬ�ϲ���
 * ...
 * �ظ�ֱ������������λ���õ���������У��Ѿ�����������
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
		//����һ����ά��������ģ��Ͱ
		int[][] temp = new int[10][arr.length];
		//����һ��һά�������ڴ��ÿ��Ͱ�е�Ԫ�ظ���
		int[] tempIndex = new int[10];
		//Ϊ�˷������������+ȡ�������������for�ټ���һ������
		//��һ��ѭ�������ڼ�¼���������ÿλ������Ӧһ������
		for(int i=0,n=1;i<maxLength;i++,n*=10) {
			//�ڶ���ѭ�������ڱ���������
			for(int j=0;j<arr.length;j++) {
				//��ÿ����ȡ��Ӧ���ִε�λ���ϵ���
				int ys = arr[j]/n%10;
				//���ݸ����ַ����ӦͰ
				temp[ys][tempIndex[ys]] = arr[j];
				tempIndex[ys]++;
			}
			//��Ͱ��������һ�ִε���Ͱ׼��
			//k���ڴ�0��ʼ��������9Ͱ
			//p��¼����arr�ĽǱ�
			int p = 0;
			for(int k=0;k<10;k++) {
				//tempIndex[k]ֻҪû--��0����˵����Ͱ�л�������
				//����һ��mȡͰ������
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
