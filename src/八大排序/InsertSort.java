package �˴�����;
import java.util.Arrays;

public class InsertSort {
/**
 * �˴�����֮2��������֮2.1ֱ�Ӳ�������
 * ˼�룺
 * �ӵ�һ������ʼ����
 * ����������ǰһ�����Ƚ�
 * �����С���򽻻����ߣ�Ȼ������ݹ�Ľ����ֵ�������ǰһ�����Ƚϣ��ݹ�ֱ���������ڵ���ǰһ����
 * ������ڻ������ֱ�ӽ�����һ�����ı�������Ϊ�ӵ�һ������ʼ���������Ե�i��������ʱ����ǰ��i-1�����Ѿ����������飩
 * @param args
 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = {4,5,2,1,3,23,43,21,3,4,2,1};
		InsertSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void InsertSort(int[] arr) {
		//i�����ӵ�һ����ָ�����һ����,����һ�����϶������ˣ����Դ�i=1��ʼ
		for(int i=1;i<arr.length;i++) {
			//ԭ�����i���������Ҫ�Ƚ�i-1�Σ���Ϊ����������i����С�ģ�
			int j = i-1;
			//arr[i]>=arr[i-1]�����i������ǰ������i-1���������飬����ֱ��continue
			if(arr[i]>=arr[j])
				continue;
			//ͨ���ݹ�j�ҵ�һ��arr[i]<arr[j]��λ��
			while(j>=0) {
				if(arr[i]<arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
				i--;
				j--;
			}
		}
	}
}
