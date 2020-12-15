package �˴�����;
import java.util.Arrays;

public class ShellSort {
/**
 * �˴�����֮2.�������� ֮2.2ϣ������
 * ˼�룺
 * ������������в�������
 * ������ʼ=len/2
 * ֮����/2�ķ�ʽ���е���
 * ֱ������=0����ֹ����
 * @param args
 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = {5,7,6,23,4,3,3,1,5,7,6,23,54};
		ShellSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void ShellSort(int[] arr) {
		// ���ó�ʼ����
		// ��������Ҳ�С������� 
		// eg��arr.length=9 �� step=9/2=5����>����=5���ֳ���5��
		// ��������==������������⣺��������5�����һ���һ���͵�һ��ڶ��������4������������=��һ���һ��+4�������=5=����
		
		//��һ��ѭ�����ڱ���������ֱ������0
		for(int step=arr.length/2;step>0;step/=2) {
			//�ڶ���ѭ�����ڱ������У�!ע�������У����������򣬴�ÿ��ĵڶ���Ԫ�ؿ�ʼ��ǰ�ȣ���Ϊ��һ���Ѿ�Ĭ�������ˣ�Ԫ��
			for(int i=step;i<arr.length;i++) {
				//������ѭ�����ڱ��������е�����Ԫ��
				//j�ǵ�ǰԪ�أ�Ҫ���䵱ǰλ�ã�ÿ��-step��һֱ�Ƚϣ�ֱ�����������ڵ�λ�á���>����ÿһ�飬����ֱ�Ӳ�������Ĺ���
				for(int j=i;j>=step;j-=step) {
					if(arr[j]<arr[j-step]) {
						int temp = arr[j];
						arr[j] = arr[j-step];
						arr[j-step] = temp;
					}
//					//�Լ��ӵģ��о������ڲ���Ų��ʱ��ֱ��break��ȥ������continue�����ʡʱ��
//					else 
//						break;
				}
			}
		}
		
	}
}

/**
 * �������Լ���һ�εĴ�������
 *
//��һ��ѭ�����ڵ���������=0��ʱ���������
		for(int step=arr.length/2;step>0;step/=2) {
			//�ڶ���ѭ�����ڵ����ò�����������
			//group��0����+1��������>���һ��ĵ�һ��Ԫ�ء����������ˣ�������ֻ������ÿ���һ��Ԫ�ء�
			for(int group=0;group<step;group++) {
				//������ѭ�����õ�ÿ������׸�Ԫ�غ󣬶�ÿ�������ֱ�Ӳ�������
				for(int i=group;i<arr.length-step;i+=step) {
					//��ÿ�� �Ӹ����׸�Ԫ�ؿ�ʼ����
					//�����һ��Ԫ�ش��������򽻻�
					if(arr[i]>arr[i+step]) {
						int temp = arr[i+step];
						arr[i+step] = arr[i];
						arr[i] = temp;
					}
				}
			}
		}
*/
