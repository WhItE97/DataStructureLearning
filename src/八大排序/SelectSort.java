package �˴�����;
import java.util.Arrays;

public class SelectSort {
/**
 * �˴�����֮3.ѡ������ ֮3.3��ѡ������
 * ˼�룺
 * ���������ҵ�һ����С�����֣�Ų����һ��λ��
 * �ݹ����Ϲ���
 * @param args
 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = {1,3,2,5,4,1,1,2,4,2,34};
		SelectSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void SelectSort(int[] arr) {
		//��һ��ѭ�����������е���
		for(int i=0;i<arr.length;i++) {
			int min = arr[i];//��ʵҲ���Բ���¼minֵ����¼��min���±꼴��
			int min_posi = i;
			//�ڶ���ѭ�����Ըñ���������������������ģ���Ҫȫ���������бȽϣ����Ҽ�¼��min���±�index
			for(int j=i+1;j<arr.length;j++) {
				if(arr[j]<min) {
					min = arr[j];
					min_posi = j;
				}
			}
			int temp = arr[i];
			arr[i] =min;
			arr[min_posi] = temp;
		}
	}
}
