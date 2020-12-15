package �˴�����;
import java.util.Arrays;

public class HeapSort {
/**
 * �˴�����֮3.ѡ������ ֮3.2������
 * ��������õ��󶥶ѣ�С���ѣ��������ṹ�����԰�������ѧϰ֮��
 * ˼�룺
 * 1.������תΪһ����ȫ������
 * 2.�Ը������д󶥶ѵ�ת��
 * ���󶥶�ת���������һ����Ҷ�ӽڵ㿪ʼ�����������ӱȽϣ�������ڵ��max���򽻻���
 * ��������������Ķ��ӽڵ㻹�ж��ӣ�����Ҫ�ڽ�������бȽ��뽻����
 * ������������з�Ҷ�ӽڵ㣬�������ϲ�����ֱ�����ڵ㣩
 * 3.������ĩβ��Ҷ�ӽ�����Ȼ��������һ��Ҷ�ӣ���Ϊmax
 * 4.��ʣ�µ����ظ�2.3���裬ֱ������
 * @param args
 */
	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		int[] arr = new int[]{9,6,8,7,0,1,10,4,2,22,2};
		HeapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	//maxHeapʵ�ֵ�ֻ�����indexһ��λ�ã����д󶥶ѵ�����Ҫ�������Ѷ������������ڵ��õ�ʱ�����ѭ���������з�Ҷ�ӽڵ㣡����
	//��ΪҪ��ν��д󶥶ѵĵ������̣�����Ҫ������ֶѵĴ�Сsize
	//�Լ�����maxHeap�����ĸ��ڵ㡪��>�������±�index
	public static void maxHeap(int[] arr,int size,int index) {
		//���ڽ����������������תΪ�󶥶�
		//ȡ�����Ӻ����ӣ����ܲ����ڣ����Լ���һ��max��װ�����������Ľڵ��±�
		int leftNode = 2*index+1;
		int rightNode = 2*index+2;
		int max = index;//�������max=��
		//��ʼ�ֱ��������ӱȽ�
		if(leftNode<size&&arr[leftNode]>arr[max]) {
			max = leftNode;
		}
		if(rightNode<size&&arr[rightNode]>arr[max]) {
			max = rightNode;
		}
		if(max!=index) {
			//������������ģ����нڵ�Ȩֵ�Ľ���
			int temp = arr[index];
			arr[index] = arr[max];
			arr[max] = temp;
			//HDP������λ�ú���ܻ��ƻ�֮ǰ�źõ���ſ���Ķ�##########################
			maxHeap(arr,size,max);//��Ϊmax��¼���Ǳ�����λ�õĽڵ��ԭ���꣬����Ҫ�Ը�λ�ý���maxHeap
		}
	}
	
	public static void HeapSort(int[] arr) {
		for(int size=arr.length;size>0;size--) {//��j�����ѵ�size
			for(int i=(size-2)/2;i>=0;i--) {
				maxHeap(arr,size,i);
			}
			//���ִ󶥶ѱ任��ɣ���ʼ��֦
			int temp = arr[size-1];
			arr[size-1] = arr[0];
			arr[0] = temp;
		}
	}
}
